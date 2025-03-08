package com.farm.web.service.impl;

import com.farm.common.utils.DateUtils;
import com.farm.web.domain.FarmReview;
import com.farm.web.mapper.FarmReviewMapper;
import com.farm.web.service.IFarmReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目评价Service业务层处理
 * 
 * @author AA
 * @date 2025-03-05
 */
@Service
public class FarmReviewServiceImpl implements IFarmReviewService 
{
    @Autowired
    private FarmReviewMapper farmReviewMapper;

    /**
     * 查询项目评价
     * 
     * @param id 项目评价主键
     * @return 项目评价
     */
    @Override
    public FarmReview selectFarmReviewById(Long id)
    {
        return farmReviewMapper.selectFarmReviewById(id);
    }

    /**
     * 查询项目评价列表
     * 
     * @param farmReview 项目评价
     * @return 项目评价
     */
    @Override
    public List<FarmReview> selectFarmReviewList(FarmReview farmReview)
    {
        return farmReviewMapper.selectFarmReviewList(farmReview);
    }

    /**
     * 新增项目评价
     * 
     * @param farmReview 项目评价
     * @return 结果
     */
    @Override
    public int insertFarmReview(FarmReview farmReview)
    {
        farmReview.setCreateTime(DateUtils.getNowDate());
        return farmReviewMapper.insertFarmReview(farmReview);
    }

    /**
     * 修改项目评价
     * 
     * @param farmReview 项目评价
     * @return 结果
     */
    @Override
    public int updateFarmReview(FarmReview farmReview)
    {
        if(farmReview.getStatus().equals("正常")){
            farmReview.setReason("");
        }
        farmReview.setUpdateTime(DateUtils.getNowDate());
        return farmReviewMapper.updateFarmReview(farmReview);
    }

    /**
     * 批量删除项目评价
     * 
     * @param ids 需要删除的项目评价主键
     * @return 结果
     */
    @Override
    public int deleteFarmReviewByIds(Long[] ids)
    {
        return farmReviewMapper.deleteFarmReviewByIds(ids);
    }

    /**
     * 删除项目评价信息
     * 
     * @param id 项目评价主键
     * @return 结果
     */
    @Override
    public int deleteFarmReviewById(Long id)
    {
        return farmReviewMapper.deleteFarmReviewById(id);
    }
}
