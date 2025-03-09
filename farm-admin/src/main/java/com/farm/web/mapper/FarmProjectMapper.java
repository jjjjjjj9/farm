package com.farm.web.mapper;

import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmProject;

import java.util.List;

/**
 * 农庄项目Mapper接口
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
public interface FarmProjectMapper 
{
    /**
     * 查询农庄项目
     * 
     * @param id 农庄项目主键
     * @return 农庄项目
     */
    public FarmProject selectFarmProjectById(Long id);

    /**
     * 查询农庄项目列表
     * 
     * @param farmProject 农庄项目
     * @return 农庄项目集合
     */
    public List<FarmProject> selectFarmProjectList(FarmProject farmProject);

    /**
     * 新增农庄项目
     * 
     * @param farmProject 农庄项目
     * @return 结果
     */
    public int insertFarmProject(FarmProject farmProject);

    /**
     * 修改农庄项目
     * 
     * @param farmProject 农庄项目
     * @return 结果
     */
    public int updateFarmProject(FarmProject farmProject);

    /**
     * 删除农庄项目
     * 
     * @param id 农庄项目主键
     * @return 结果
     */
    public int deleteFarmProjectById(Long id);

    /**
     * 批量删除农庄项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmProjectByIds(Long[] ids);

    List<CountObject> getProjectTypeNum();

    List<FarmProject> getHotProject();
}
