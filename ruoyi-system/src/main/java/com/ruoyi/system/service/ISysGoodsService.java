package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysGoods;

/**
 * 商品Service接口
 * 
 * @author ruoyi
 * @date 2022-08-10
 */
public interface ISysGoodsService 
{
    /**
     * 查询商品
     * 
     * @param id 商品主键
     * @return 商品
     */
    public SysGoods selectSysGoodsById(Long id);

    /**
     * 查询商品列表
     * 
     * @param sysGoods 商品
     * @return 商品集合
     */
    public List<SysGoods> selectSysGoodsList(SysGoods sysGoods);

    /**
     * 新增商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    public int insertSysGoods(SysGoods sysGoods);

    /**
     * 修改商品
     * 
     * @param sysGoods 商品
     * @return 结果
     */
    public int updateSysGoods(SysGoods sysGoods);

    /**
     * 批量删除商品
     * 
     * @param ids 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteSysGoodsByIds(Long[] ids);

    /**
     * 删除商品信息
     * 
     * @param id 商品主键
     * @return 结果
     */
    public int deleteSysGoodsById(Long id);
}
