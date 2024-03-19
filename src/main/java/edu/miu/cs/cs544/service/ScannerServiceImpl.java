package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.ScanRecordRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScannerServiceImpl
        extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Long>
        implements ScannerService {
    @Autowired
    private ScannerRepository scannerRepository;
    @Autowired
    private ScanRecordRepository scanRecordRepository;

    @Override
    public List<ScanRecordPayload> findAllScanRecordsByScannerId(Long scannerId) {
        return null;
    }

    @Override
    public SessionPayload getSessionForEvent(Long eventId, Long sessionId) {
        return null;
    }

    @Override
    public SessionPayload saveSessionForEvent(Long eventId, SessionPayload sessionPayload) {
        return null;
    }

    @Override
    public SessionPayload updateSessionInEvent(Long eventId, Long sessionId, SessionPayload sessionPayload) {
        return null;
    }

    @Override
    public String deleteSessionFromEvent(Long eventId, Long sessionId) {
        return null;
    }
}
