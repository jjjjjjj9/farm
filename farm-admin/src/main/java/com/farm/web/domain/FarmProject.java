package com.farm.web.domain;

import com.farm.common.annotation.Excel;
import com.farm.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 农庄项目对象 farm_project
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FarmProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private int id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long farmId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String projectInfo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal price;

    @Excel(name = "认证状态")
    private int status;

    /** 可预约人数 */
    @Excel(name = "可预约人数")
    private Long availableCapacity;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setFarmId(Long farmId) 
    {
        this.farmId = farmId;
    }

    public Long getFarmId() 
    {
        return farmId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setProjectInfo(String projectInfo) 
    {
        this.projectInfo = projectInfo;
    }

    public String getProjectInfo() 
    {
        return projectInfo;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public int getStatus()
    {
        return status;
    }

    public void setAvailableCapacity(Long availableCapacity) 
    {
        this.availableCapacity = availableCapacity;
    }

    public Long getAvailableCapacity() 
    {
        return availableCapacity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("farmId", getFarmId())
            .append("name", getName())
            .append("projectInfo", getProjectInfo())
            .append("price", getPrice())
            .append("availableCapacity", getAvailableCapacity())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
