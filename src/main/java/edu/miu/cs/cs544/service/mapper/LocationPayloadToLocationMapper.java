package edu.miu.cs.cs544.service.mapper;

import edu.miu.cs.cs544.domain.Location;
import edu.miu.cs.cs544.service.contract.LocationPayload;
import org.springframework.stereotype.Component;

import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;

@Component
public class LocationPayloadToLocationMapper extends BaseMapper<LocationPayload, Location>{


    public LocationPayloadToLocationMapper(MapperFactory mapperFactory) {
        super(mapperFactory, LocationPayload.class, Location.class);
    }
}
