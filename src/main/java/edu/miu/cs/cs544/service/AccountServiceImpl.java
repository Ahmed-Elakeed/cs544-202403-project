package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.dto.AttendanceRecord;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService {

    private final AccountRepository accountRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    @Override
    public AttendanceResponseDTO attendanceForParticularAccountTypeWithDateRange(Long accountId, LocalDate startDate, LocalDate endDate) {
        Optional<Account> accountOptional = this.accountRepository.findById(accountId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            List<Event> events = this.accountRepository.fetchAttendanceByAccountTypeWithDateRangeData(
                    account.getAccountType(),
                    startDate.atStartOfDay(),
                    endDate.atStartOfDay());
            List<AttendanceRecord> attendanceRecordList = new ArrayList<>();
            for (Event event : events) {
                Schedule schedule = event.getSchedule();
                List<Session> sessions = schedule.getSessions();
                for (Session session : sessions) {
                    List<Member> members = session.getMembers();
                    for (Member member : members) {
                        attendanceRecordList.add(AttendanceRecord.builder()
                                .memberId(member.getId())
                                .memberFirstName(member.getFirstName())
                                .memberLastName(member.getLastName())
                                .sessionId(session.getId())
                                .sessionDescription(session.getDescription())
                                .sessionName(session.getName())
                                .build());
                    }
                }
            }
            return AttendanceResponseDTO.builder()
                    .count(attendanceRecordList.size())
                    .attendanceRecordList(attendanceRecordList)
                    .build();

        }
        return AttendanceResponseDTO.builder()
                .count(0)
                .attendanceRecordList(new ArrayList<>())
                .build();
    }


}
