package com.jh.sponsor.entity;

import com.jh.sponsor.enmu.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUser {

    private Long id;
    private String username;
    private String token;
    private Integer userStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public AdUser(String username, String token) {

        this.username = username;
        this.token = token;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = LocalDateTime.now();
        this.updateTime = this.createTime;
    }
}

