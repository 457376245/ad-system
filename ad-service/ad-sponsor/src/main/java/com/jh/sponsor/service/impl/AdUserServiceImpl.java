package com.jh.sponsor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.common.exception.AdException;
import com.jh.sponsor.dao.AdUserDao;
import com.jh.sponsor.enmu.ResultCodeEnum;
import com.jh.sponsor.entity.AdUser;
import com.jh.sponsor.service.AdUserService;
import com.jh.sponsor.vo.CreateUserRequest;
import com.jh.sponsor.vo.CreateUserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("com.jh.sponsor.service.impl.AdUserServiceImpl")
public class AdUserServiceImpl extends ServiceImpl<AdUserDao, AdUser> implements AdUserService {
    @Autowired
    private AdUserDao userDao;

    @Override
    @Transactional
    public CreateUserResponse creatUser(CreateUserRequest request)throws AdException {
        if (!request.validate()){
            throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        }
        if (userDao.selectOne(new QueryWrapper<AdUser>().eq("name", request.getName()))!=null) {
            throw new AdException(ResultCodeEnum.ERROR_IS_EXISTS_USER.getMessage());
        }
            AdUser adUser = new AdUser();
            adUser.setUsername(request.getName());
            adUser.setToken(request.getName());
            userDao.insert(adUser);
            CreateUserResponse response = new CreateUserResponse();
            BeanUtils.copyProperties(adUser,response);
        return response;
    }
}
