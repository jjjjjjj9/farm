package com.farm.web.controller;

import com.farm.common.annotation.Log;
import com.farm.common.core.controller.BaseController;
import com.farm.common.core.domain.AjaxResult;
import com.farm.common.core.page.TableDataInfo;
import com.farm.common.enums.BusinessType;
import com.farm.common.enums.CetyifyStatus;
import com.farm.common.utils.poi.ExcelUtil;
import com.farm.web.domain.FarmCertifyInfo;
import com.farm.web.domain.FarmInfo;
import com.farm.web.service.IFarmCertifyInfoService;
import com.farm.web.service.IFarmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 农庄认证信息Controller
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/system/certifyInfo")
public class FarmCertifyInfoController extends BaseController
{
    @Autowired
    private IFarmCertifyInfoService farmCertifyInfoService;

    @Autowired
    private IFarmInfoService farmInfoService;

    /**
     * 查询农庄认证信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(FarmCertifyInfo farmCertifyInfo)
    {
        startPage();
        List<FarmCertifyInfo> list = farmCertifyInfoService.selectFarmCertifyInfoList(farmCertifyInfo);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/listByUserId")
    public List<FarmCertifyInfo> listByUserId(int userId)
    {
        return farmCertifyInfoService.selectByUserId(userId);
    }

    /**
     * 导出农庄认证信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "农庄认证信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmCertifyInfo farmCertifyInfo)
    {
        List<FarmCertifyInfo> list = farmCertifyInfoService.selectFarmCertifyInfoList(farmCertifyInfo);
        ExcelUtil<FarmCertifyInfo> util = new ExcelUtil<FarmCertifyInfo>(FarmCertifyInfo.class);
        util.exportExcel(response, list, "农庄认证信息数据");
    }

    /**
     * 获取农庄认证信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmCertifyInfoService.selectFarmCertifyInfoById(id));
    }

    /**
     * 新增农庄认证信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "农庄认证信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmCertifyInfo farmCertifyInfo)
    {
        return toAjax(farmCertifyInfoService.insertFarmCertifyInfo(farmCertifyInfo));
    }

    /**
     * 修改农庄认证信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "农庄认证信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmCertifyInfo farmCertifyInfo)
    {
        return toAjax(farmCertifyInfoService.updateFarmCertifyInfo(farmCertifyInfo));
    }

    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "农庄认证信息", businessType = BusinessType.UPDATE)
    @PutMapping("/pass")
    public AjaxResult pass(@RequestBody FarmCertifyInfo farmCertifyInfo)
    {
        farmCertifyInfo.setStatus(CetyifyStatus.PASS.getCode());
        FarmInfo farmInfo = new FarmInfo();
        farmInfo.setId(farmCertifyInfo.getFarmId());
        farmInfo.setAuthentication(CetyifyStatus.PASS.getCode());
        farmInfoService.updateFarmInfo(farmInfo);
        return toAjax(farmCertifyInfoService.updateFarmCertifyInfo(farmCertifyInfo));
    }

    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "农庄认证信息", businessType = BusinessType.UPDATE)
    @PutMapping("/reject")
    public AjaxResult reject(@RequestBody FarmCertifyInfo farmCertifyInfo)
    {
        farmCertifyInfo.setStatus(CetyifyStatus.FAIL.getCode());
        FarmInfo farmInfo = new FarmInfo();
        farmInfo.setId(farmCertifyInfo.getFarmId());
        farmInfo.setAuthentication(CetyifyStatus.FAIL.getCode());
        farmInfoService.updateFarmInfo(farmInfo);
        return toAjax(farmCertifyInfoService.updateFarmCertifyInfo(farmCertifyInfo));
    }

    /**
     * 删除农庄认证信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "农庄认证信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmCertifyInfoService.deleteFarmCertifyInfoByIds(ids));
    }
}
