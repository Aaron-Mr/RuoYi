package com.ruoyi.his.mapper;

import com.ruoyi.his.domain.HisDepts;
import com.ruoyi.system.domain.SysPost;

import java.util.List;

public interface HisDeptsMapper {
    /**
     * 查询科室列表结合分页查询
     * @param hisDepts 条件
     * @return 科室列表
     */
    public List<HisDepts> selectHisDeptsList(HisDepts hisDepts);

    /**
     * 批量删除科室
     *
     * @param ids 需要删除的科室主键集合
     * @return 结果
     */
    public int deleteHisDeptsByIds(Long[] ids);

    int insertHisDepts(HisDepts hisDepts);

    /**
     * 查询科室名是否存在
     * @param deptsName 要新建的科室
     * @return 存在的数量
     */
    public HisDepts checkDeptsNameUnique(String deptsName);

    /**
     * 查询科室编码是否存在
     * @param deptsCode 要新建的科室
     * @return 存在的数量
     */
    public HisDepts checkDeptsCodeUnique(String deptsCode);

    /**
     * 通过科室ID查询详细信息
     *
     * @param deptsId 科室ID
     * @return 角色对象信息
     */
    public HisDepts selectDeptById(Long deptsId);

    /**
     * 修改科室信息
     *
     * @param hisDepts 科室信息
     * @return 结果
     */
    public int updateDept(HisDepts hisDepts);
}
