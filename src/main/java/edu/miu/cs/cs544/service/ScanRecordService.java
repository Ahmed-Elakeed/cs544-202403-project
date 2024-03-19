package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;

public interface ScanRecordService
        extends BaseReadWriteService<ScanRecordPayload, ScanRecord, Long> {
}
