package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ScannerRepository
        extends BaseRepository<Scanner, Long> {
    @Query("SELECT new edu.miu.cs.cs544.service.contract.ScanRecordPayload" +
            "(sr.id, sr.scanDateTime, sr.recordOwner, sr.recordScanner) " +
            "FROM scan_records sr WHERE sr.recordScanner.id = :scannerID")
    List<ScanRecordPayload> getAllScanRecordsByScannerCode(
            @Param("scannerID") Long scannerID);

    @Query("SELECT new edu.miu.cs.cs544.service.contract.ScanRecordPayload" +
            "(sr.id, sr.scanDateTime, sr.recordOwner, sr.recordScanner) " +
            "FROM scan_records sr WHERE sr.recordScanner.id = :scannerID AND sr.id = :recordID")
    ScanRecordPayload getScanRecordByScannerIDAndID(
            @Param("scannerID") Long scannerID,
            @Param("recordID") Long recordID);

    @Transactional
    @Modifying
    @Query("delete from scan_records sr where sr.recordScanner = :scannerID and sr.id = :recordId")
    void deleteScanRecordByScannerIDAndID(
            @Param("scannerID") String scannerID,
            @Param("recordId") Long recordId);

}
