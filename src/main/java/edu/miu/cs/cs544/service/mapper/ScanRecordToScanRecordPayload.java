package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;
import ma.glasnost.orika.MapperFactory;

public class ScanRecordToScanRecordPayload
        extends BaseMapper<ScanRecord, ScanRecordPayload> {
    public ScanRecordToScanRecordPayload(MapperFactory mapperFactory){
        super(mapperFactory, ScanRecord.class, ScanRecordPayload.class);
    }
}
