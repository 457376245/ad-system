package com.jh.sponsor.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jh.sponsor.entity.AdUser;
import com.jh.sponsor.vo.CreateUserResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface AdUserDao extends BaseMapper<AdUser> {

}
