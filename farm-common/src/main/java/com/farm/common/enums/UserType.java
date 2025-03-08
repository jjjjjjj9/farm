package com.farm.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum UserType
{
    VIEWER(1),//游客(普通用户)
    FRAMER(2),
    ADMIN(3);

    private final int code;

    UserType(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

}
