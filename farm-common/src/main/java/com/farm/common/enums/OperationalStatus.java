package com.farm.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum OperationalStatus
{
    IN(1),//运营中
    OUT(0);//暂停


    private final int code;

    OperationalStatus(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

}
