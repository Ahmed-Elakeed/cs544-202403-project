package edu.miu.cs.cs544.Repository;

import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.ScannerRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DataJpaTest
public class ScannerRepositoryTests {
//    Ahmed do we really need this, I don't see any implementations of the interfaces in the ScannerRepository?
//    A note to Ahmed

    @Autowired
    private ScannerRepository scannerRepository;
    @Test
    public void testFindScannerByScannerCode() {
        // Given
        String scannerCode = "123";
        Scanner scanner = new Scanner();
        scanner.setScannerCode(scannerCode);
        scannerRepository.save(scanner);

        // When
        Optional<Scanner> foundScanner = scannerRepository.findScannerByScannerCode(scannerCode);

        // Then
        assertEquals(scannerCode, foundScanner.<Object>map(Scanner::getScannerCode).orElse(null));
    }
    @Test
    public void testSaveIntoMemberSession() {
        // Given
        Long memberId = 1L;
        Long sessionId = 1L;

        // When
        scannerRepository.saveIntoMemberSession(memberId, sessionId);

        // Then
        // You can add assertions here if required, such as verifying data integrity in the database
        // because we are using Transactional
        assertTrue(true); // Placeholder assertion
    }

    @Test
    public void testDeleteScanRecord() {
        // Given
        Long scannerId = 1L; // Assuming this scanner ID exists in the database
        Long recordId = 1L; // Assuming this record ID exists in the database

        // When
        scannerRepository.deleteScanRecord(scannerId, recordId);

        // Then
        // You can add assertions here if required, such as verifying data integrity in the database
        // because we are using Transactional
        assertTrue(true); // Placeholder assertion
    }
}
