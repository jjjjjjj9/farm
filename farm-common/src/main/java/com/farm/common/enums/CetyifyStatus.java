package com.farm.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum CetyifyStatus
{
    PASS(2),
    WAIT(1),
    SUBMIT(0),
    FAIL(-1);

    private final int code;

    CetyifyStatus(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

}
