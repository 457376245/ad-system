package com.jh.sponsor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.common.exception.AdException;
import com.jh.sponsor.dao.AdPlanDao;
import com.jh.sponsor.dao.AdUnitDao;
import com.jh.sponsor.dao.unit_condition.AdUnitDistrictDao;
import com.jh.sponsor.dao.unit_condition.AdUnitItDao;
import com.jh.sponsor.dao.unit_condition.AdUnitKeywordDao;
import com.jh.sponsor.dao.unit_condition.CreativeUnitDao;
import com.jh.sponsor.enmu.ResultCodeEnum;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.entity.AdUnit;
import com.jh.sponsor.entity.unit_condition.AdUnitDistrict;
import com.jh.sponsor.entity.unit_condition.AdUnitIt;
import com.jh.sponsor.entity.unit_condition.AdUnitKeyword;
import com.jh.sponsor.entity.unit_condition.CreativeUnit;
import com.jh.sponsor.service.AdUnitService;
import com.jh.sponsor.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdUnitServiceImpl extends ServiceImpl<AdUnitDao, AdUnit> implements AdUnitService {
    @Autowired
    private AdPlanDao planDao;
    @Autowired
    private AdUnitDao unitDao;
    @Autowired
    private AdUnitKeywordDao keywordDao;
    @Autowired
    private AdUnitItDao itDao;
    @Autowired
    private AdUnitDistrictDao districtDao;
    @Autowired
    private CreativeUnitDao creativeUnitDao;

    @Override
    public AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException {
        if (!request.createValidate()) throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        AdPlan adPlan = planDao.selectById(request.getPlanId());
        if (adPlan == null) throw new AdException(ResultCodeEnum.ERROR_NOT_EXISTS_PLAN.getMessage());
        AdUnit adUnit = unitDao.selectOne(new QueryWrapper<AdUnit>().eq("unit_name", request.getUnitName()));
        if (adUnit !=null) throw new AdException(ResultCodeEnum.ERROR_IS_EXISTS_UNIT.getMessage());
        AdUnit unit = new AdUnit(request.getPlanId(), request.getUnitName(), request.getPositionType(), request.getBudget());
        unitDao.insert(unit);
        return new AdUnitResponse(request.getPlanId(),request.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {
        //从request中获取ids以便校验
        List<Long> unitIds = request.getUnitKeywords().stream().map(AdUnitKeywordRequest.UnitKeyword::getUnitId).collect(Collectors.toList());
        if (!isRelatedCreativeExist(unitIds)) throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        //ids记录保存的AdUnitKeyword的主键
        List<Long> ids = new ArrayList<>();
        ArrayList<AdUnitKeyword> unitKeywords = new ArrayList<AdUnitKeyword>();
        //从requet获取AdUnitKeyword并添加进unitKeywords
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())){
            request.getUnitKeywords().forEach(i->unitKeywords.add(new AdUnitKeyword(i.getUnitId(),i.getKeyword())));
        }
        //遍历保存unitKeywords中的AdUnitKeyword
        unitKeywords.forEach(i->{
            keywordDao.insert(i);
            ids.add(i.getId());
        });

        return new AdUnitKeywordResponse(ids);
    }

    @Override
    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {
        List<Long> unitIds = request.getUnitIts().stream().map(AdUnitItRequest.UnitIt::getUnitId).collect(Collectors.toList());
        if (!isRelatedCreativeExist(unitIds))throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());

        ArrayList<Long> ids = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitIts())){
            request.getUnitIts().forEach(i->{
                itDao.insert(new AdUnitIt(i.getUnitId(),i.getItTag()));
                ids.add(i.getUnitId());
            });
        }
        return new AdUnitItResponse(ids);
    }

    @Override
    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException {
        List<Long> unitIds = request.getUnitDistricts().stream().map(AdUnitDistrictRequest.UnitDistrict::getUnitId).collect(Collectors.toList());
        if (!isRelatedCreativeExist(unitIds)) throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        ArrayList<Long> ids = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitDistricts())){
            request.getUnitDistricts().forEach(i->{
                districtDao.insert(new AdUnitDistrict(i.getUnitId(),i.getProvince(),i.getCity()));
                ids.add(i.getUnitId());
            });
        }
        return new AdUnitDistrictResponse(ids);
    }

    @Override
    public CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException {
        List<Long> unitIds = request.getUnitItems().stream().map(CreativeUnitRequest.CreativeUnitItem::getUnitId).collect(Collectors.toList());
        if (!isRelatedCreativeExist(unitIds)) throw new AdException(ResultCodeEnum.PARAM_ERROR.getMessage());
        ArrayList<Long> ids = new ArrayList<>();
        if (request.getUnitItems()!=null){
            request.getUnitItems().forEach(i->{
                creativeUnitDao.insert(new CreativeUnit(i.getCreativeId(),i.getUnitId()));
                ids.add(i.getCreativeId());
            });
        }
        return new CreativeUnitResponse(ids);
    }

    public boolean isRelatedCreativeExist(List<Long> unitIds){
        if (CollectionUtils.isEmpty(unitIds))return false;

        return unitDao.selectBatchIds(unitIds).size()==new HashSet<>(unitIds).size();
    }
}
