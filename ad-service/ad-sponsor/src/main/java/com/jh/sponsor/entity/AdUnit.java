package com.jh.sponsor.entity;

import com.jh.sponsor.enmu.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnit {

    private Long id;
    private Long planId;
    private String unitName;
    private Integer unitStatus;
    /** 广告位类型(开屏, 贴片, 中贴...) */
    private Integer positionType;
    private Long budget;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public AdUnit(Long planId, String unitName,
                  Integer positionType, Long budget) {
        this.planId = planId;
        this.unitName = unitName;
        this.unitStatus = CommonStatus.VALID.getStatus();
        this.positionType = positionType;
        this.budget = budget;
        this.createTime = LocalDateTime.now();
        this.updateTime = this.createTime;
    }
}
