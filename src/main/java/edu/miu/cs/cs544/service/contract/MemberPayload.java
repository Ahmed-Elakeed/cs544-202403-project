package edu.miu.cs.cs544.service.contract;

import java.io.Serial;
import java.io.Serializable;

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
}
