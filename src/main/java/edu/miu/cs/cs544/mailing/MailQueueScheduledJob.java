package edu.miu.cs.cs544.mailing;


import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.ScannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Transactional
public class MailQueueScheduledJob {

    private final MemberRepository memberRepository;

    private final JmsTemplate jmsTemplate;

    private final MailService mailService;

    private final ScannerRepository scannerRepository;

    @Scheduled(cron = "0 * * * * *") // Runs every minute
//    @Scheduled(cron = "0 0 9 * * *") // Runs daily at 9 AM
    public void memberAccountsBalanceChecker() {
        List<Member> memberList = this.memberRepository.findAll();
        for (Member member : memberList) {
            Set<Account> memberAccounts = this.fetchDistinctAccountsForMember(member);
            for(Account account:memberAccounts){
                Integer accountAttendanceBalance = this.scannerRepository.fetchMemberAttendanceBalanceByAccount(
                        member.getId(),
                        account.getAccountType()
                );
                if(((double) accountAttendanceBalance /account.getBalance() * 100.0) >= 95){
                    this.jmsTemplate.convertAndSend(
                            "mail-queue",
                            MailQueueMessageDTO.builder()
                                    .email(member.getEmail())
                                    .accountType(account.getAccountType())
                                    .build()
                    );
                }
            }
        }
    }


    private Set<Account> fetchDistinctAccountsForMember(Member member) {
        Set<Account> accounts = new HashSet<>();
        for(Role role:member.getRoles()){
            accounts.addAll(role.getAccounts());
        }
        return accounts;
    }


    @JmsListener(destination = "mail-queue")
    public void mailQueue(MailQueueMessageDTO mailQueueMessageDTO) {
        this.mailService.sendMail(
                mailQueueMessageDTO.getEmail(),
                "Account Balance Warning",
                "Your " + mailQueueMessageDTO.getAccountType() + " account balance is below 5% of the default balance"
        );
    }
}
