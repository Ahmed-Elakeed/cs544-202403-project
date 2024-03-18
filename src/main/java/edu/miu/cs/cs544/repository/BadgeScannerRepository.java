package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.BadgeScanner;

import java.util.List;


public interface BadgeScannerRepository
        extends BaseRepository<BadgeScanner, Long> {
    List<BadgeScanner> findBadgeScannerByAccountType(AccountType accountType);;
}
