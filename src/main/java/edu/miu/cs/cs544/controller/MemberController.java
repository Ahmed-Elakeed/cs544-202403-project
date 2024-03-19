package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.service.MemberService;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;


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

    @GetMapping(path = "/{memberId}/attendance")
    public ResponseEntity<?> getAllSessionsForEvent(@PathVariable(value = "memberId") Long memberId) {
        return ResponseEntity.ok(this.memberService.getAttendence(memberId));
    }

    @GetMapping(path = "/{memberId}/events/{eventId}/attendance")
    public ResponseEntity<?> attendanceForMemberByEvent(@PathVariable(value = "memberId") Long memberId,@PathVariable(value = "eventId") Long eventId){
        return ResponseEntity.ok(this.memberService.attendanceForMemberByEvent(memberId,eventId));
    }
}
