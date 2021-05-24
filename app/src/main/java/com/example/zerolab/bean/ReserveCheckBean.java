package com.example.zerolab.bean;

/**
 * @author DELL
 */
public class ReserveCheckBean {
    private String studentName;
    private String labName;
    private String experimentName;
    private String experimentSum;
    private String experimentStartTime;
    private String experimentEndTime;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public String getExperimentSum() {
        return experimentSum;
    }

    public void setExperimentSum(String experimentSum) {
        this.experimentSum = experimentSum;
    }

    public String getExperimentStartTime() {
        return experimentStartTime;
    }

    public void setExperimentStartTime(String experimentStartTime) {
        this.experimentStartTime = experimentStartTime;
    }

    public String getExperimentEndTime() {
        return experimentEndTime;
    }

    public void setExperimentEndTime(String experimentEndTime) {
        this.experimentEndTime = experimentEndTime;
    }
}
