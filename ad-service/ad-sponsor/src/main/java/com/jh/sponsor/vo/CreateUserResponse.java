package com.jh.sponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private Long userId;
    private String username;
    private String token;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
