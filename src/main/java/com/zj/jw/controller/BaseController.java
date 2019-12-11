package com.zj.jw.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zj.jw.common.domain.PageResult;
import com.zj.jw.common.domain.TableDataInfo;
import com.zj.system.util.AjaxResult;
import com.zj.system.util.TableSupport;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class BaseController {
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    setValue(DateUtils.parseDate(text));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageResult pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (ObjectUtil.isNotNull(pageNum) && ObjectUtil.isNotNull(pageSize)) {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }


    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list) {

        TableDataInfo rspData = new TableDataInfo();
        //rspData.setCode(200);
        rspData.setData(list);
        rspData.setCount(new PageInfo(list).getTotal());
        //rspData.setMsg("没有数据!");
        return rspData;
    }


    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return result
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? success() : error();
    }

    /**
     * 响应返回结果
     *
     * @param flag boolean
     * @return result
     */
    protected AjaxResult toAjax(Boolean flag) {
        return flag ? success() : error();
    }

    /**
     * 返回成功
     */
    public AjaxResult success() {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error() {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message) {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message) {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public AjaxResult error(int code, String message) {
        return AjaxResult.error(code, message);
    }

    /**
     * 返回提示码消息
     */
    public AjaxResult warn() {
        return AjaxResult.warn();
    }

    /**
     * 返回提示码消息
     */
    public AjaxResult warn(String message) {
        return AjaxResult.warn(message);
    }

    /**
     * 返回提示码消息
     */
    public AjaxResult warn(Integer code, String message) {
        return AjaxResult.warn(code, message);
    }

}
