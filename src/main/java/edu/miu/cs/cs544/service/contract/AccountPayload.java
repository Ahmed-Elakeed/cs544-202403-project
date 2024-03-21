package edu.miu.cs.cs544.service.contract;

import java.io.Serial;
import java.io.Serializable;

import edu.miu.cs.cs544.domain.AccountType;
import lombok.Data;

@Data
public class AccountPayload implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String description;

	private Integer balance;
	
	private AccountType accountType;
}
