package com.zj.system.util;

import java.util.HashMap;

public class AjaxResult extends HashMap<Object, Object> {
    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult() {
    }

    /**
     * 返回成功消息
     *
     * @param msg 内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg) {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 200);
        return json;
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 警告操作
     *
     * @return 提示信息
     */
    public static AjaxResult warn(String msg) {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 401);
        return json;
    }

    /**
     * 操作警告
     *
     * @return 警告提示
     */
    public static AjaxResult warn() {
        return warn("操作警告");
    }

    /**
     * 操作警告
     *
     * @param code 提示码
     * @param msg  提示信息
     * @return 警告提示
     */
    public static AjaxResult warn(Integer code, String msg) {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", code);
        return json;
    }

    /**
     * 返回错误消息
     *
     * @return 错误消息
     */
    public static AjaxResult error() {
        return error(500, "操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(String msg) {
        return error(500, msg);
    }

    /**
     * 返回错误消息
     *
     * @param code 错误码
     * @param msg  内容
     * @return 错误消息
     */
    public static AjaxResult error(Integer code, String msg) {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息
     *
     * @param key   键值
     * @param value 内容
     * @return 成功消息
     */
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
