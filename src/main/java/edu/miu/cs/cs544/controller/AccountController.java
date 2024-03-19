package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.service.contract.AccountPayload;

import java.time.LocalDate;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController extends BaseReadWriteController<AccountPayload, Account, Long> {


    private final AccountService accountService;

    @GetMapping(path = "/{accountId}/attendance/{startDate}/{endDate}")
    public ResponseEntity<?> attendanceForParticularAccountTypeWithDateRange(
            @PathVariable(value = "accountId") Long accountId,
            @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
            ){
        return ResponseEntity.ok(this.accountService.attendanceForParticularAccountTypeWithDateRange(
                accountId,
                startDate,
                endDate
        ));
    }

}
