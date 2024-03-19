package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;

import java.util.List;

public interface ScannerService
        extends BaseReadWriteService<ScannerPayload, Scanner, Long> {
    List<ScanRecordPayload> getAllScanRecordsByScannerCode(String scannerID);

    ScanRecordPayload getScanRecordByScannerCodeAndRecordId(String scannerCode, Long recordId);

    String deleteScanRecordByScannerCodeAndRecordId(String scannerID, Long recordId);

    ScanRecordPayload createRecordForScanner(String scannerCode, ScanRecordPayload scanRecordPayload);
}
