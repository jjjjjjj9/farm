package com.farm.common.core.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户注册对象
 * 
 * @author ruoyi
 */
@Data
@Getter
@Setter
public class RegisterBody extends LoginBody
{
    private String type;
}
