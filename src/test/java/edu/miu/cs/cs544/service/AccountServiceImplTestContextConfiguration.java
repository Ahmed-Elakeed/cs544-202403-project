package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountServiceImplTestContextConfiguration {

    @Bean
    public AccountService accountService(AccountRepository accountRepository) {
        return new AccountServiceImpl(accountRepository);
    }
}
