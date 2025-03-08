package com.farm.common.enums;

/**
 * 用户状态
 *
 * @author ruoyi
 */
public enum FarmType
{

    CREATED("A", "亲子体验农庄"),
    PAID("B", "休闲度假农庄"),
    CANCEL("C", "农业观光农庄"),

    ;

    private final String code;

    private final String name;

    FarmType(String code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public static String getNameByCode(String code) {
        for (FarmType farmType : FarmType.values()) {
            if (farmType.getCode().equals(code)) {
                return farmType.getName();
            }
        }
        return null; // 如果没有找到对应的代码，返回 null 或抛出异常
    }
}
