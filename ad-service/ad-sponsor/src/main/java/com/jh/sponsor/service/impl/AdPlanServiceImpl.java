package com.jh.sponsor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.common.exception.AdException;
import com.jh.sponsor.dao.AdPlanDao;
import com.jh.sponsor.dao.AdUserDao;
import com.jh.sponsor.enmu.ResultCodeEnum;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.service.AdPlanService;
import com.jh.sponsor.vo.AdPlanGetRequest;
import com.jh.sponsor.vo.AdPlanRequest;
import com.jh.sponsor.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service("com.jh.sponsor.service.impl.AdPlanServiceImpl")
public class AdPlanServiceImpl extends ServiceImpl<AdPlanDao, AdPlan> implements AdPlanService {
    @Autowired
    private AdUserDao userDao;
    @Autowired
    private AdPlanDao planDao;
    /*-------------------增--------------------*/
    @Override
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {
        //判断参数是否为空
        if (!request.createValidate()) throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        //判断是否有对应的user对象
        if (userDao.selectById(request.getUserId())==null) throw new AdException(ResultCodeEnum.ERROR_NOT_EXISTS_USER.getMessage());
        //根据user_id和plan_name查找是否存在相同的plan
        QueryWrapper<AdPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",request.getUserId()).eq("plan_name",request.getPlanName());
        AdPlan adPlan = planDao.selectOne(wrapper);
        if (adPlan!=null) throw new AdException(ResultCodeEnum.ERROR_IS_EXISTS_PLAN.getMessage());

        //插入plan
        int result = planDao.insert(new AdPlan(request.getUserId(), request.getPlanName()));
        if (result!=1) throw new AdException(ResultCodeEnum.UNKNOW_REASON.getMessage());

        return new AdPlanResponse(request.getId(),request.getPlanName());
    }
    /*-------------------删--------------------*/
    @Override
    public void deleteAdPlan(AdPlanRequest request) throws AdException {
        if (!request.deleteValidate()) throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        planDao.deleteById(request.getId());
    }
    /*-------------------改--------------------*/
    @Override
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {
        if (!request.updateValidate()) throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        QueryWrapper<AdPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",request.getUserId()).eq("id",request.getId());
        AdPlan adPlan = planDao.selectOne(wrapper);
        if (adPlan==null) throw new AdException(ResultCodeEnum.ERROR_IS_EXISTS_PLAN.getMessage());
        adPlan.setPlanName(request.getPlanName());
        adPlan.setUpdateTime(LocalDateTime.now());
        adPlan.setEndDate(LocalDateTime.now());
        int result = planDao.updateById(adPlan);
        if (result!=1)throw new AdException(ResultCodeEnum.UNKNOW_REASON.getMessage());
        return new AdPlanResponse(request.getId(),request.getPlanName());
    }
    /*-------------------查--------------------*/
    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException {
        if (!request.validate())throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        QueryWrapper<AdPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",request.getUserId()).and(i->i.in("id",request.getIds()));
        List<AdPlan> adPlans = planDao.selectList(wrapper);

        return adPlans;
    }
}
