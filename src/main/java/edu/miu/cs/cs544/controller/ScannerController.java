package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.ScannerService;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scanners")
@RequiredArgsConstructor
public class ScannerController
        extends BaseReadWriteController<ScannerPayload, Scanner, Long> {

    private ScannerService scannerService;

    @Autowired
    public ScannerController(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    @GetMapping("/{scannerID}/records")
    public ResponseEntity<List<ScanRecordPayload>> getAllScanRecords(
            @PathVariable Long scannerID
    ) {
        List<ScanRecordPayload> scanRecords = scannerService.getAllScanRecordsByScannerID(scannerID);
        return ResponseEntity.ok(scanRecords);
    }

    @GetMapping("/{scannerID}/records/{recordId}")
    public ResponseEntity<ScanRecordPayload> getScanRecordByScannerIdAndID(
            @PathVariable Long scannerID,
            @PathVariable Long recordId
    ) {
        ScanRecordPayload scanRecord = scannerService.getScanRecordByScannerIDAndId(scannerID, recordId);
        return ResponseEntity.ok(scanRecord);
    }
    @DeleteMapping("/{scannerID}/records/{recordId}")
    public ResponseEntity<Void> deleteScanRecordByScannerIDAndID(
            @PathVariable String scannerID,
            @PathVariable Long recordId
    ) {
        scannerService.deleteScanRecordByScannerIDAndID(scannerID, recordId);
        return ResponseEntity.noContent().build();
    }
}
