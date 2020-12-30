package com.jh.sponsor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jh.common.exception.AdException;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.vo.AdPlanGetRequest;
import com.jh.sponsor.vo.AdPlanRequest;
import com.jh.sponsor.vo.AdPlanResponse;

import java.util.List;

public interface AdPlanService extends IService<AdPlan> {
    AdPlanResponse createAdPlan(AdPlanRequest request)throws AdException;
    void deleteAdPlan(AdPlanRequest request)throws AdException;
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;
}
