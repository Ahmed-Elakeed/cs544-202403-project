package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ScannerService
        extends BaseReadWriteService<ScannerPayload, Scanner, Long> {
//    ScannerPayload findScannerByScannerCode(String scannerCode);
    List<ScanRecordPayload> getAllScanRecordsByScannerCode(String scannerID);

    ScanRecordPayload getScanRecordByScannerCodeAndRecordId(String scannerCode, Long recordId);

    String deleteScanRecordByScannerCodeAndRecordId(String scannerID, Long recordId);

    ScanRecordPayload createRecordForScanner(String scannerCode, ScanRecordPayload scanRecordPayload);
}
