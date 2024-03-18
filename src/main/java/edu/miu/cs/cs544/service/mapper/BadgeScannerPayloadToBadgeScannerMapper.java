package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.BadgeScanner;
import edu.miu.cs.cs544.service.contract.BadgeScannerPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class BadgeScannerPayloadToBadgeScannerMapper
        extends BaseMapper<BadgeScannerPayload, BadgeScanner> {
    public BadgeScannerPayloadToBadgeScannerMapper(MapperFactory mapperFactory) {
        super(mapperFactory, BadgeScannerPayload.class, BadgeScanner.class);
    }
}
