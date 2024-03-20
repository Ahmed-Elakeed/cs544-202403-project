package edu.miu.cs.cs544.service.mapper;

import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;

public class MemberMapper {
    private MemberMapper(){}

    public static MemberPayload toMemberPayload(Member member){
        return MemberPayload.builder()
                .email(member.getEmail())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .barcode(member.getBarcode())
                .id(member.getId())
                .build();

    }

    public static Member toMember(MemberPayload memberPayload){
        Member member = new Member();
        member.setEmail(memberPayload.getEmail());
        member.setBarcode(memberPayload.getBarcode());
        member.setFirstName(memberPayload.getFirstName());
        member.setLastName(memberPayload.getLastName());
        return member;
    }
}
