package com.farm.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum OrderStatus
{
    CREATED("A", "待支付"),
    PAID("B", "已支付"),
    CANCEL("C", "已取消"),
    DELIVERED("D", "已确认"),
    RECEIVED("E", "已完成"),
    DELETED("F", "已删除"),
    AREFUND("G", "退款审核"),
    REFUND("H", "已退款")
    ;

    private final String code;

    private final String name;

    OrderStatus(String code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public String getCode()
    {
        return code;
    }

}
