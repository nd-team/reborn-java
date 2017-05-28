package com.bjike.reborn.commodity.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * 生成商品sku
 *
 * @Author: [liguiqin]
 * @Date: [2017-05-27 16:25]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class SkuUtil {
    public static String getSku(int categorySeq, int brandSeq) {
        LocalDate now = LocalDate.now();
        String year = String.valueOf(now.getYear()).substring(2, 4);
        String month = String.valueOf(now.getMonthValue());
        String day = String.valueOf(now.getDayOfMonth());
        if (month.length() == 1) {
            month = "0" + month;
        }
        if (day.length() == 1) {
            day = "0" + day;
        }
        return year + month + day + categorySeq + new Random().nextInt(9999) + LocalDateTime.now().getSecond();
    }

    public static void main(String[] args) {
        System.out.println(getSku(5, 4));
    }
}
