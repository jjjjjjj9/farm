package com.farm.web.domain;

import com.farm.common.annotation.Excel;
import com.farm.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 农庄订单对象 farm_order
 * 
 * @author ruoyi
 * @date 2025-03-07
 */
@Data
@Getter
@Setter
public class FarmOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 关联用户 */
    @Excel(name = "关联用户")
    private Long userId;

    /** 关联项目 */
    @Excel(name = "关联项目")
    private Long projectId;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStatus;

    private String userName;
    private String farmName;
    private String projectName;
    private String projectImages;
    private String projectPrice;
    private String businessTime;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("projectId", getProjectId())
            .append("price", getPrice())
            .append("orderStatus", getOrderStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
