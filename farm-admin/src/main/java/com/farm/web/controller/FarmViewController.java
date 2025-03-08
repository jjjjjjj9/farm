package com.farm.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farm.common.annotation.Log;
import com.farm.common.core.controller.BaseController;
import com.farm.common.core.domain.AjaxResult;
import com.farm.common.enums.BusinessType;
import com.farm.web.domain.FarmView;
import com.farm.web.service.IFarmViewService;
import com.farm.common.utils.poi.ExcelUtil;
import com.farm.common.core.page.TableDataInfo;

/**
 * 农庄浏览Controller
 * 
 * @author ruoyi
 * @date 2025-03-07
 */
@RestController
@RequestMapping("/system/view")
public class FarmViewController extends BaseController
{
    @Autowired
    private IFarmViewService farmViewService;

    /**
     * 查询农庄浏览列表
     */
    @PreAuthorize("@ss.hasPermi('system:view:list')")
    @GetMapping("/list")
    public TableDataInfo list(FarmView farmView)
    {
        startPage();
        List<FarmView> list = farmViewService.selectFarmViewList(farmView);
        return getDataTable(list);
    }

    /**
     * 导出农庄浏览列表
     */
    @PreAuthorize("@ss.hasPermi('system:view:export')")
    @Log(title = "农庄浏览", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmView farmView)
    {
        List<FarmView> list = farmViewService.selectFarmViewList(farmView);
        ExcelUtil<FarmView> util = new ExcelUtil<FarmView>(FarmView.class);
        util.exportExcel(response, list, "农庄浏览数据");
    }

    /**
     * 获取农庄浏览详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:view:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmViewService.selectFarmViewById(id));
    }

    /**
     * 新增农庄浏览
     */
    @PreAuthorize("@ss.hasPermi('system:view:add')")
    @Log(title = "农庄浏览", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmView farmView)
    {
        return toAjax(farmViewService.insertFarmView(farmView));
    }

    /**
     * 修改农庄浏览
     */
    @PreAuthorize("@ss.hasPermi('system:view:edit')")
    @Log(title = "农庄浏览", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmView farmView)
    {
        return toAjax(farmViewService.updateFarmView(farmView));
    }

    /**
     * 删除农庄浏览
     */
    @PreAuthorize("@ss.hasPermi('system:view:remove')")
    @Log(title = "农庄浏览", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmViewService.deleteFarmViewByIds(ids));
    }
}
