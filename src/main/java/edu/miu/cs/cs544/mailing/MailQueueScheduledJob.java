package edu.miu.cs.cs544.mailing;


import edu.miu.cs.cs544.service.MemberService;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MailQueueScheduledJob {

    private final MemberService memberService;

    private final JmsTemplate jmsTemplate;

    private final MailService mailService;

    @Scheduled(cron = "0 * * * * *") // Runs every minute
//    @Scheduled(cron = "0 0 9 * * *") // Runs daily at 9 AM
    public void memberAccountsBalanceChecker() {
        List<MemberPayload> members = this.memberService.findAll();
//        members.forEach(member -> member.getAccounts().forEach(account -> {
//            if (account.getId().equals(1L)) {
//                jmsTemplate.convertAndSend("mail-queue", member.getEmail());
//            }
//        }));
    }


    @JmsListener(destination = "mail-queue")
    public void mailQueue(String email) {
        this.mailService.sendMail(
                email,
                "Account Balance Warning",
                "Your have an account with balance below 5% of the default balance"
        );
    }
}
