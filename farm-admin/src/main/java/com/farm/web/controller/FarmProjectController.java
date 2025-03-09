package com.farm.web.controller;

import com.farm.common.annotation.Log;
import com.farm.common.core.controller.BaseController;
import com.farm.common.core.domain.AjaxResult;
import com.farm.common.core.page.TableDataInfo;
import com.farm.common.enums.BusinessType;
import com.farm.common.enums.CetyifyStatus;
import com.farm.common.utils.poi.ExcelUtil;
import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmProject;
import com.farm.web.service.IFarmProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 农庄项目Controller
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/system/project")
public class FarmProjectController extends BaseController
{
    @Autowired
    private IFarmProjectService farmProjectService;

    /**
     * 查询农庄项目列表
     */
    @GetMapping("/list")
    public TableDataInfo list(FarmProject farmProject)
    {
        startPage();
        List<FarmProject> list = farmProjectService.selectFarmProjectList(farmProject);
        return getDataTable(list);
    }

    @GetMapping("/getProjectTypeNum")
    public Map<String,Object> getProjectTypeNum()
    {
        Map<String,Object> map = new HashMap<>();
        List<CountObject> list = farmProjectService.getProjectTypeNum();
        String[] types = new String[list.size()];
        int[] values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            types[i] = list.get(i).getName();
            values[i] = list.get(i).getValue();
        }
        map.put("types",types);
        map.put("values",values);
        return map;
    }
    @PreAuthorize("@ss.hasPermi('system:project:list')")
    @GetMapping("/getHotProject")
    public List<FarmProject> getHotProject()
    {
        return farmProjectService.getHotProject();
    }

    /**
     * 导出农庄项目列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:export')")
    @Log(title = "农庄项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmProject farmProject)
    {
        List<FarmProject> list = farmProjectService.selectFarmProjectList(farmProject);
        ExcelUtil<FarmProject> util = new ExcelUtil<FarmProject>(FarmProject.class);
        util.exportExcel(response, list, "农庄项目数据");
    }

    /**
     * 获取农庄项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmProjectService.selectFarmProjectById(id));
    }

    /**
     * 新增农庄项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:add')")
    @Log(title = "农庄项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmProject farmProject)
    {
        return toAjax(farmProjectService.insertFarmProject(farmProject));
    }

    /**
     * 修改农庄项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "农庄项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmProject farmProject)
    {
        return toAjax(farmProjectService.updateFarmProject(farmProject));
    }

    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "审批拒绝农庄项目", businessType = BusinessType.UPDATE)
    @PutMapping("/reject")
    public AjaxResult reject(@RequestBody FarmProject farmProject)
    {
        farmProject.setStatus(CetyifyStatus.FAIL.getCode());
        return toAjax(farmProjectService.updateFarmProject(farmProject));
    }

    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "审批通过庄项目", businessType = BusinessType.UPDATE)
    @PutMapping("/pass")
    public AjaxResult pass(@RequestBody FarmProject farmProject)
    {
        farmProject.setStatus(CetyifyStatus.PASS.getCode());
        return toAjax(farmProjectService.updateFarmProject(farmProject));
    }

    /**
     * 删除农庄项目
     */
    @PreAuthorize("@ss.hasPermi('system:project:remove')")
    @Log(title = "农庄项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmProjectService.deleteFarmProjectByIds(ids));
    }
}
