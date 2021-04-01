package com.example.zerolab.bean;

import android.net.http.SslCertificate;

/**
 * @author zero
 */
public class ReserveResultBean {
    private String labName;
    private String experimentName;
    private String startTime;
    private String endTime;
    private String reserveResult;
    private String reserveTeacher;

    public ReserveResultBean() {
    }

    public ReserveResultBean(String labName, String experimentName, String startTime, String endTime, String reserveResult, String reserveTeacher) {
        this.labName = labName;
        this.experimentName = experimentName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserveResult = reserveResult;
        this.reserveTeacher = reserveTeacher;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReserveResult() {
        return reserveResult;
    }

    public void setReserveResult(String reserveResult) {
        this.reserveResult = reserveResult;
    }

    public String getReserveTeacher() {
        return reserveTeacher;
    }

    public void setReserveTeacher(String reserveTeacher) {
        this.reserveTeacher = reserveTeacher;
    }
}
