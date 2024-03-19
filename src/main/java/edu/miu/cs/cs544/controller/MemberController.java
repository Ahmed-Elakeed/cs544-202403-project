package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.MemberService;
import edu.miu.cs.cs544.service.mapper.MemberPayloadToMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;


@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController extends BaseReadWriteController<MemberPayload, Member, Long> {

    private final MemberService memberService;
    @GetMapping(path = "/{memberId}/roles")
    public ResponseEntity<?> getAllRoles(@PathVariable(value = "memberId") Long memberId) {
        return ResponseEntity.ok(this.memberService.getAllRolesForMember(memberId));
    }

    @GetMapping(path = "/{memberId}/roles/{roleId}")
    public ResponseEntity<?> getRoleForMember(@PathVariable(value = "memberId") Long memberId,@PathVariable(value = "roleId") Long roleId) {
        return ResponseEntity.ok(this.memberService.getRoleForMember(memberId,roleId));
    }

    @PostMapping(path = "/{memberId}/roles")
    public ResponseEntity<?> createRole(@PathVariable(value = "memberId") Long memberId,@RequestBody Role role) {
        return ResponseEntity.ok(this.memberService.createRole(memberId,role));
    }

    @PutMapping("/{memberId}/roles")
    public ResponseEntity<?> updateRole(@PathVariable(value = "memberId") Long memberId, @RequestBody Role role) {
        return ResponseEntity.ok(this.memberService.updateRole(memberId, role));
    }

    @DeleteMapping("/{memberId}/roles/{roleId}")
    public ResponseEntity<?> deleteRole(@PathVariable(value = "memberId") Long memberId, @PathVariable(value = "roleId") Long roleId) {
        return ResponseEntity.ok(this.memberService.deleteRoleForMember(memberId,roleId));
    }

    private final MemberService memberService;
    @GetMapping(path = "/{memberId}/attendance")
    public ResponseEntity<?> getAllSessionsForEvent(@PathVariable(value = "memberId") Long memberId) {
        return ResponseEntity.ok(this.memberService.getAttendence(memberId));
    }
}
