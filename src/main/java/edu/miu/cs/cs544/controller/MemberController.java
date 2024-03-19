package edu.miu.cs.cs544.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.MemberService;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.dto.SessionDTO;
import edu.miu.cs.cs544.service.mapper.SessionToSessionDTOMapper;



@RestController
@RequestMapping("/members")
public class MemberController extends BaseReadWriteController<MemberPayload, Member, Long> {

	@Autowired
	MemberService memberService;
	
	@Autowired
	SessionToSessionDTOMapper sessionToSessionDTOMapper;
	
	@GetMapping("/{memberId}/events/{eventId}/attendance")
	public ResponseEntity<?> getAttendanceByMemberAndEvent(@PathVariable Long memberId, @PathVariable Long eventId){
		List<Session> attendanceList = memberService.getAttendancebyMemberAndEvent(eventId, memberId);
		List<SessionDTO> sessionDTOList = attendanceList.stream().map(sessionToSessionDTOMapper::map)
				.collect(Collectors.toList());
		return new ResponseEntity<List<SessionDTO>>(sessionDTOList, HttpStatus.OK);
	}
}
