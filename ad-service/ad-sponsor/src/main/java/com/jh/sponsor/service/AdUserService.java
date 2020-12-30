package com.jh.sponsor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jh.common.exception.AdException;
import com.jh.sponsor.entity.AdUser;
import com.jh.sponsor.vo.CreateUserRequest;
import com.jh.sponsor.vo.CreateUserResponse;

public interface AdUserService extends IService<AdUser> {
    CreateUserResponse creatUser(CreateUserRequest request) throws AdException;
}
