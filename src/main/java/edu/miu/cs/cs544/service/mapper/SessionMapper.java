package edu.miu.cs.cs544.service.mapper;

import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.contract.SessionPayload;

public class SessionMapper {

    private SessionMapper(){}

    public static SessionPayload toSessionPayload(Session session){
        return SessionPayload.builder()
                .description(session.getDescription())
                .startDateTime(session.getStartDateTime())
                .endDateTime(session.getEndDateTime())
                .name(session.getName())
                .id(session.getId())
                .build();
    }

    public static Session toSession(SessionPayload sessionPayload){
        Session session = new Session();
        session.setName(sessionPayload.getName());
        session.setDescription(sessionPayload.getDescription());
        session.setStartDateTime(sessionPayload.getStartDateTime());
        session.setEndDateTime(sessionPayload.getEndDateTime());
        return session;
    }
}
