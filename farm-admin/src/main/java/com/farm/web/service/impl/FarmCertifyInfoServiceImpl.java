package com.farm.web.service.impl;

import com.farm.common.utils.DateUtils;
import com.farm.web.domain.FarmCertifyInfo;
import com.farm.web.mapper.FarmCertifyInfoMapper;
import com.farm.web.service.IFarmCertifyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 农庄认证信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
@Service
public class FarmCertifyInfoServiceImpl implements IFarmCertifyInfoService 
{
    @Autowired
    private FarmCertifyInfoMapper farmCertifyInfoMapper;

    /**
     * 查询农庄认证信息
     * 
     * @param id 农庄认证信息主键
     * @return 农庄认证信息
     */
    @Override
    public FarmCertifyInfo selectFarmCertifyInfoById(Long id)
    {
        return farmCertifyInfoMapper.selectFarmCertifyInfoById(id);
    }

    /**
     * 查询农庄认证信息列表
     * 
     * @param farmCertifyInfo 农庄认证信息
     * @return 农庄认证信息
     */
    @Override
    public List<FarmCertifyInfo> selectFarmCertifyInfoList(FarmCertifyInfo farmCertifyInfo)
    {
        return farmCertifyInfoMapper.selectFarmCertifyInfoList(farmCertifyInfo);
    }

    /**
     * 新增农庄认证信息
     * 
     * @param farmCertifyInfo 农庄认证信息
     * @return 结果
     */
    @Override
    public int insertFarmCertifyInfo(FarmCertifyInfo farmCertifyInfo)
    {
        farmCertifyInfo.setCreateTime(DateUtils.getNowDate());
        return farmCertifyInfoMapper.insertFarmCertifyInfo(farmCertifyInfo);
    }

    /**
     * 修改农庄认证信息
     * 
     * @param farmCertifyInfo 农庄认证信息
     * @return 结果
     */
    @Override
    public int updateFarmCertifyInfo(FarmCertifyInfo farmCertifyInfo)
    {
        farmCertifyInfo.setUpdateTime(DateUtils.getNowDate());
        return farmCertifyInfoMapper.updateFarmCertifyInfo(farmCertifyInfo);
    }

    /**
     * 批量删除农庄认证信息
     * 
     * @param ids 需要删除的农庄认证信息主键
     * @return 结果
     */
    @Override
    public int deleteFarmCertifyInfoByIds(Long[] ids)
    {
        return farmCertifyInfoMapper.deleteFarmCertifyInfoByIds(ids);
    }

    /**
     * 删除农庄认证信息信息
     * 
     * @param id 农庄认证信息主键
     * @return 结果
     */
    @Override
    public int deleteFarmCertifyInfoById(Long id)
    {
        return farmCertifyInfoMapper.deleteFarmCertifyInfoById(id);
    }

    @Override
    public List<FarmCertifyInfo> selectByUserId(int userId) {
        return farmCertifyInfoMapper.selectByUserId(userId);
    }
}
