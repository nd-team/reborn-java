package com.bjike.reborn.common.api.type;

/**
 * jpa映射条件类型
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public enum RestrictionType {
    /**
     * 相等
     */
    EQ,
    /**
     * 在什么之间
     */
    BETWEEN,
    /**
     * 模糊
     */
    LIKE,
    /**
     * 在什么范围之间
     */
    IN,
    /**
     * 大于
     */
    GT,
    /**
     * 少于
     */
    LT,
    /**
     * 或者
     */
    OR,
    /**
     * 不等于
     */
    NE,
    /**
     * 大于等于
     */
    GTEQ,
    /**
     * 小于等于
     */
    LTEQ,
    /**
     * 为空
     */
    ISNULL,
    /**
     * 不为空
     */
    ISNOTNULL,
    /**
     * 不为空
     */
    NOTIN;


    public static RestrictionType valueOf(Object val) {
        String vv = String.valueOf(val);
        switch (vv) {
            case "EQ":
                return RestrictionType.EQ;
            case "BETWEEN":
                return RestrictionType.BETWEEN;
            case "LIKE":
                return RestrictionType.LIKE;
            case "IN":
                return RestrictionType.IN;
            case "GT":
                return RestrictionType.GT;
            case "LT":
                return RestrictionType.LT;
            case "GTEQ":
                return RestrictionType.GTEQ;
            case "LTEQ":
                return RestrictionType.LTEQ;
            case "OR":
                return RestrictionType.OR;
            case "NE":
                return RestrictionType.NE;
            case "ISNULL":
                return RestrictionType.ISNULL;
            case "ISNOTNULL":
                return RestrictionType.ISNOTNULL;
            case "NOTIN":
                return RestrictionType.NOTIN;
            default:
                return RestrictionType.EQ;
        }
    }

    public static String getRestrict(RestrictionType type) {
        switch (type) {
            case EQ:
                return "equal";
            case BETWEEN:
                return "between";
            case LIKE:
                return "like";
            case IN:
                return "in";
            case GT:
                return "greaterThan";
            case LT:
                return "lessThan";
            case GTEQ:
                return "greaterThanOrEqualTo";
            case LTEQ:
                return "lessThanOrEqualTo";
            case OR:
                return "or";
            case NE:
                return "notEqual";
            case ISNULL:
                return "isNull";
            case ISNOTNULL:
                return "isNotNull";
            default:
                return "equal";
        }
    }

}
