package com.ruoyi.drug_inventory.service;

import com.ruoyi.drug_inventory.domain.Factory;
import com.ruoyi.his.domain.HisDepts;

import java.util.List;

public interface FactoryService {
    public List<Factory> selectFactoryList(Factory dictType);
    public Factory selectFactoryById(Long facId);
    public int insertFactory(Factory factory);

    String checkFactoryNameUnique(Factory factory);

    String checkFactoryCodeUnique(Factory factory);

    String checkFactoryKeyUnique(Factory factory);

    public int deleteFactoryByIds(Long[] ids);

    public int updateFactory(Factory factory);
}
