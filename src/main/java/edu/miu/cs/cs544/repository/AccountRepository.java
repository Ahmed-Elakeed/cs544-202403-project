package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountRepository extends BaseRepository<Account, Long>{

    @Query(value = "select e from Event e left join fetch e.schedule s left join fetch s.sessions ss" +
            " where e.accountType = :accountType and ss.startDateTime >= :startDate and ss.endDateTime <= :endDate")
    List<Event> fetchAttendanceByAccountTypeWithDateRangeData(
            @Param(value = "accountType") AccountType accountType,
            @Param(value = "startDate") LocalDateTime startDate,
            @Param(value = "endDate") LocalDateTime endDate);
}
