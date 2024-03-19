package edu.miu.cs.cs544.service.mapper;

import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.ScanRecord;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.ScanRecordPayload;

import java.time.LocalDateTime;

public class ScanRecordMapper {

    private ScanRecordMapper(){}

    public static ScanRecordPayload toScanRecordPayload(ScanRecord scanRecord){
        ScanRecordPayload scanRecordPayload = new ScanRecordPayload();
        scanRecordPayload.setId(scanRecord.getId());
        scanRecordPayload.setScanDateTime(scanRecord.getScanDateTime());
        scanRecordPayload.setMember(toMemberPayload(scanRecord.getMember()));
        scanRecordPayload.setSession(SessionMapper.toSessionPayload(scanRecord.getSession()));
        scanRecordPayload.setEvent(toEventPayload(scanRecord.getEvent()));
        return scanRecordPayload;
    }

    private static MemberPayload toMemberPayload(Member member){
        MemberPayload memberPayload = new MemberPayload();
        memberPayload.setId(member.getId());
        memberPayload.setFirstName(member.getFirstName());
        memberPayload.setLastName(member.getLastName());
        memberPayload.setEmail(member.getEmail());
        memberPayload.setBarcode(member.getBarcode());
        return memberPayload;
    }

    private static EventPayload toEventPayload(Event event){
        EventPayload eventPayload = new EventPayload();
        eventPayload.setId(event.getId());
        eventPayload.setName(event.getName());
        eventPayload.setDescription(event.getDescription());
        eventPayload.setAccountType(event.getAccountType());
        eventPayload.setStartDateTime(event.getStartDateTime());
        eventPayload.setEndDateTime(event.getEndDateTime());
        return eventPayload;
    }

    public static ScanRecord toScanRecord(ScanRecordPayload scanRecordPayload) {
        ScanRecord scanRecord = new ScanRecord();
        scanRecord.setId(scanRecordPayload.getId());
        scanRecord.setScanDateTime(LocalDateTime.now());
        Member member =new Member();
        member.setId(scanRecordPayload.getMember().getId());
        scanRecord.setMember(member);
        Session session = new Session();
        session.setId(scanRecordPayload.getSession().getId());
        scanRecord.setSession(session);
        Event event = new Event();
        event.setId(scanRecordPayload.getEvent().getId());
        scanRecord.setEvent(event);
        return scanRecord;
    }
}

