package edu.miu.cs.cs544.service;


import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.EventRepository;
import edu.miu.cs.cs544.repository.ScanRecordRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import edu.miu.cs.cs544.service.contract.ScannerPayload;
import javassist.NotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Appendable.class)
//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ScannerServiceTest {
    @MockBean
    private ScannerRepository scannerRepository;
    @MockBean
    private ScanRecordRepository scanRecordRepository;
    @Autowired
    private ScannerService scannerService;

    @MockBean
    EventRepository eventRepository;

    @TestConfiguration
    static class ScannerServiceImplTestContextConfiguration {
//        AccountServiceImplTestContextConfiguration {

        @Bean
        public ScannerService scannerService(ScannerRepository scannerRepository, EventRepository eventRepository) {
            return new ScannerServiceImpl(scannerRepository,eventRepository);
        }
    }

    @MockBean
    private BaseMapper<Scanner, ScannerPayload> scannerToScannerPayloadMapper;

    @MockBean
    private BaseMapper<ScannerPayload, Scanner> accountPayloadToAccountMapper;
    @BeforeEach
    public void setUp() throws Exception {

    }
    @Test
    public void testGetScanRecordByScannerCodeAndRecordId_Success() throws NotFoundException {
        // Given
        String scannerCode = "123";
        Long recordId = 1L;
        Member member = new Member();
        member.setBarcode(1);
        Session session =new Session();
        Event event = new Event();
        ScanRecord scanRecord = new ScanRecord();
        scanRecord.setMember(member);
        scanRecord.setSession(session);
        scanRecord.setEvent(event);
        Scanner scanner = new Scanner();
        scanner.setScannerCode(scannerCode);
        scanRecord.setId(recordId);
        List<ScanRecord> scanRecords =new ArrayList<>();
        scanRecords.add(scanRecord);
        scanner.setScanRecordList(scanRecords);
        when(scannerRepository.findScannerByScannerCode(scannerCode)).thenReturn(Optional.of(scanner));
        when(scanRecordRepository.findById(recordId)).thenReturn(Optional.of(scanRecord));

        // When
        ScanRecordPayload result = scannerService
                .getScanRecordByScannerCodeAndRecordId(scannerCode, recordId);

        // Then
        assertNotNull(result);
        assertEquals(recordId, result.getId());
    }
    @Test
    public void testGetScanRecordByScannerCodeAndRecordId_ScannerNotFound() {
        // Give
        String scannerCode = "123";
        Long recordId = 1L;
        when(scannerRepository.findScannerByScannerCode(scannerCode)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(edu.miu.cs.cs544.exception.NotFoundException.class, () ->
                scannerService.getScanRecordByScannerCodeAndRecordId(scannerCode, recordId));
    }

    @Test
    public void testGetScanRecordByScannerCodeAndRecordId_RecordNotFound() {
        // Give
        String scannerCode = "123";
        Long recordId = 1L;
        when(scannerRepository.findScannerByScannerCode(scannerCode)).thenReturn(Optional.of(new Scanner()));
        when(scanRecordRepository.findById(recordId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(edu.miu.cs.cs544.exception.NotFoundException.class, () ->
                scannerService.getScanRecordByScannerCodeAndRecordId(scannerCode, recordId));
    }

    @Test
    public void testDeleteScanRecordByScannerCodeAndRecordId_Success() {
        // Give
        String scannerCode = "123";
        Long recordId = 1L;
        Scanner scanner = new Scanner();
        scanner.setId(1L);
        scanner.setScannerCode(scannerCode);
        when(scannerRepository.findScannerByScannerCode(scannerCode)).thenReturn(Optional.of(scanner));

        // When
        String result = scannerService.deleteScanRecordByScannerCodeAndRecordId(scannerCode, recordId);

        // Then
        assertEquals("Record deleted", result);
        verify(scannerRepository, times(1)).deleteScanRecord(scanner.getId(), recordId);
    }

    @Test
    public void testDeleteScanRecordByScannerCodeAndRecordId_ScannerNotFound() {
        // Given
        String scannerCode = "123";
        Long recordId = 1L;
        Scanner scanner = new Scanner();
        scanner.setId(1L);
        when(scannerRepository.findScannerByScannerCode(scannerCode)).thenReturn(Optional.empty());

        // When
        String result = scannerService.deleteScanRecordByScannerCodeAndRecordId(scannerCode, recordId);

        // Then
        assertEquals("Scanner doesn't exist", result);
        verify(scannerRepository, never()).deleteScanRecord(anyLong(), anyLong());
    }

}
