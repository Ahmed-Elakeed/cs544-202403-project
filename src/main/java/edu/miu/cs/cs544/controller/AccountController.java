package edu.miu.cs.cs544.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.service.AccountService;
import edu.miu.cs.cs544.service.contract.AccountPayload;

@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseReadWriteController<AccountPayload, Account, Long>{
		
	@Autowired
	AccountService accountService;

}
