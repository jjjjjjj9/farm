package com.farm.web.domain;

import com.farm.common.annotation.Excel;
import com.farm.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 农庄信息对象 farm_info
 * 
 * @author AA
 * @date 2025-03-05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
public class FarmInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private int id;

    /** 农村名称 */
    @Excel(name = "农村名称")
    private String name;

    /** 农场拥有者

 */
    @Excel(name = "农场拥有者 ")
    private String ownerId;

    /** 农场图片 */
    @Excel(name = "农场图片")
    private String images;

    /** 基本介绍 */
    @Excel(name = "基本介绍")
    private String info;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 项目总数 */
    @Excel(name = "项目总数")
    private Long num;

    /** 平均评分 */
    @Excel(name = "平均评分")
    private BigDecimal avgScore;

    /** 营业时间 */
    @Excel(name = "营业时间")
    private String businessTime;

    /** 容纳总人数 */
    @Excel(name = "容纳总人数")
    private Long totalCapacity;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private Long idRecommend;

    /** 认证状态 */
    @Excel(name = "认证状态")
    private int status;

    private int authentication;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String tel;

    @Excel(name = "农庄类型")
    private String farmType;

    private int businessStatus;

}
