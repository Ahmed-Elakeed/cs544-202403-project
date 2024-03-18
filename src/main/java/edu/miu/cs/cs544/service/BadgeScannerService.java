package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.BadgeScanner;
import edu.miu.cs.cs544.service.contract.BadgeScannerPayload;

public interface BadgeScannerService
        extends BaseReadWriteService<BadgeScannerPayload, BadgeScanner, Long> {
    BadgeScanner create(BadgeScanner badgeScanner);
}
