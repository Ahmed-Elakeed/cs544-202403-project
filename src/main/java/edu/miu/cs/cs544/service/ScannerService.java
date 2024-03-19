package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;

import java.util.List;

public interface ScannerService
        extends BaseReadWriteService<ScannerPayload, Scanner, Long> {
    List<ScanRecordPayload> getAllScanRecordsByScannerID(Long scannerID);

    ScanRecordPayload getScanRecordByScannerIDAndId(Long scannerID, Long recordId);

    void deleteScanRecordByScannerIDAndID(String scannerID, Long recordId);
}
