package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScannerServiceImpl
        extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Long>
        implements ScannerService {
    @Autowired
    private ScannerRepository scannerRepository;

    @Override
    public List<ScannerPayload> findAll() {
        return super.findAll();
    }

    @Override
    public Scanner create(Scanner scanner) {
        return scannerRepository.save(scanner);
    }
}
