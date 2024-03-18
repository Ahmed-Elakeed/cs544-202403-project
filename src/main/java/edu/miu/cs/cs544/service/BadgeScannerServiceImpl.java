package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.BadgeScannerRepository;
import edu.miu.cs.cs544.service.contract.BadgeScannerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeScannerServiceImpl
        extends BaseReadWriteServiceImpl<BadgeScannerPayload, Scanner, Long>
        implements BadgeScannerService {
    @Autowired
    private BadgeScannerRepository badgeScannerRepository;

    @Override
    public List<BadgeScannerPayload> findAll() {
        return super.findAll();
    }

    @Override
    public Scanner create(Scanner scanner) {
        return badgeScannerRepository.save(scanner);
    }
}
