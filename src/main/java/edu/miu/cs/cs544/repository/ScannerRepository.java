package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Scanner;

import java.util.List;


public interface ScannerRepository
        extends BaseRepository<Scanner, Long> {
    List<Scanner> findBadgeScannerByAccountType(AccountType accountType);;
}
