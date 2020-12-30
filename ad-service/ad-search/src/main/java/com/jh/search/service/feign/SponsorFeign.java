package com.jh.search.service.feign;

import com.jh.common.exception.AdException;
import com.jh.common.vo.CommonResponse;
import com.jh.search.service.feign.hystrix.SponsorHystrix;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.vo.AdPlanGetRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service("com.jh.search.feign.SponsorFeign")
@FeignClient(value = "AD-SERVICE",fallback = SponsorHystrix.class)
public interface SponsorFeign {

    @PostMapping("/ad-plan/get/adPlan")
    public CommonResponse<List<AdPlan>> getAdPlanByIds(
            @RequestBody AdPlanGetRequest request) throws AdException;

}
