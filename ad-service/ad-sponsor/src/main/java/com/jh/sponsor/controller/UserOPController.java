package com.jh.sponsor.controller;

import com.alibaba.fastjson.JSON;

import com.jh.common.exception.AdException;
import com.jh.sponsor.service.AdUserService;
import com.jh.sponsor.vo.CreateUserRequest;
import com.jh.sponsor.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Qinyi.
 */
@Slf4j
@RestController
public class UserOPController {

    @Resource(name = "com.jh.sponsor.service.impl.AdUserServiceImpl")
    private AdUserService userService;


    @PostMapping("/create/user")
    public CreateUserResponse createUser(
            @RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor: createUser -> {}",
                JSON.toJSONString(request));
        return userService.creatUser(request);
    }
}
