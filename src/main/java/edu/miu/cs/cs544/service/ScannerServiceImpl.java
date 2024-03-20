package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.exception.NotFoundException;
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

    public ScannerServiceImpl(ScannerRepository scannerRepository) {
        this.scannerRepository = scannerRepository;
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
        throw new NotFoundException("Scanner not found");
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
        throw new NotFoundException("Scanner or record doesn't exist");
    }

    @Override
    public String deleteScanRecordByScannerCodeAndRecordId(String scannerCode, Long recordId) {
        Optional<Scanner> scannerOptional = this.scannerRepository.findScannerByScannerCode(scannerCode);
        if (scannerOptional.isPresent()) {
            this.scannerRepository.deleteScanRecord(scannerOptional.get().getId(), recordId);
            return "Record deleted";
        }
        return "Scanner doesn't found";
    }

    @Override
    public ScanRecordPayload createRecordForScanner(String scannerCode, ScanRecordPayload scanRecordPayload) {
        Optional<Scanner> scannerOptional = this.scannerRepository.findScannerByScannerCode(scannerCode);
        try {
            if(scannerOptional.isPresent()) {
                Scanner scanner = scannerOptional.get();
                scanner.getScanRecordList().add(ScanRecordMapper.toScanRecord(scanRecordPayload));
                this.scannerRepository.saveIntoMemberSession(scanRecordPayload.getMember().getId(), scanRecordPayload.getSession().getId());
//                this.scannerRepository.createRecord(
//                        LocalDateTime.now(),
//                        scanRecordPayload.getEvent().getId(),
//                        scanRecordPayload.getSession().getId(),
//                        scanRecordPayload.getMember().getId(),
//                        scanner.getId()
//                );
                this.scannerRepository.save(scanner);
                return scanRecordPayload;
            }else{
                throw new NotFoundException("Scanner not found");
            }
        } catch (Exception exception) {
            if (scannerOptional.isPresent()) {
                throw new NotFoundException("Event, session, member or all don't exist");
            }
            throw new NotFoundException("Scanner not found");
        }
    }
}
