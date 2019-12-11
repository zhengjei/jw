package com.zj.system.util;

import cn.hutool.core.util.ObjectUtil;
import com.zj.jw.common.constant.SysConstant;

public class StringUtils extends org.apache.commons.lang3.StringUtils  {

    /**
     * 下划线
     */
    private static final char SEPARATOR = '_';


    /**
     * 下划线转驼峰命名
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (StringUtils.isNotEmpty(str) && ObjectUtil.isNotNull(strs)) {
            for (String s : strs) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否为空
     */
    public static boolean isNull(String obj) {
        return "".equals(obj) || obj.isEmpty() || SysConstant.FREEZE.equals(obj.length()) || obj.equals(null);
    }

    public static boolean isNotNull(String s) {
        return !isNull(s);
    }
}
