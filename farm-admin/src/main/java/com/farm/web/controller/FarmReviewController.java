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
import com.farm.web.domain.FarmReview;
import com.farm.web.service.IFarmReviewService;
import com.farm.common.utils.poi.ExcelUtil;
import com.farm.common.core.page.TableDataInfo;

/**
 * 项目评价Controller
 * 
 * @author AA
 * @date 2025-03-05
 */
@RestController
@RequestMapping("/system/review")
public class FarmReviewController extends BaseController
{
    @Autowired
    private IFarmReviewService farmReviewService;

    /**
     * 查询项目评价列表
     */
    @PreAuthorize("@ss.hasPermi('system:review:list')")
    @GetMapping("/list")
    public TableDataInfo list(FarmReview farmReview)
    {
        startPage();
        List<FarmReview> list = farmReviewService.selectFarmReviewList(farmReview);
        return getDataTable(list);
    }

    /**
     * 导出项目评价列表
     */
    @PreAuthorize("@ss.hasPermi('system:review:export')")
    @Log(title = "项目评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmReview farmReview)
    {
        List<FarmReview> list = farmReviewService.selectFarmReviewList(farmReview);
        ExcelUtil<FarmReview> util = new ExcelUtil<FarmReview>(FarmReview.class);
        util.exportExcel(response, list, "项目评价数据");
    }

    /**
     * 获取项目评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:review:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmReviewService.selectFarmReviewById(id));
    }

    /**
     * 新增项目评价
     */
    @PreAuthorize("@ss.hasPermi('system:review:add')")
    @Log(title = "项目评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmReview farmReview)
    {
        return toAjax(farmReviewService.insertFarmReview(farmReview));
    }

    /**
     * 修改项目评价
     */
    @PreAuthorize("@ss.hasPermi('system:review:edit')")
    @Log(title = "项目评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmReview farmReview)
    {
        return toAjax(farmReviewService.updateFarmReview(farmReview));
    }

    /**
     * 删除项目评价
     */
    @PreAuthorize("@ss.hasPermi('system:review:remove')")
    @Log(title = "项目评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmReviewService.deleteFarmReviewByIds(ids));
    }
}
