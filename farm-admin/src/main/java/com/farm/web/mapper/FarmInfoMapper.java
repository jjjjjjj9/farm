package com.farm.web.mapper;

import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmInfo;

import java.util.List;

/**
 * 农庄信息Mapper接口
 * 
 * @author AA
 * @date 2025-03-05
 */
public interface FarmInfoMapper 
{
    /**
     * 查询农庄信息
     * 
     * @param id 农庄信息主键
     * @return 农庄信息
     */
    public FarmInfo selectFarmInfoById(Long id);

    /**
     * 查询农庄信息列表
     * 
     * @param farmInfo 农庄信息
     * @return 农庄信息集合
     */
    public List<FarmInfo> selectFarmInfoList(FarmInfo farmInfo);

    /**
     * 新增农庄信息
     * 
     * @param farmInfo 农庄信息
     * @return 结果
     */
    public int insertFarmInfo(FarmInfo farmInfo);

    /**
     * 修改农庄信息
     * 
     * @param farmInfo 农庄信息
     * @return 结果
     */
    public int updateFarmInfo(FarmInfo farmInfo);

    /**
     * 删除农庄信息
     * 
     * @param id 农庄信息主键
     * @return 结果
     */
    public int deleteFarmInfoById(Long id);

    /**
     * 批量删除农庄信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmInfoByIds(Long[] ids);

    List<CountObject> getFarmTypeNumData();
}
