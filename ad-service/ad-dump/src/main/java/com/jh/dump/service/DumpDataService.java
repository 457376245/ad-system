package com.jh.dump.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jh.common.dump.table.*;
import com.jh.sponsor.dao.AdPlanDao;
import com.jh.sponsor.dao.AdUnitDao;
import com.jh.sponsor.dao.CreativeDao;
import com.jh.sponsor.dao.unit_condition.AdUnitDistrictDao;
import com.jh.sponsor.dao.unit_condition.AdUnitItDao;
import com.jh.sponsor.dao.unit_condition.AdUnitKeywordDao;
import com.jh.sponsor.dao.unit_condition.CreativeUnitDao;
import com.jh.sponsor.entity.AdPlan;
import com.jh.sponsor.entity.AdUnit;
import com.jh.sponsor.entity.Creative;
import com.jh.sponsor.entity.unit_condition.AdUnitDistrict;
import com.jh.sponsor.entity.unit_condition.AdUnitIt;
import com.jh.sponsor.entity.unit_condition.AdUnitKeyword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Program: ad-system
 * @ClassName: DumpDataService
 * @Author: JH
 * @Date: 2021-01-01 11:23
 * @Description: 导出数据库数据
 */
@Service
@Slf4j
public class DumpDataService {
    @Resource
    private AdPlanDao planDao;
    @Resource
    private AdUnitDao unitDao;
    @Resource
    private CreativeDao creativeDao;
    @Resource
    private CreativeUnitDao creativeUnitDao;
    @Resource
    private AdUnitDistrictDao districtDao;
    @Resource
    private AdUnitItDao itDao;
    @Resource
    private AdUnitKeywordDao keywordDao;




    public void dumpAdPlanTable(String fileName){
        //取出状态为1的adplan
        QueryWrapper<AdPlan> wrapper = new QueryWrapper<>();
        wrapper.eq("plan_status",1);
        List<AdPlan> adPlans = planDao.selectList(wrapper);

        if (CollectionUtils.isEmpty(adPlans)) return;

        //遍历封装进adPlanTable
        ArrayList<AdPlanTable> adPlanTables = new ArrayList<>();
        adPlans.forEach(i->{
            adPlanTables.add(new AdPlanTable(
                    i.getId(),
                    i.getUserId(),
                    i.getPlanStatus(),
                    i.getStartDate(),
                    i.getEndDate()
            ));
        });

        //将adPlanTables写入文件
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)){
            //BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdPlanTable adPlanTable:adPlanTables){
                writer.write(JSON.toJSONString(adPlanTable));
                writer.newLine();

            }
            writer.close();
           /* adPlanTables.forEach(i->{
                writer.write(JSON.toJSONString(i));
            });*/
        }
        catch (IOException e){
            log.error("dumpAdPlanTable error");
        }
    }

    public void dumpAdUnitTable(String fileName){
        QueryWrapper<AdUnit> wrapper = new QueryWrapper<>();
        wrapper.eq("unit_status",1);
        List<AdUnit> adUnits = unitDao.selectList(wrapper);

        ArrayList<AdUnitTable> unitTables = new ArrayList<>();
        adUnits.forEach(i->{
            unitTables.add(new AdUnitTable(
                    i.getId(),
                    i.getUnitStatus(),
                    i.getPositionType(),
                    i.getPlanId()
            ));
        });
        Path path = Paths.get(fileName);
        try{
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdUnitTable table:unitTables){
                writer.write(JSON.toJSONString(table));
                writer.newLine();

            }
            writer.close();
        }catch (IOException e){
            log.error("dumpAdUnitTable error");
        }
    }
    public void dumpAdCreativeTable(String fileName){

        List<Creative> adUnits = creativeDao.selectList(new QueryWrapper<>());

        ArrayList<AdCreativeTable> Tables = new ArrayList<>();
        adUnits.forEach(i->{
            Tables.add(new AdCreativeTable(
                    i.getId(),
                    i.getName(),
                    i.getType(),
                    i.getMaterialType(),
                    i.getHeight(),
                    i.getWidth(),
                    i.getAuditStatus(),
                    i.getUrl()
            ));
        });
        Path path = Paths.get(fileName);
        try{
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdCreativeTable table:Tables){
                writer.write(JSON.toJSONString(table));
            }
            writer.close();
        }catch (IOException e){
            log.error("dumpAdUnitTable error");
        }
    }
    public void dumpAdUnitDistrictTable(String fileName){

        List<AdUnitDistrict> adUnits = districtDao.selectList(new QueryWrapper<>());

        ArrayList<AdUnitDistrictTable> Tables = new ArrayList<>();
        adUnits.forEach(i->{
            Tables.add(new AdUnitDistrictTable(
                    i.getUnitId(),
                    i.getProvince(),
                    i.getCity()
            ));
        });
        Path path = Paths.get(fileName);
        try{
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdUnitDistrictTable table:Tables){
                writer.write(JSON.toJSONString(table));
                writer.newLine();

            }
            writer.close();
        }catch (IOException e){
            log.error("dumpAdUnitTable error");
        }
    }
    public void dumpAdUnitItTable(String fileName){

        List<AdUnitIt> adUnits = itDao.selectList(new QueryWrapper<>());

        ArrayList<AdUnitItTable> Tables = new ArrayList<>();
        adUnits.forEach(i->{
            Tables.add(new AdUnitItTable(
                    i.getUnitId(),
                    i.getItTag()
            ));
        });
        Path path = Paths.get(fileName);
        try{
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdUnitItTable table:Tables){
                writer.write(JSON.toJSONString(table));
                writer.newLine();

            }
            writer.close();
        }catch (IOException e){
            log.error("dumpAdUnitTable error");
        }
    }

    public void dumpAdUnitKeywordTable(String fileName){

        List<AdUnitKeyword> adUnits = keywordDao.selectList(new QueryWrapper<>());

        ArrayList<AdUnitKeywordTable> Tables = new ArrayList<>();
        adUnits.forEach(i->{
            Tables.add(new AdUnitKeywordTable(
                    i.getUnitId(),
                    i.getKeyword()
            ));
        });
        Path path = Paths.get(fileName);
        try{
            BufferedWriter writer = Files.newBufferedWriter(path);
            for (AdUnitKeywordTable table:Tables){
                writer.write(JSON.toJSONString(table));
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            log.error("dumpAdUnitTable error");
        }
    }

}
