package com.zj.system.util;


import com.zj.jw.common.constant.PageConstant;
import com.zj.jw.common.domain.PageResult;

public class TableSupport {
    /**
     * 封装分页对象
     */
    public static PageResult getPageResult() {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(ServletUtils.getParameterToInt(PageConstant.PAGE_NUM));
        pageResult.setPageSize(ServletUtils.getParameterToInt(PageConstant.PAGE_SIZE));
        pageResult.setOrderByColumn(ServletUtils.getParameter(PageConstant.ORDER_BY_COLUMN));
        pageResult.setIsAsc(ServletUtils.getParameter(PageConstant.IS_ASC));
        return pageResult;
    }

    public static PageResult buildPageRequest() {
        return getPageResult();
    }
}
