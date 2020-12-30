package com.jh.sponsor.service.impl.unit_condition;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jh.sponsor.dao.unit_condition.CreativeUnitDao;
import com.jh.sponsor.entity.unit_condition.CreativeUnit;
import com.jh.sponsor.service.unit_condition.CreativeUnitService;
import org.springframework.stereotype.Service;

@Service
public class CreativeUnitServiceImpl extends ServiceImpl<CreativeUnitDao, CreativeUnit> implements CreativeUnitService {
    @Override
    public boolean save(CreativeUnit entity) {
        return false;
    }
}
