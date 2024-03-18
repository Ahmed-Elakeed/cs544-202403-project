package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.BadgeScanner;
import edu.miu.cs.cs544.repository.BadgeScannerRepository;
import edu.miu.cs.cs544.service.contract.BadgeScannerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeScannerServiceImpl
        extends BaseReadWriteServiceImpl<BadgeScannerPayload, BadgeScanner, Long>
        implements BadgeScannerService {
    @Autowired
    private BadgeScannerRepository badgeScannerRepository;

    @Override
    public List<BadgeScannerPayload> findAll() {
        return super.findAll();
    }

    @Override
    public BadgeScanner create(BadgeScanner badgeScanner) {
        return badgeScannerRepository.save(badgeScanner);
    }
}
