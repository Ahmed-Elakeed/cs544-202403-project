package edu.miu.cs.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import edu.miu.cs.cs544.service.mapper.AccountToAccountPayloadMapper;

@Service
@Transactional
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService{
    @Autowired
    private MemberRepository memberRepository; 

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private AccountToAccountPayloadMapper mapper;
    
    @Override
    public AccountPayload create(AccountPayload payload) {
        Account account = new Account();
        account.setName(payload.getName());
        account.setDescription(payload.getDescription());
        AccountType accountType = AccountType.getEnumFromString(payload.getAccountType());
        account.setAccountType(accountType);

        Member member = memberRepository.findById(payload.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + payload.getMemberId()));

        account.setMember(member);

        account = accountRepository.save(account);


        return mapper.map(account);
    }
}
