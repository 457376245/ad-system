package com.jh.sponsor.entity;

import com.jh.sponsor.enmu.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlan {
    private Long id;
    private Long userId;
    private String planName;
    private Integer planStatus;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public AdPlan(Long userId, String planName) {

        this.userId = userId;
        this.planName = planName;
        this.planStatus = CommonStatus.VALID.getStatus();
        this.startDate = LocalDateTime.now();
        this.endDate = LocalDateTime.now();
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }
}
