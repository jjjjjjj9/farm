package com.farm.web.service;

import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmOrder;

import java.util.List;

/**
 * 农庄订单Service接口
 * 
 * @author ruoyi
 * @date 2025-03-07
 */
public interface IFarmOrderService 
{
    /**
     * 查询农庄订单
     * 
     * @param id 农庄订单主键
     * @return 农庄订单
     */
    public FarmOrder selectFarmOrderById(Long id);

    /**
     * 查询农庄订单列表
     * 
     * @param farmOrder 农庄订单
     * @return 农庄订单集合
     */
    public List<FarmOrder> selectFarmOrderList(FarmOrder farmOrder);

    /**
     * 新增农庄订单
     * 
     * @param farmOrder 农庄订单
     * @return 结果
     */
    public int insertFarmOrder(FarmOrder farmOrder);

    /**
     * 修改农庄订单
     * 
     * @param farmOrder 农庄订单
     * @return 结果
     */
    public int updateFarmOrder(FarmOrder farmOrder);

    /**
     * 批量删除农庄订单
     * 
     * @param ids 需要删除的农庄订单主键集合
     * @return 结果
     */
    public int deleteFarmOrderByIds(Long[] ids);

    /**
     * 删除农庄订单信息
     * 
     * @param id 农庄订单主键
     * @return 结果
     */
    public int deleteFarmOrderById(Long id);

    List<CountObject> getMonthOrderPrice();

    int createOrder(FarmOrder farmOrder);
}
