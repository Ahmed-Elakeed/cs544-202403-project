package edu.miu.cs.cs544.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.MemberService;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController extends BaseReadWriteController<MemberPayload, Member, Long> {

	private final MemberService memberService;
	
	
	@GetMapping(path = "/{memberId}/events/{eventId}/attendance")
    public ResponseEntity<?> attendanceForMemberByEvent(@PathVariable(value = "memberId") Long memberId,@PathVariable(value = "eventId") Long eventId){
        return ResponseEntity.ok(this.memberService.attendanceForMemberByEvent(memberId,eventId));
    }
}
