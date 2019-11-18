package com.zj.system.entity;
/**
 * 设备信息类
 * @author : 郑杰
 * @date : 2019/11/13 9:28
 */
public class DeviceEntity {

    /**userAgent信息*/
    private String userAgent;

    /**设备名称*/
    private String name;

    /**设备类型*/
    private String type;

    /**设备ip地址*/
    private String ip;

    /**访问地区*/
    private String region;

    /**访问次数*/
    private String visits;

    /**访问时间*/
    private String time;

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVisits() {
        return visits;
    }

    public void setVisits(String visits) {
        this.visits = visits;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "userAgent='" + userAgent + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", ip='" + ip + '\'' +
                ", region='" + region + '\'' +
                ", visits='" + visits + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
