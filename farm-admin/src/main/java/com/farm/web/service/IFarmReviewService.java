package com.farm.web.service;

import java.util.List;
import com.farm.web.domain.FarmReview;

/**
 * 项目评价Service接口
 * 
 * @author AA
 * @date 2025-03-05
 */
public interface IFarmReviewService 
{
    /**
     * 查询项目评价
     * 
     * @param id 项目评价主键
     * @return 项目评价
     */
    public FarmReview selectFarmReviewById(Long id);

    /**
     * 查询项目评价列表
     * 
     * @param farmReview 项目评价
     * @return 项目评价集合
     */
    public List<FarmReview> selectFarmReviewList(FarmReview farmReview);

    /**
     * 新增项目评价
     * 
     * @param farmReview 项目评价
     * @return 结果
     */
    public int insertFarmReview(FarmReview farmReview);

    /**
     * 修改项目评价
     * 
     * @param farmReview 项目评价
     * @return 结果
     */
    public int updateFarmReview(FarmReview farmReview);

    /**
     * 批量删除项目评价
     * 
     * @param ids 需要删除的项目评价主键集合
     * @return 结果
     */
    public int deleteFarmReviewByIds(Long[] ids);

    /**
     * 删除项目评价信息
     * 
     * @param id 项目评价主键
     * @return 结果
     */
    public int deleteFarmReviewById(Long id);
}
