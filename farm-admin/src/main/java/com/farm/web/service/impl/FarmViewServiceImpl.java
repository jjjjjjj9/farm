package com.farm.web.service.impl;

import java.util.List;
import com.farm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm.web.mapper.FarmViewMapper;
import com.farm.web.domain.FarmView;
import com.farm.web.service.IFarmViewService;

/**
 * 农庄浏览Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-07
 */
@Service
public class FarmViewServiceImpl implements IFarmViewService 
{
    @Autowired
    private FarmViewMapper farmViewMapper;

    /**
     * 查询农庄浏览
     * 
     * @param id 农庄浏览主键
     * @return 农庄浏览
     */
    @Override
    public FarmView selectFarmViewById(Long id)
    {
        return farmViewMapper.selectFarmViewById(id);
    }

    /**
     * 查询农庄浏览列表
     * 
     * @param farmView 农庄浏览
     * @return 农庄浏览
     */
    @Override
    public List<FarmView> selectFarmViewList(FarmView farmView)
    {
        return farmViewMapper.selectFarmViewList(farmView);
    }

    /**
     * 新增农庄浏览
     * 
     * @param farmView 农庄浏览
     * @return 结果
     */
    @Override
    public int insertFarmView(FarmView farmView)
    {
        farmView.setCreateTime(DateUtils.getNowDate());
        return farmViewMapper.insertFarmView(farmView);
    }

    /**
     * 修改农庄浏览
     * 
     * @param farmView 农庄浏览
     * @return 结果
     */
    @Override
    public int updateFarmView(FarmView farmView)
    {
        farmView.setUpdateTime(DateUtils.getNowDate());
        return farmViewMapper.updateFarmView(farmView);
    }

    /**
     * 批量删除农庄浏览
     * 
     * @param ids 需要删除的农庄浏览主键
     * @return 结果
     */
    @Override
    public int deleteFarmViewByIds(Long[] ids)
    {
        return farmViewMapper.deleteFarmViewByIds(ids);
    }

    /**
     * 删除农庄浏览信息
     * 
     * @param id 农庄浏览主键
     * @return 结果
     */
    @Override
    public int deleteFarmViewById(Long id)
    {
        return farmViewMapper.deleteFarmViewById(id);
    }
}
