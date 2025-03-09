package com.farm.web.service.impl;

import com.farm.common.core.domain.model.LoginUser;
import com.farm.common.enums.OrderStatus;
import com.farm.common.utils.DateUtils;
import com.farm.common.utils.SecurityUtils;
import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmOrder;
import com.farm.web.mapper.FarmOrderMapper;
import com.farm.web.service.IFarmOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 农庄订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-07
 */
@Service
public class FarmOrderServiceImpl implements IFarmOrderService 
{
    @Autowired
    private FarmOrderMapper farmOrderMapper;

    /**
     * 查询农庄订单
     * 
     * @param id 农庄订单主键
     * @return 农庄订单
     */
    @Override
    public FarmOrder selectFarmOrderById(Long id)
    {
        return farmOrderMapper.selectFarmOrderById(id);
    }

    /**
     * 查询农庄订单列表
     * 
     * @param farmOrder 农庄订单
     * @return 农庄订单
     */
    @Override
    public List<FarmOrder> selectFarmOrderList(FarmOrder farmOrder)
    {
        return farmOrderMapper.selectFarmOrderList(farmOrder);
    }

    /**
     * 新增农庄订单
     * 
     * @param farmOrder 农庄订单
     * @return 结果
     */
    @Override
    public int insertFarmOrder(FarmOrder farmOrder)
    {
        farmOrder.setOrderStatus(OrderStatus.CREATED.getCode());
        farmOrder.setCreateTime(DateUtils.getNowDate());
        return farmOrderMapper.insertFarmOrder(farmOrder);
    }

    /**
     * 修改农庄订单
     * 
     * @param farmOrder 农庄订单
     * @return 结果
     */
    @Override
    public int updateFarmOrder(FarmOrder farmOrder)
    {
        farmOrder.setUpdateTime(DateUtils.getNowDate());
        return farmOrderMapper.updateFarmOrder(farmOrder);
    }

    /**
     * 批量删除农庄订单
     * 
     * @param ids 需要删除的农庄订单主键
     * @return 结果
     */
    @Override
    public int deleteFarmOrderByIds(Long[] ids)
    {
        return farmOrderMapper.deleteFarmOrderByIds(ids);
    }

    /**
     * 删除农庄订单信息
     * 
     * @param id 农庄订单主键
     * @return 结果
     */
    @Override
    public int deleteFarmOrderById(Long id)
    {
        return farmOrderMapper.deleteFarmOrderById(id);
    }

    @Override
    public List<CountObject> getMonthOrderPrice() {
        return farmOrderMapper.getMonthOrderPrice();
    }

    @Override
    public int createOrder(FarmOrder farmOrder) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        farmOrder.setUserId(loginUser.getUser().getUserId());
        farmOrder.setOrderStatus(OrderStatus.CREATED.getCode());
        return farmOrderMapper.insertFarmOrder(farmOrder);
    }
}
