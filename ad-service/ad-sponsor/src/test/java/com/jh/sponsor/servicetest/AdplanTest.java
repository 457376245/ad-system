package com.jh.sponsor.servicetest;

import com.jh.common.exception.AdException;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.service.AdPlanService;
import com.jh.sponsor.vo.AdPlanGetRequest;
import com.jh.sponsor.vo.AdPlanRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AdplanTest {

    @Autowired
    private AdPlanService adPlanService;
    @Test
    public void  testGetPlan() throws AdException {
        List<Long> longs = new ArrayList<>();
        longs.add((long) 10);
        AdPlanGetRequest request = new AdPlanGetRequest((long) 1, longs);
        List<AdPlan> adPlanByIds = adPlanService.getAdPlanByIds(request);
        adPlanByIds.forEach(i-> System.out.println(i.toString()));
    }
}
