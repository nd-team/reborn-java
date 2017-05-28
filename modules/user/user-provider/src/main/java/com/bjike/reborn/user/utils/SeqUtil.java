package com.bjike.reborn.user.utils;

import com.bjike.reborn.common.api.exception.SerException;
import org.apache.commons.lang3.StringUtils;

/**
 * 序列工具
 *
 * @Author: [liguiqin]
 * @Date: [2017-05-18 10:19]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class SeqUtil {

    private static final String SYS_NUMBER = "SYS.NO"; // 系统编号格式
    private static final Integer SYS_NUMBER_LENGTH = 12; // 员工编号长度
    private static final String ZERO_NUMBER = "000000"; // 员工编号0位数
    private static final String START_NUMBER = "100000"; // 编号开始


    /**
     * 生成下一个编号
     *
     * @param systemNO 最大员工编号
     */
    public static synchronized String generateSys(String systemNO) throws SerException {
        if (StringUtils.isNotBlank(systemNO)) {
            Integer number = Integer.parseInt(StringUtils.substringAfter(systemNO, SYS_NUMBER)) + 1;
            Integer length = SYS_NUMBER_LENGTH - (String.valueOf(number).length());
            if (length > 0) {
                systemNO = SYS_NUMBER + ZERO_NUMBER.substring(0, length - SYS_NUMBER.length());
            } else if (0 == length) {
                systemNO = SYS_NUMBER + number;
            } else {
                throw new SerException("系统编号超出长度:" + length);
            }
            return systemNO + number;
        } else {
            return generateSys(SYS_NUMBER + START_NUMBER); //假如为空,则从第一个开始SYS.NO000001
        }

    }



    public static void main(String[] args) throws SerException {
        System.out.println(generateSys(null));
    }
}
