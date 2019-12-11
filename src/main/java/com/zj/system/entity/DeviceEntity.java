package com.zj.system.entity;
/**
 * 设备信息类
 * @author : 郑杰
 * @date : 2019/11/13 9:28
 */
public class DeviceEntity extends ApiEntity{


    /**userAgent信息*/
    private String userAgent;

    /**操作系统*/
    private String system;

    /**设备类型*/
    private String device;

    /**浏览器*/
    private String browser;

    /**类型*/
    private String type;

    /**访问时间*/
    private String time;

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "userAgent='" + userAgent + '\'' +
                ", system='" + system + '\'' +
                ", device='" + device + '\'' +
                ", browser='" + browser + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
