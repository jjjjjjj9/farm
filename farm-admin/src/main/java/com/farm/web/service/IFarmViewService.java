package com.farm.web.service;

import com.farm.web.domain.FarmView;

import java.util.List;

/**
 * 农庄浏览Service接口
 * 
 * @author ruoyi
 * @date 2025-03-07
 */
public interface IFarmViewService 
{
    /**
     * 查询农庄浏览
     * 
     * @param id 农庄浏览主键
     * @return 农庄浏览
     */
    public FarmView selectFarmViewById(Long id);

    /**
     * 查询农庄浏览列表
     * 
     * @param farmView 农庄浏览
     * @return 农庄浏览集合
     */
    public List<FarmView> selectFarmViewList(FarmView farmView);

    /**
     * 新增农庄浏览
     * 
     * @param farmView 农庄浏览
     * @return 结果
     */
    public int insertFarmView(FarmView farmView);

    /**
     * 修改农庄浏览
     * 
     * @param farmView 农庄浏览
     * @return 结果
     */
    public int updateFarmView(FarmView farmView);

    /**
     * 批量删除农庄浏览
     * 
     * @param ids 需要删除的农庄浏览主键集合
     * @return 结果
     */
    public int deleteFarmViewByIds(Long[] ids);

    /**
     * 删除农庄浏览信息
     * 
     * @param id 农庄浏览主键
     * @return 结果
     */
    public int deleteFarmViewById(Long id);

    int view(FarmView farmView);
}
