package com.jh.sponsor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jh.sponsor.entity.Creative;
import com.jh.sponsor.vo.CreativeRequest;
import com.jh.sponsor.vo.CreativeResponse;

public interface CreativeService extends IService<Creative> {

    CreativeResponse createCreative(CreativeRequest request);
}
