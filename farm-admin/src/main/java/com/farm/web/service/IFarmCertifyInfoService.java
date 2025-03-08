package com.farm.web.service;

import com.farm.web.domain.FarmCertifyInfo;

import java.util.List;

/**
 * 农庄认证信息Service接口
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
public interface IFarmCertifyInfoService 
{
    /**
     * 查询农庄认证信息
     * 
     * @param id 农庄认证信息主键
     * @return 农庄认证信息
     */
    public FarmCertifyInfo selectFarmCertifyInfoById(Long id);

    /**
     * 查询农庄认证信息列表
     * 
     * @param farmCertifyInfo 农庄认证信息
     * @return 农庄认证信息集合
     */
    public List<FarmCertifyInfo> selectFarmCertifyInfoList(FarmCertifyInfo farmCertifyInfo);

    /**
     * 新增农庄认证信息
     * 
     * @param farmCertifyInfo 农庄认证信息
     * @return 结果
     */
    public int insertFarmCertifyInfo(FarmCertifyInfo farmCertifyInfo);

    /**
     * 修改农庄认证信息
     * 
     * @param farmCertifyInfo 农庄认证信息
     * @return 结果
     */
    public int updateFarmCertifyInfo(FarmCertifyInfo farmCertifyInfo);

    /**
     * 批量删除农庄认证信息
     * 
     * @param ids 需要删除的农庄认证信息主键集合
     * @return 结果
     */
    public int deleteFarmCertifyInfoByIds(Long[] ids);

    /**
     * 删除农庄认证信息信息
     * 
     * @param id 农庄认证信息主键
     * @return 结果
     */
    public int deleteFarmCertifyInfoById(Long id);

    List<FarmCertifyInfo> selectByUserId(int userId);
}
