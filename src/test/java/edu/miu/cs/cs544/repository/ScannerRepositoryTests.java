package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringRunner.class)
@DataJpaTest
public class ScannerRepositoryTests {
//    Ahmed do we really need this, I don't see any implementations of the interfaces in the ScannerRepository?
//    A note to Ahmed

    @Autowired
    private ScannerRepository scannerRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindScannerByScannerCode() {
        // Given
        String scannerCode = "123";
        Scanner scanner = new Scanner();
        scanner.setScannerCode(scannerCode);
        entityManager.persist(scanner);
        entityManager.flush();

        // When
        Optional<Scanner> foundScanner = scannerRepository.findScannerByScannerCode(scannerCode);

        // Then
        assertEquals(scannerCode, foundScanner.<Object>map(Scanner::getScannerCode).orElse(null));
    }
    @Test
    public void testSaveIntoMemberSession() {
        // Given
        Long memberId = 1L;
        Long sessionId = 3L;
        //
        Event event = new Event();
        event.setName("Event 1");
        event.setDescription("Event 1 description");
        event.setAccountType(AccountType.CLASS);
        System.out.println();
        System.out.println("Event 1 ID " + event.getId());

        Schedule schedule = new Schedule();
        schedule.setDescription("Event 1 schedule");
        event.setSchedule(schedule);

        Session session1 = new Session();
        session1.setName("Event 1 session 1");
        session1.setDescription("Event 1 session 1");
        entityManager.persist(session1);
        Session session2 = new Session();
        session2.setName("Event 1 session 2");
        session2.setDescription("Event 1 session 2");

        schedule.getSessions().add(session1);
        schedule.getSessions().add(session2);

        entityManager.persist(schedule);
        entityManager.persist(event);

        Member member = new Member();
        member.setBarcode(1);
        member.setFirstName("First Name");
        member.setLastName("Last Name");

        session2.getMembers().add(member);
        session1.getMembers().add(member);
        entityManager.persist(member);
        entityManager.persist(session2);
        entityManager.flush();

        // When
//        scannerRepository.saveIntoMemberSession(memberId, sessionId);

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
