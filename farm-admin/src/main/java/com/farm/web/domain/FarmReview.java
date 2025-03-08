package com.farm.web.domain;

import com.farm.common.annotation.Excel;
import com.farm.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目评价对象 farm_review
 * 
 * @author AA
 * @date 2025-03-05
 */
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FarmReview extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private int id;

    /** 评分 */
    @Excel(name = "评分")
    private String mark;

    /** 评价 */
    @Excel(name = "评价")
    private String info;

    /** 被评价项目id */
    @Excel(name = "被评价项目id")
    private Long projectId;

    /** 评价人id */
    @Excel(name = "评价人id")
    private Long userId;

    private String name;//项目名称

    private String userName;//用户名称

    private String status;

    private String reason;//用户名称

}
