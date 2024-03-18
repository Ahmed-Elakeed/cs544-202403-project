package edu.miu.cs.cs544.service.contract;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Role;
import lombok.Data;

@Data
public class MemberPayload implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private int barcode;
	private List<Role> roles;
	private List<Account> accounts;
}
