package com.ruoyi.drug_inventory.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.drug_inventory.domain.Factory;
import com.ruoyi.drug_inventory.mapper.FactoryMapper;
import com.ruoyi.drug_inventory.service.FactoryService;
import com.ruoyi.his.domain.HisDepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {

    @Resource
    private FactoryMapper factoryMapper;

    @Override
    public List<Factory> selectFactoryList(Factory dictType) {
        return factoryMapper.selectFactoryList(dictType);
    }

    @Override
    public Factory selectFactoryById(Long facId) {
        return factoryMapper.selectFactoryById(facId);
    }

    @Override
    public int insertFactory(Factory factory) {
        return factoryMapper.insertFactory(factory);
    }

    @Override
    public String checkFactoryNameUnique(Factory factory) {
        Long facId = StringUtils.isNull(factory.getFacId()) ? -1L : factory.getFacId();
        Factory info = factoryMapper.checkFactoryNameUnique(factory.getFacName());
        if (StringUtils.isNotNull(info) && info.getFacId().longValue() != facId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkFactoryCodeUnique(Factory factory) {
        Long facId = StringUtils.isNull(factory.getFacId()) ? -1L : factory.getFacId();
        Factory info = factoryMapper.checkFactoryCodeUnique(factory.getFacCode());
        if (StringUtils.isNotNull(info) && info.getFacId().longValue() != facId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkFactoryKeyUnique(Factory factory) {
        Long facId = StringUtils.isNull(factory.getFacId()) ? -1L : factory.getFacId();
        Factory info = factoryMapper.checkFactoryKeyUnique(factory.getFacKey());
        if (StringUtils.isNotNull(info) && info.getFacId().longValue() != facId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int deleteFactoryByIds(Long[] ids) {
        return factoryMapper.deleteFactoryByIds(ids);
    }

    @Override
    public int updateFactory(Factory factory) {
        return factoryMapper.updateFactory(factory);
    }
}
