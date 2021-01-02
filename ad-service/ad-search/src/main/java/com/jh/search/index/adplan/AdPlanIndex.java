package com.jh.search.index.adplan;

import com.jh.search.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Program: ad-system
 * @ClassName: AdPlanIndex
 * @Author: JH
 * @Date: 2020-12-31 15:52
 * @Description:
 */
@Component
@Slf4j
public class AdPlanIndex implements IndexAware<Long,AdPlanObject> {

    private static Map<Long,AdPlanObject> objectMap;
    static {
        objectMap= new ConcurrentHashMap<>();
    }
    @Override
    public AdPlanObject get(Long key) {

        return objectMap.get(key);
    }

    @Override
    public void add(Long key, AdPlanObject value) {
        log.info("before add:{}",objectMap);
        objectMap.put(key,value);
        log.info("after add:{}",objectMap);
    }

    @Override
    public void update(Long key, AdPlanObject value) {
        log.info("before update:{}",objectMap);
        if (objectMap.get(key)==null){
            objectMap.put(key, value);
        }else {
            objectMap.put(key, value);
        }
        log.info("after update:{} ",objectMap);
    }

    @Override
    public void delete(Long key, AdPlanObject value) {
        log.info("before delete:{}",objectMap);
        objectMap.remove(key);
        log.info("after remove:{}",objectMap);
    }
}
