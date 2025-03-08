package com.farm.web.domain;

import com.farm.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
public class CountObject extends BaseEntity
{
    private String name;
    private int value;
}
