package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.ScanRecordRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScannerServiceImpl
        extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Long>
        implements ScannerService {

    @Autowired
    private ScannerRepository scannerRepository;
    @Override
    public List<ScanRecordPayload> getAllScanRecordsByScannerID(Long scannerID) {
        return scannerRepository.getAllScanRecordsByScannerCode(scannerID);
    }

    @Override
    public ScanRecordPayload getScanRecordByScannerIDAndId(Long scannerID, Long recordId) {
        return scannerRepository.getScanRecordByScannerIDAndID(scannerID, recordId);
    }

    @Override
    public void deleteScanRecordByScannerIDAndID(String scannerID, Long recordId) {
        scannerRepository.deleteScanRecordByScannerIDAndID(scannerID, recordId);
    }

}
