package com.ruoyi.web.controller.his;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.his.domain.HisDepts;
import com.ruoyi.his.service.IHisDeptsService;
import com.ruoyi.system.domain.SysPost;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/his/depts")
public class HisDeptsController extends BaseController {

    @Resource
    private IHisDeptsService hisDeptsService;

    @GetMapping("/hello")
    public TableDataInfo list1(HisDepts hisDepts){
        System.out.println(hisDepts);
        startPage();
        List<HisDepts> list = hisDeptsService.selectHisDeptsList(hisDepts);
        return getDataTable(list);
    }

    /**
     * 获取科室列表
     */
    @PreAuthorize("@ss.hasPermi('his:dept:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisDepts hisDepts){
        System.out.println(hisDepts);
        startPage();
        List<HisDepts> list = hisDeptsService.selectHisDeptsList(hisDepts);
        return getDataTable(list);
    }

    /**
     * 根据岗位编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('his:dept:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable Long deptId)
    {
        return AjaxResult.success(hisDeptsService.selectDeptById(deptId));
    }

    /**
     * 删除科室
     */
    @PreAuthorize("@ss.hasPermi('his:dept:remove')")
    @Log(title = "科室管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(hisDeptsService.deleteHisDeptsByIds(ids));
    }

    /**
     * 新增科室
     */
    @PreAuthorize("@ss.hasPermi('his:dept:add')")
    @Log(title = "科室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody HisDepts hisDepts){
        System.out.println("---新增科室操作---");
        System.out.println(hisDepts);
        if (UserConstants.NOT_UNIQUE.equals(hisDeptsService.checkDeptsNameUnique(hisDepts)))
        {
            return AjaxResult.error("新增科室'" + hisDepts.getDeptsName() + "'失败，科室名称已存在");
        }
        else if (UserConstants.NOT_UNIQUE.equals(hisDeptsService.checkDeptsCodeUnique(hisDepts)))
        {
            return AjaxResult.error("新增科室'" + hisDepts.getDeptsCode() + "'失败，科室编码已存在");
        }
        hisDepts.setCreateBy(getUsername());
        hisDepts.setCreateTime(new Date());
        return toAjax(hisDeptsService.insertHisDepts(hisDepts));
    }

    /**
     * 修改科室
     */
    @PreAuthorize("@ss.hasPermi('his:dept:edit')")
    @Log(title = "科室管理", businessType = BusinessType.INSERT)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody HisDepts hisDepts){
        System.out.println("---修改科室操作---");
        System.out.println(hisDepts);
        if (UserConstants.NOT_UNIQUE.equals(hisDeptsService.checkDeptsNameUnique(hisDepts))) {
            return AjaxResult.error("修改科室'" + hisDepts.getDeptsName() + "'失败，科室名称已存在");
        }
        else if (UserConstants.NOT_UNIQUE.equals(hisDeptsService.checkDeptsCodeUnique(hisDepts))) {
            return AjaxResult.error("修改科室'" + hisDepts.getDeptsName() + "'失败，科室编码已存在");
        }

        hisDepts.setUpdateBy(getUsername());
        hisDepts.setUpdateTime(new Date());
        return toAjax(hisDeptsService.updateDept(hisDepts));
    }

}
