package com.ruoyi.his.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.his.domain.HisDepts;
import com.ruoyi.his.mapper.HisDeptsMapper;
import com.ruoyi.his.service.IHisDeptsService;
import com.ruoyi.system.domain.SysPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.ruoyi.common.utils.SecurityUtils.getUsername;

@Service
public class HisDeptsServiceImpl implements IHisDeptsService {

    @Resource
    private HisDeptsMapper hisDeptsMapper;

    @Override
    public List<HisDepts> selectHisDeptsList(HisDepts hisDepts) {
        return hisDeptsMapper.selectHisDeptsList(hisDepts);
    }

    @Override
    public int deleteHisDeptsByIds(Long[] ids) {
        return hisDeptsMapper.deleteHisDeptsByIds(ids);
    }

    @Override
    public int insertHisDepts(HisDepts hisDepts) {
        return hisDeptsMapper.insertHisDepts(hisDepts);
    }

    @Override
    public String checkDeptsNameUnique(HisDepts hisDepts) {
        Long deptsId = StringUtils.isNull(hisDepts.getDeptsId()) ? -1L : hisDepts.getDeptsId();
        HisDepts info = hisDeptsMapper.checkDeptsNameUnique(hisDepts.getDeptsName());
        if (StringUtils.isNotNull(info) && info.getDeptsId().longValue() != deptsId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public String checkDeptsCodeUnique(HisDepts hisDepts) {
        Long deptsId = StringUtils.isNull(hisDepts.getDeptsId()) ? -1L : hisDepts.getDeptsId();
        HisDepts info = hisDeptsMapper.checkDeptsCodeUnique(hisDepts.getDeptsCode());
        if (StringUtils.isNotNull(info) && info.getDeptsId().longValue() != deptsId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public HisDepts selectDeptById(Long deptsId) {
        return hisDeptsMapper.selectDeptById(deptsId);
    }

    @Override
    public int updateDept(HisDepts hisDepts) {
        return hisDeptsMapper.updateDept(hisDepts);
    }


}
