package com.zj.system.entity;

public class VisitEntity {
    /**类型*/
    private String name;

    /**数量*/
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public VisitEntity() {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "VisitEntity{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
