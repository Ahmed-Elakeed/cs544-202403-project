package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.exception.NotFoundException;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import edu.miu.cs.cs544.service.mapper.ScanRecordMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScannerServiceImpl
        extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Long>
        implements ScannerService {

    private final ScannerRepository scannerRepository;

    private final EventRepository eventRepository;


    public ScannerServiceImpl(ScannerRepository scannerRepository, EventRepository eventRepository) {
        this.scannerRepository = scannerRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<ScanRecordPayload> getAllScanRecordsByScannerCode(String scannerCode) {
        Optional<Scanner> scannerOptional = this.scannerRepository.findScannerByScannerCode(scannerCode);
        if (scannerOptional.isPresent()) {
            return scannerOptional.map(scanner -> scanner
                    .getScanRecordList()
                    .stream()
                    .map(ScanRecordMapper::toScanRecordPayload)
                    .toList()).orElseGet(ArrayList::new);
        }
        throw new NotFoundException("Scanner doesn't exist");
    }

    @Override
    public ScanRecordPayload getScanRecordByScannerCodeAndRecordId(String scannerCode, Long recordId) {
        Optional<Scanner> scannerOptional = this.scannerRepository.findScannerByScannerCode(scannerCode);
        if (scannerOptional.isPresent()) {
            Scanner scanner = scannerOptional.get();
            Optional<ScanRecord> scanRecordOptional = scanner.getScanRecordList()
                    .stream()
                    .filter(scanRecord -> scanRecord.getId().equals(recordId))
                    .findFirst();
            if (scanRecordOptional.isPresent()) {
                return ScanRecordMapper.toScanRecordPayload(scanRecordOptional.get());
            }
        }
        throw new NotFoundException("Scanner or record not exist");
    }

    @Override
    public String deleteScanRecordByScannerCodeAndRecordId(String scannerCode, Long recordId) {
        Optional<Scanner> scannerOptional = this.scannerRepository.findScannerByScannerCode(scannerCode);
        if (scannerOptional.isPresent()) {
            this.scannerRepository.deleteScanRecord(scannerOptional.get().getId(), recordId);
            return "Record deleted";
        }
        return "Scanner doesn't exist";
    }

    @Override
    public ScanRecordPayload createRecordForScanner(String scannerCode, ScanRecordPayload scanRecordPayload) {
        Optional<Scanner> scannerOptional = this.scannerRepository.findScannerByScannerCode(scannerCode);

        if (scannerOptional.isPresent()) {
            Scanner scanner = scannerOptional.get();
            Optional<Event> eventOptional = this.eventRepository.findById(scanRecordPayload.getEvent().getId());
            if (eventOptional.isPresent()) {
                Event event = eventOptional.get();
                long isRegistered = event.getMembers().stream().filter(member -> member.getId().equals(scanRecordPayload.getMember().getId())).count();
                long isValidSession = event.getSchedule().getSessions().stream().filter(session -> session.getId().equals(scanRecordPayload.getSession().getId())).count();
                if (isRegistered == 0 || isValidSession == 0) {
                    if (isRegistered == 0) {
                        throw new NotFoundException("This member is not registered to this event");
                    } else {
                        throw new NotFoundException("This session is not belong to this event");
                    }
                }
            }else{
                throw new NotFoundException("This event is not exist");
            }
            scanner.getScanRecordList().add(ScanRecordMapper.toScanRecord(scanRecordPayload));
            this.scannerRepository.saveIntoMemberSession(scanRecordPayload.getMember().getId(), scanRecordPayload.getSession().getId());
            this.scannerRepository.save(scanner);
            return scanRecordPayload;
        } else {
            throw new NotFoundException("Scanner not found");
        }
    }
}
