package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanRecordServiceImpl
        extends BaseReadWriteServiceImpl<ScanRecordPayload, ScanRecord, Long>
        implements ScanRecordService{
}
