package edu.miu.cs.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceResponseDTO {
    int count;
    List<AttendanceRecord> attendanceRecordList;
}
