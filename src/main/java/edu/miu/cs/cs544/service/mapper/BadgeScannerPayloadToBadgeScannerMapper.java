package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Scanner;
import edu.miu.cs.cs544.service.contract.BadgeScannerPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class BadgeScannerPayloadToBadgeScannerMapper
        extends BaseMapper<BadgeScannerPayload, Scanner> {
    public BadgeScannerPayloadToBadgeScannerMapper(MapperFactory mapperFactory) {
        super(mapperFactory, BadgeScannerPayload.class, Scanner.class);
    }
}
