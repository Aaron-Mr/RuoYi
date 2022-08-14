package com.ruoyi.drug_inventory.mapper;

import com.ruoyi.common.core.domain.entity.SysDictType;
import com.ruoyi.drug_inventory.domain.Factory;
import com.ruoyi.his.domain.HisDepts;

import java.util.List;

public interface FactoryMapper {
    public List<Factory> selectFactoryList(Factory factory);
    public Factory selectFactoryById(Long facId);
    public int insertFactory(Factory factory);
    Factory checkFactoryNameUnique(String facName);
    Factory checkFactoryCodeUnique(String facCode);
    Factory checkFactoryKeyUnique(String facCode);
    public int deleteFactoryByIds(Long[] ids);
    public int updateFactory(Factory factory);

}
