package com.farm.web.controller;

import com.farm.common.annotation.Log;
import com.farm.common.core.controller.BaseController;
import com.farm.common.core.domain.AjaxResult;
import com.farm.common.core.page.TableDataInfo;
import com.farm.common.enums.BusinessType;
import com.farm.common.enums.OrderStatus;
import com.farm.common.utils.poi.ExcelUtil;
import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmOrder;
import com.farm.web.service.IFarmOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 农庄订单Controller
 *
 * @author ruoyi
 * @date 2025-03-07
 */
@RestController
@RequestMapping("/system/order")
public class FarmOrderController extends BaseController {
    @Autowired
    private IFarmOrderService farmOrderService;

    /**
     * 查询农庄订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(FarmOrder farmOrder) {
        startPage();
        List<FarmOrder> list = farmOrderService.selectFarmOrderList(farmOrder);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/getMonthOrderPrice")
    public Map<String, Object> getMonthOrderPrice() {
        Map<String, Object> map = new HashMap<>();
        List<CountObject> list = farmOrderService.getMonthOrderPrice();
        String[] months = new String[list.size()];
        int[] values = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            months[i] = list.get(i).getName();
            values[i] = list.get(i).getValue();
        }
        map.put("months", months);
        map.put("values", values);
        return map;
    }

    /**
     * 导出农庄订单列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "农庄订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmOrder farmOrder) {
        List<FarmOrder> list = farmOrderService.selectFarmOrderList(farmOrder);
        ExcelUtil<FarmOrder> util = new ExcelUtil<FarmOrder>(FarmOrder.class);
        util.exportExcel(response, list, "农庄订单数据");
    }

    /**
     * 获取农庄订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(farmOrderService.selectFarmOrderById(id));
    }

    /**
     * 新增农庄订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "农庄订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmOrder farmOrder) {
        return toAjax(farmOrderService.insertFarmOrder(farmOrder));
    }

    /**
     * 修改农庄订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "农庄订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmOrder farmOrder) {
        return toAjax(farmOrderService.updateFarmOrder(farmOrder));
    }

    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "农庄订单", businessType = BusinessType.UPDATE)
    @PutMapping("/confirmOrder")
    public AjaxResult confirmOrder(@RequestBody FarmOrder farmOrder) {
        farmOrder.setOrderStatus(OrderStatus.DELIVERED.getCode());
        return toAjax(farmOrderService.updateFarmOrder(farmOrder));
    }

    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "农庄订单", businessType = BusinessType.UPDATE)
    @PutMapping("/cancelOrder")
    public AjaxResult cancelOrder(@RequestBody FarmOrder farmOrder) {
        farmOrder.setOrderStatus(OrderStatus.CANCEL.getCode());
        return toAjax(farmOrderService.updateFarmOrder(farmOrder));
    }

    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "农庄订单", businessType = BusinessType.UPDATE)
    @PutMapping("/refundOrder")
    public AjaxResult refundOrder(@RequestBody FarmOrder farmOrder) {
        farmOrder.setOrderStatus(OrderStatus.REFUND.getCode());
        return toAjax(farmOrderService.updateFarmOrder(farmOrder));
    }

    /**
     * 删除农庄订单
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "农庄订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(farmOrderService.deleteFarmOrderByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "农庄订单", businessType = BusinessType.INSERT)
    @PostMapping("/createOrder")
    public AjaxResult createOrder(@RequestBody FarmOrder farmOrder) {
        return toAjax(farmOrderService.createOrder(farmOrder));
    }
}
