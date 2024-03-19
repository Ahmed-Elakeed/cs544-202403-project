package edu.miu.cs.cs544.service.mapper;

import org.springframework.stereotype.Component;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.dto.SessionDTO;
import ma.glasnost.orika.MapperFactory;

@Component
public class SessionToSessionDTOMapper extends BaseMapper<Session, SessionDTO>{
	public SessionToSessionDTOMapper (MapperFactory mapperFactory) {
		super(mapperFactory, Session.class, SessionDTO.class);
	}
}
