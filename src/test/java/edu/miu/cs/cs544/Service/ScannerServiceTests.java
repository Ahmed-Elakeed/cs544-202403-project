package edu.miu.cs.cs544.Service;

import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.repository.ScanRecordRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import edu.miu.cs.cs544.service.ScannerService;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Appendable.class)
@AutoConfigureMockMvc
public class ScannerServiceTests {
    @Mock
    private ScannerRepository scannerRepository;
    @Mock
    private ScanRecordRepository scanRecordRepository;

    @InjectMocks
    private ScannerService scannerService;

    @Test
    public void testGetScanRecordByScannerCodeAndRecordId_Success() {
        // Give
        String scannerCode = "123";
        Long recordId = 1L;
        ScanRecord scanRecord = new ScanRecord();
        scanRecord.setId(recordId);
        when(scannerRepository.findScannerByScannerCode(scannerCode)).thenReturn(Optional.of(new Scanner()));
        when(scanRecordRepository.findById(recordId)).thenReturn(Optional.of(scanRecord));

        // When
        ScanRecordPayload result = scannerService.getScanRecordByScannerCodeAndRecordId(scannerCode, recordId);

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
        assertThrows(NotFoundException.class, () ->
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
        assertThrows(NotFoundException.class, () ->
                scannerService.getScanRecordByScannerCodeAndRecordId(scannerCode, recordId));
    }

    @Test
    public void testDeleteScanRecordByScannerCodeAndRecordId_Success() {
        // Give
        String scannerCode = "123";
        Long recordId = 1L;
        Scanner scanner = new Scanner();
        scanner.setId(1L);
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
        when(scannerRepository.findScannerByScannerCode(scannerCode)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(NotFoundException.class, () ->
                scannerService.deleteScanRecordByScannerCodeAndRecordId(scannerCode, recordId));
        verify(scannerRepository, never()).deleteScanRecord(anyLong(), anyLong());
    }
}
