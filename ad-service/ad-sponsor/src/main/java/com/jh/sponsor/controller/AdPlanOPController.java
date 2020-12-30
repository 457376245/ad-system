package com.jh.sponsor.controller;

import com.alibaba.fastjson.JSON;
import com.jh.common.exception.AdException;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.service.AdPlanService;
import com.jh.sponsor.vo.AdPlanGetRequest;
import com.jh.sponsor.vo.AdPlanRequest;
import com.jh.sponsor.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Qinyi.
 */
@Slf4j
@RestController
@RequestMapping("ad-plan")
public class AdPlanOPController {
    @Resource(name = "com.jh.sponsor.service.impl.AdPlanServiceImpl")
    private  AdPlanService adPlanService;


    @PostMapping("/create/adPlan")
    public AdPlanResponse createAdPlan(
            @RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: createAdPlan -> {}",
                JSON.toJSONString(request));
        return adPlanService.createAdPlan(request);
    }

    @PostMapping("/get/adPlan")
    public List<AdPlan> getAdPlanByIds(
            @RequestBody AdPlanGetRequest request) throws AdException {
        log.info("ad-sponsor: getAdPlanByIds -> {}",
                JSON.toJSONString(request));
        return adPlanService.getAdPlanByIds(request);
    }

    @PutMapping("/update/adPlan")
    public AdPlanResponse updateAdPlan(
            @RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: updateAdPlan -> {}",
                JSON.toJSONString(request));
        return adPlanService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/adPlan")
    public void deleteAdPlan(
            @RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: deleteAdPlan -> {}",
                JSON.toJSONString(request));
        adPlanService.deleteAdPlan(request);
    }
}
