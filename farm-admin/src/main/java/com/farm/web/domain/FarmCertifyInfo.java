package com.farm.web.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.farm.common.annotation.Excel;
import com.farm.common.core.domain.BaseEntity;

/**
 * 农庄认证信息对象 farm_certify_info
 * 
 * @author ruoyi
 * @date 2025-03-05
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
public class FarmCertifyInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private int id;

    /** 法人姓名 */
    @Excel(name = "法人姓名")
    private String legalName;

    /** 法人身份证 */
    @Excel(name = "法人身份证")
    private String legalIdCard;

    /** 营业执照扫描件链接 */
    @Excel(name = "营业执照扫描件链接")
    private String images;
    private int farmId;

    private int status;

    /** 营业执照编号 */
    @Excel(name = "营业执照编号")
    private String businessLicenseNum;

    public void setId(int id)
    {
        this.id = id;
    }

    public int getFarmId()
    {
        return farmId;
    }

    public void setFarmId(int farmId)
    {
        this.farmId = farmId;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }

    public int getStatus()
    {
        return status;
    }

    public int getId()
    {
        return id;
    }

    public void setLegalName(String legalName) 
    {
        this.legalName = legalName;
    }

    public String getLegalName() 
    {
        return legalName;
    }

    public void setLegalIdCard(String legalIdCard) 
    {
        this.legalIdCard = legalIdCard;
    }

    public String getLegalIdCard() 
    {
        return legalIdCard;
    }

    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
    }

    public void setBusinessLicenseNum(String businessLicenseNum) 
    {
        this.businessLicenseNum = businessLicenseNum;
    }

    public String getBusinessLicenseNum() 
    {
        return businessLicenseNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("legalName", getLegalName())
            .append("legalIdCard", getLegalIdCard())
            .append("images", getImages())
            .append("businessLicenseNum", getBusinessLicenseNum())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
