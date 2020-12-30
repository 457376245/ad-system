package com.jh.sponsor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jh.common.exception.AdException;
import com.jh.sponsor.entity.AdUnit;
import com.jh.sponsor.vo.*;

public interface AdUnitService extends IService<AdUnit> {

    AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException;
}
