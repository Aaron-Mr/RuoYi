package com.ruoyi.web.controller.druginventory;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.drug_inventory.domain.Factory;
import com.ruoyi.drug_inventory.service.FactoryService;
import com.ruoyi.his.domain.HisDepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/drugInventory")
public class FactoryController extends BaseController {

    @Autowired
    private FactoryService factoryService;

    /**
     * 获取厂家list
     * @param factory 条件查询
     * @return 厂家list
     */
    @PreAuthorize("@ss.hasPermi('his:factory:list')")
    @GetMapping("/list")
    public TableDataInfo list(Factory factory) {
        System.out.println(factory);
        System.out.println("---获取厂家list---");
        startPage();
        List<Factory> list = factoryService.selectFactoryList(factory);
        return getDataTable(list);
    }

    /**
     * 查询单个厂家的详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:factory:query')")
    @GetMapping(value = "/{facId}")
    public AjaxResult getInfo(@PathVariable Long facId) {
        return AjaxResult.success(factoryService.selectFactoryById(facId));
    }

    /**
     * 新增厂家
     */
    @PreAuthorize("@ss.hasPermi('his:factory:add')")
    @Log(title = "药品进销存管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Factory factory){
        System.out.println("---新增厂家操作---");
        System.out.println(factory);
        if (UserConstants.NOT_UNIQUE.equals(factoryService.checkFactoryNameUnique(factory))) {
            return AjaxResult.error("新增厂家'" + factory.getFacName() + "'失败，厂家名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(factoryService.checkFactoryCodeUnique(factory))) {
            return AjaxResult.error("新增厂家'" + factory.getFacName() + "'失败，厂家编码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(factoryService.checkFactoryKeyUnique(factory))) {
            return AjaxResult.error("新增厂家'" + factory.getFacName() + "'失败，关键字已存在");
        }

        factory.setCreateBy(getUsername());
        factory.setCreateTime(new Date());
        return toAjax(factoryService.insertFactory(factory));
    }

    /**
     * 删除厂家
     */
    @PreAuthorize("@ss.hasPermi('his:factory:remove')")
    @Log(title = "药品进销存管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        System.out.println("---删除厂家操作---");
        return toAjax(factoryService.deleteFactoryByIds(ids));
    }

    /**
     * 修改厂家
     */
    @PreAuthorize("@ss.hasPermi('his:factory:edit')")
    @Log(title = "药品进销存管理", businessType = BusinessType.INSERT)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Factory factory){
        System.out.println("---修改厂家操作---");
        System.out.println(factory);

        if (UserConstants.NOT_UNIQUE.equals(factoryService.checkFactoryNameUnique(factory))) {
            return AjaxResult.error("修改厂家'" + factory.getFacName() + "'失败，厂家名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(factoryService.checkFactoryCodeUnique(factory))) {
            return AjaxResult.error("修改厂家'" + factory.getFacName() + "'失败，厂家编码已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(factoryService.checkFactoryKeyUnique(factory))) {
            return AjaxResult.error("修改厂家'" + factory.getFacName() + "'失败，关键字已存在");
        }

        factory.setUpdateBy(getUsername());
        factory.setUpdateTime(new Date());
        return toAjax(factoryService.updateFactory(factory));
    }

}
