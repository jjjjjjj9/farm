package com.farm.web.mapper;

import java.util.List;
import com.farm.web.domain.FarmView;

/**
 * 农庄浏览Mapper接口
 * 
 * @author ruoyi
 * @date 2025-03-07
 */
public interface FarmViewMapper 
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
     * 删除农庄浏览
     * 
     * @param id 农庄浏览主键
     * @return 结果
     */
    public int deleteFarmViewById(Long id);

    /**
     * 批量删除农庄浏览
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmViewByIds(Long[] ids);
}
