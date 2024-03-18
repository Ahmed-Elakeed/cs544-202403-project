package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.BadgeScanner;
import edu.miu.cs.cs544.service.contract.BadgeScannerPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class BadgeScannerToBadgeScannerPayloadMapper
        extends BaseMapper<BadgeScanner, BadgeScannerPayload> {
    public BadgeScannerToBadgeScannerPayloadMapper(MapperFactory mapperFactory){
        super(mapperFactory, BadgeScanner.class, BadgeScannerPayload.class);
    }
}
