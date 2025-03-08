package com.farm.web.mapper;

import java.util.List;
import com.farm.web.domain.FarmReview;

/**
 * 项目评价Mapper接口
 * 
 * @author AA
 * @date 2025-03-05
 */
public interface FarmReviewMapper 
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
     * 删除项目评价
     * 
     * @param id 项目评价主键
     * @return 结果
     */
    public int deleteFarmReviewById(Long id);

    /**
     * 批量删除项目评价
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmReviewByIds(Long[] ids);
}
