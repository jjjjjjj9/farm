package com.farm.web.service;

import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmProject;

import java.util.List;

/**
 * 农庄项目Service接口
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
public interface IFarmProjectService 
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
     * 批量删除农庄项目
     * 
     * @param ids 需要删除的农庄项目主键集合
     * @return 结果
     */
    public int deleteFarmProjectByIds(Long[] ids);

    /**
     * 删除农庄项目信息
     * 
     * @param id 农庄项目主键
     * @return 结果
     */
    public int deleteFarmProjectById(Long id);

    List<CountObject> getProjectTypeNum();

    List<FarmProject> getHotProject();
}
