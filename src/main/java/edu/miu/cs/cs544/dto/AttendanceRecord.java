package edu.miu.cs.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRecord {
    private Long memberId;
    private String memberFirstName;
    private String memberLastName;

    private Long sessionId;

    private String sessionName;

    private String sessionDescription;
}
