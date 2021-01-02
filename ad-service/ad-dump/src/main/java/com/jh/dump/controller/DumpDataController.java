package com.jh.dump.controller;

import com.jh.common.dump.DConstant;
import com.jh.dump.service.DumpDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Program: ad-system
 * @ClassName: DumpDataController
 * @Author: JH
 * @Date: 2021-01-01 14:26
 * @Description:
 */
@Controller
public class DumpDataController {
    @Autowired
    private DumpDataService service;

    @RequestMapping("/dump")
    public void dumpAdTableData() {

        service.dumpAdPlanTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                        DConstant.AD_PLAN)
        );
        service.dumpAdUnitTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                        DConstant.AD_UNIT)
        );
        service.dumpAdCreativeTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                        DConstant.AD_CREATIVE)
        );
        service.dumpAdCreativeTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                        DConstant.AD_CREATIVE_UNIT)
        );
        service.dumpAdUnitDistrictTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                        DConstant.AD_UNIT_DISTRICT)
        );
        service.dumpAdUnitItTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                        DConstant.AD_UNIT_IT)
        );
        service.dumpAdUnitKeywordTable(
                String.format("%s%s", DConstant.DATA_ROOT_DIR,
                        DConstant.AD_UNIT_KEYWORD)
        );
    }
}
