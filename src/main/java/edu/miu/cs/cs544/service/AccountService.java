package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.dto.AttendanceResponseDTO;
import edu.miu.cs.cs544.service.contract.AccountPayload;

import java.time.LocalDate;

public interface AccountService extends BaseReadWriteService<AccountPayload, Account, Long>{

    AttendanceResponseDTO attendanceForParticularAccountTypeWithDateRange(Long accountId, LocalDate startDate, LocalDate endDate);
}
