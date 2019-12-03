package com.zj.system.entity;
/**
 *
 * @author : 郑杰
 * @date : 2019/11/13 9:28
 */
public class ApiEntity {
    /**ip*/
    private String id;

    /**ip*/
    private String cip;

    /**地区代码*/
    private String cid;

    /**地区名称*/
    private String cname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "ApiEntity{" +
                "id='" + id + '\'' +
                ", cip='" + cip + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
