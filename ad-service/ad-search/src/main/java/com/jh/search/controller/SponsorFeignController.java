package com.jh.search.controller;

import com.jh.common.exception.AdException;
import com.jh.common.vo.CommonResponse;
import com.jh.search.service.feign.SponsorFeign;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.vo.AdPlanGetRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SponsorFeignController {

    @Resource(name = "com.jh.search.feign.SponsorFeign")
    private SponsorFeign feign;
    @PostMapping("/ad-plan/get/adPlan")
    public CommonResponse<List<AdPlan>> getAdPlanByIds(
            @RequestBody AdPlanGetRequest request) throws AdException{
        ArrayList<Integer> list=new ArrayList<>();
        return feign.getAdPlanByIds(request);
    }

}
