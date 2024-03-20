package edu.miu.cs.cs544.controller;


import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.service.EventService;
import edu.miu.cs.cs544.service.contract.EventPayload;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController extends BaseReadWriteController<EventPayload, Event, Long> {

    private final EventService eventService;

    @GetMapping(path="/{eventId}/attendance")
    public ResponseEntity<?> getAttendanceByEventId(@PathVariable(value = "eventId") Long eventId){
      return ResponseEntity.ok(this.eventService.getAttendanceForEvent(eventId));
    }

    @GetMapping(path = "/{eventId}/sessions")
    public ResponseEntity<?> getAllSessionsForEvent(@PathVariable(value = "eventId") Long eventId) {
        return ResponseEntity.ok(this.eventService.getAllSessionsForEvent(eventId));
    }

    @GetMapping(path = "/{eventId}/sessions/{sessionId}")
    public ResponseEntity<?> getSessionForEvent(@PathVariable(value = "eventId") Long eventId, @PathVariable(value = "sessionId") Long sessionId) {
        return ResponseEntity.ok(this.eventService.getSessionForEvent(eventId, sessionId));
    }

    @PostMapping(path = "/{eventId}/sessions")
    public ResponseEntity<?> saveSessionForEvent(@PathVariable(value = "eventId") Long eventId, @RequestBody SessionPayload sessionPayload) {
        return ResponseEntity.ok(this.eventService.saveSessionForEvent(eventId, sessionPayload));
    }

    @PutMapping(path = "/{eventId}/sessions/{sessionId}")
    public ResponseEntity<?> updateSessionInEvent(@PathVariable(value = "eventId") Long eventId, @PathVariable(value = "sessionId") Long sessionId,@RequestBody SessionPayload sessionPayload) {
        return ResponseEntity.ok(this.eventService.updateSessionInEvent(eventId, sessionId, sessionPayload));
    }

    @DeleteMapping(path = "/{eventId}/sessions/{sessionId}")
    public ResponseEntity<?> deleteSessionFromEvent(@PathVariable(value = "eventId") Long eventId, @PathVariable(value = "sessionId") Long sessionId) {
        return ResponseEntity.ok(this.eventService.deleteSessionFromEvent(eventId, sessionId));
    }

    @PostMapping(path = "/{eventId}/member/{memberId}")
    public ResponseEntity<?> addMemberToEventById(@PathVariable(value = "eventId") Long eventId, @PathVariable(value = "memberId") Long memberId) {
        return ResponseEntity.ok(this.eventService.addMemberToEventById(eventId, memberId));
    }
}
