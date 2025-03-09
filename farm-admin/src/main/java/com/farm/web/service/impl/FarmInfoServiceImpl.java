package com.farm.web.service.impl;

import com.farm.common.core.domain.model.LoginUser;
import com.farm.common.enums.CetyifyStatus;
import com.farm.common.enums.UserType;
import com.farm.common.utils.DateUtils;
import com.farm.common.utils.SecurityUtils;
import com.farm.web.domain.CountObject;
import com.farm.web.domain.FarmCertifyInfo;
import com.farm.web.domain.FarmInfo;
import com.farm.web.mapper.FarmCertifyInfoMapper;
import com.farm.web.mapper.FarmInfoMapper;
import com.farm.web.service.IFarmInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 农庄信息Service业务层处理
 * 
 * @author AA
 * @date 2025-03-05
 */
@Service
public class FarmInfoServiceImpl implements IFarmInfoService 
{
    @Autowired
    private FarmInfoMapper farmInfoMapper;

    @Autowired
    private FarmCertifyInfoMapper farmCertifyInfoMapper;

    /**
     * 查询农庄信息
     * 
     * @param id 农庄信息主键
     * @return 农庄信息
     */
    @Override
    public FarmInfo selectFarmInfoById(Long id)
    {
        return farmInfoMapper.selectFarmInfoById(id);
    }

    /**
     * 查询农庄信息列表
     * 
     * @param farmInfo 农庄信息
     * @return 农庄信息
     */
    @Override
    public List<FarmInfo> selectFarmInfoList(FarmInfo farmInfo)
    {
        LoginUser user = SecurityUtils.getLoginUser();
        if(user.getUser().getUserType()!= UserType.ADMIN.getCode()){
            farmInfo.setOwnerId(String.valueOf(user.getUser().getUserId()));
        }
        return farmInfoMapper.selectFarmInfoList(farmInfo);
    }

    /**
     * 新增农庄信息
     * 
     * @param farmInfo 农庄信息
     * @return 结果
     */
    @Override
    public int insertFarmInfo(FarmInfo farmInfo)
    {
        farmInfo.setAuthentication(CetyifyStatus.WAIT.getCode());
        farmInfo.setCreateTime(DateUtils.getNowDate());
        farmInfoMapper.insertFarmInfo(farmInfo);
        FarmCertifyInfo farmCertifyInfo = new FarmCertifyInfo();
        farmCertifyInfo.setFarmId(Integer.parseInt(String.valueOf(farmInfo.getId())));
        return farmCertifyInfoMapper.insertFarmCertifyInfo(farmCertifyInfo);
    }

    /**
     * 修改农庄信息
     * 
     * @param farmInfo 农庄信息
     * @return 结果
     */
    @Override
    public int updateFarmInfo(FarmInfo farmInfo)
    {
        farmInfo.setUpdateTime(DateUtils.getNowDate());
        return farmInfoMapper.updateFarmInfo(farmInfo);
    }

    /**
     * 批量删除农庄信息
     * 
     * @param ids 需要删除的农庄信息主键
     * @return 结果
     */
    @Override
    public int deleteFarmInfoByIds(Long[] ids)
    {
        return farmInfoMapper.deleteFarmInfoByIds(ids);
    }

    /**
     * 删除农庄信息信息
     * 
     * @param id 农庄信息主键
     * @return 结果
     */
    @Override
    public int deleteFarmInfoById(Long id)
    {
        return farmInfoMapper.deleteFarmInfoById(id);
    }

    @Override
    public int updateBussinessStatus(FarmInfo farmInfo) {
        if(farmInfo.getBusinessStatus()==0){
            farmInfo.setBusinessStatus(1);
        }else {
            farmInfo.setBusinessStatus(0);
        }
        return farmInfoMapper.updateFarmInfo(farmInfo);
    }

    @Override
    public List<CountObject> getFarmTypeNumData() {
        return farmInfoMapper.getFarmTypeNumData();
    }
}
