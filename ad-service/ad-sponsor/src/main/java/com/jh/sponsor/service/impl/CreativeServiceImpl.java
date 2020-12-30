package com.jh.sponsor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.sponsor.dao.CreativeDao;
import com.jh.sponsor.entity.Creative;
import com.jh.sponsor.service.CreativeService;
import com.jh.sponsor.vo.CreativeRequest;
import com.jh.sponsor.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreativeServiceImpl extends ServiceImpl<CreativeDao, Creative> implements CreativeService {
    @Autowired
    private CreativeDao creativeDao;

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {
        creativeDao.insert(request.convertToEntity());
        return new CreativeResponse(request.getUserId(),request.getName());
    }
}
