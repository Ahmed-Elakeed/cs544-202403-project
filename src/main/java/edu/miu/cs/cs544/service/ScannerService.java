package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;

import java.util.List;

public interface ScannerService
        extends BaseReadWriteService<ScannerPayload, Scanner, Long> {

    // get all the records by a scannerID
    List<ScanRecordPayload> findAllScanRecordsByScannerId(Long scannerId);

    SessionPayload getSessionForEvent(Long eventId, Long sessionId);

    SessionPayload saveSessionForEvent(Long eventId, SessionPayload sessionPayload);

    SessionPayload updateSessionInEvent(Long eventId, Long sessionId, SessionPayload sessionPayload);

    String deleteSessionFromEvent(Long eventId, Long sessionId);
}
