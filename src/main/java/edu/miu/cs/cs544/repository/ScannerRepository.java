package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Scanner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


public interface ScannerRepository
        extends BaseRepository<Scanner, Long> {

    Optional<Scanner> findScannerByScannerCode(String scannerCode);

    @Query(value = "insert into member_sessions(member_id,session_id) values(:memberId,:sessionId)",nativeQuery = true)
    @Modifying
    @Transactional
    void saveIntoMemberSession(@Param(value = "memberId") Long memberId,@Param(value = "sessionId") Long sessionId);


    @Query(value = "delete from scan_records sr where sr.scanner_id = :scannerId && sr.id = :recordId",nativeQuery = true)
    @Modifying
    @Transactional
    void deleteScanRecord(Long scannerId, Long recordId);
}
