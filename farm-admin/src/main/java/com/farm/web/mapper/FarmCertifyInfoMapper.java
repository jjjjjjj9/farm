package com.farm.web.mapper;

import com.farm.web.domain.FarmCertifyInfo;

import java.util.List;

/**
 * 农庄认证信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
public interface FarmCertifyInfoMapper 
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
     * 删除农庄认证信息
     * 
     * @param id 农庄认证信息主键
     * @return 结果
     */
    public int deleteFarmCertifyInfoById(Long id);

    /**
     * 批量删除农庄认证信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmCertifyInfoByIds(Long[] ids);

    List<FarmCertifyInfo> selectByUserId(int userId);
}
