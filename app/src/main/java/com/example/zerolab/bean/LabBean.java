package com.example.zerolab.bean;

/**
 * 实验室基本信息数据bean
 * 主要包括：实验室名称、实验室介绍、实验室地址、实验室开放时间、实验室所含设备、实验室预约情况等
 * @author zero
 * */
public class LabBean {
    private String labName;
    private String labIntroduce;
    private String labAddress;
    private String labOpenTime;
    private String labEquip;
    private String labReserve;

    public LabBean() {
    }

    public LabBean(String labName, String labIntroduce, String labAddress, String labOpenTime, String labEquip, String labReserve) {
        this.labName = labName;
        this.labIntroduce = labIntroduce;
        this.labAddress = labAddress;
        this.labOpenTime = labOpenTime;
        this.labEquip = labEquip;
        this.labReserve = labReserve;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getLabIntroduce() {
        return labIntroduce;
    }

    public void setLabIntroduce(String labIntroduce) {
        this.labIntroduce = labIntroduce;
    }

    public String getLabAddress() {
        return labAddress;
    }

    public void setLabAddress(String labAddress) {
        this.labAddress = labAddress;
    }

    public String getLabOpenTime() {
        return labOpenTime;
    }

    public void setLabOpenTime(String labOpenTime) {
        this.labOpenTime = labOpenTime;
    }

    public String getLabEquip() {
        return labEquip;
    }

    public void setLabEquip(String labEquip) {
        this.labEquip = labEquip;
    }

    public String getLabReserve() {
        return labReserve;
    }

    public void setLabReserve(String labReserve) {
        this.labReserve = labReserve;
    }
}
