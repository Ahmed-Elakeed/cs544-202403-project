package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Long> implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public List<Role> getAllRolesForMember(Long memberId) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            return member.getRoles();
        }
        return new ArrayList<>();
    }

    @Override
    public Role getRoleForMember(Long memberId, Long roleId) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            Optional<Role> roleOptional = member.getRoles().stream().filter(role -> role.getId().equals(roleId))
                    .findFirst();
            if(roleOptional.isPresent()){
                return roleOptional.get();
            }
        }
        return null;
    }

    @Override
    public Role createRole(Long memberId, Role role) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.getRoles().add(role);
            this.memberRepository.save(member);
            return role;
        }
        return null;
    }

    @Override
    public Role updateRole(Long memberId, Role inputRole) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            Optional<Role> roleOptional = member.getRoles().stream().filter(role -> role.getId().equals(inputRole.getId()))
                    .findFirst();
            roleOptional.ifPresent(role -> role.setRole(inputRole.getRole()));
            this.memberRepository.save(member);
            return inputRole;
        }
        return null;
    }

    @Override
    public String deleteRoleForMember(Long memberId, Long roleId) {
        Optional<Member> memberOptional = this.memberRepository.findById(memberId);
        if(memberOptional.isPresent()) {
            Member member = memberOptional.get();
            this.memberRepository.deleteRoleForMember(memberId,roleId);
            return "Deleted";
        }
        return "Member not found";
    }
}
