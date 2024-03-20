package edu.miu.cs.cs544.mailing;

import edu.miu.cs.cs544.domain.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailQueueMessageDTO {
    private String email;
    private AccountType accountType;
}
