package com.ruoyi.his.service;

import com.ruoyi.his.domain.HisDepts;

import java.util.List;

public interface IHisDeptsService {
    public List<HisDepts> selectHisDeptsList(HisDepts hisDepts);

    public int deleteHisDeptsByIds(Long[] ids);

    int insertHisDepts(HisDepts hisDepts);

    String checkDeptsNameUnique(HisDepts hisDepts);

    String checkDeptsCodeUnique(HisDepts hisDepts);

    public HisDepts selectDeptById(Long deptsId);

    public int updateDept(HisDepts hisDepts);
}
