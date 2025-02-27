package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Location;
import edu.miu.cs.cs544.service.contract.LocationPayload;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;

@Service
public class LocationServiceImpl extends BaseReadWriteServiceImpl<LocationPayload, Location, Long> implements LocationService {

}
