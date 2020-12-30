package com.jh.search.service.feign.hystrix;

import com.jh.common.exception.AdException;
import com.jh.common.vo.CommonResponse;
import com.jh.search.service.feign.SponsorFeign;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.vo.AdPlanGetRequest;

import java.util.List;

public class SponsorHystrix implements SponsorFeign {
    @Override
    public CommonResponse<List<AdPlan>> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        return new CommonResponse<>(-1,"eureka sponsor error");
    }
}
