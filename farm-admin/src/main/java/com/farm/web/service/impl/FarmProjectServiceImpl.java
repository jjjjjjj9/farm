package com.farm.web.service.impl;

import com.farm.common.utils.DateUtils;
import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmProject;
import com.farm.web.domain.FarmView;
import com.farm.web.mapper.FarmProjectMapper;
import com.farm.web.service.IFarmProjectService;
import com.farm.web.service.IFarmViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 农庄项目Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
@Service
public class FarmProjectServiceImpl implements IFarmProjectService 
{
    @Autowired
    private FarmProjectMapper farmProjectMapper;

    @Autowired
    private IFarmViewService farmViewService;

    /**
     * 查询农庄项目
     * 
     * @param id 农庄项目主键
     * @return 农庄项目
     */
    @Override
    public FarmProject selectFarmProjectById(Long id)
    {
        FarmView farmView = new FarmView();
        farmView.setProjectId(id);
        farmViewService.view(farmView);
        return farmProjectMapper.selectFarmProjectById(id);
    }

    /**
     * 查询农庄项目列表
     * 
     * @param farmProject 农庄项目
     * @return 农庄项目
     */
    @Override
    public List<FarmProject> selectFarmProjectList(FarmProject farmProject)
    {
        return farmProjectMapper.selectFarmProjectList(farmProject);
    }

    /**
     * 新增农庄项目
     * 
     * @param farmProject 农庄项目
     * @return 结果
     */
    @Override
    public int insertFarmProject(FarmProject farmProject)
    {
        farmProject.setCreateTime(DateUtils.getNowDate());
        return farmProjectMapper.insertFarmProject(farmProject);
    }

    /**
     * 修改农庄项目
     * 
     * @param farmProject 农庄项目
     * @return 结果
     */
    @Override
    public int updateFarmProject(FarmProject farmProject)
    {
        farmProject.setUpdateTime(DateUtils.getNowDate());
        return farmProjectMapper.updateFarmProject(farmProject);
    }

    /**
     * 批量删除农庄项目
     * 
     * @param ids 需要删除的农庄项目主键
     * @return 结果
     */
    @Override
    public int deleteFarmProjectByIds(Long[] ids)
    {
        return farmProjectMapper.deleteFarmProjectByIds(ids);
    }

    /**
     * 删除农庄项目信息
     * 
     * @param id 农庄项目主键
     * @return 结果
     */
    @Override
    public int deleteFarmProjectById(Long id)
    {
        return farmProjectMapper.deleteFarmProjectById(id);
    }

    @Override
    public List<CountObject> getProjectTypeNum() {
        return farmProjectMapper.getProjectTypeNum();
    }

    @Override
    public List<FarmProject> getHotProject() {
        return farmProjectMapper.getHotProject();
    }
}
