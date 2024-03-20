package edu.miu.cs.cs544.Controller;

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

    @GetMapping("/{scannerCode}/records")
    public ResponseEntity<List<ScanRecordPayload>> getAllScanRecords(
            @PathVariable String scannerCode
    ) {
        List<ScanRecordPayload> scanRecords = scannerService.getAllScanRecordsByScannerCode(scannerCode);
        return ResponseEntity.ok(scanRecords);
    }

    @GetMapping("/{scannerCode}/records/{recordId}")
    public ResponseEntity<ScanRecordPayload> getScanRecordByScannerCodeAndRecordId(
            @PathVariable String scannerCode,
            @PathVariable Long recordId
    ) {
        ScanRecordPayload scanRecord = scannerService.getScanRecordByScannerCodeAndRecordId(scannerCode, recordId);
        return ResponseEntity.ok(scanRecord);
    }
    @PostMapping(path = "/{scannerCode}/records")
    public ResponseEntity<ScanRecordPayload> addRecordToScanner(
            @PathVariable(value = "scannerCode") String scannerCode,
            @RequestBody ScanRecordPayload scanRecordPayload){
        return ResponseEntity.ok(this.scannerService.createRecordForScanner(scannerCode,scanRecordPayload));
    }
    @DeleteMapping("/{scannerCode}/records/{recordId}")
    public ResponseEntity<String> deleteScanRecordByScannerCodeAndRecordId(
            @PathVariable String scannerCode,
            @PathVariable Long recordId
    ) {
        scannerService.deleteScanRecordByScannerCodeAndRecordId(scannerCode, recordId);
        return ResponseEntity.ok(this.scannerService.deleteScanRecordByScannerCodeAndRecordId(scannerCode,recordId));
    }
}
