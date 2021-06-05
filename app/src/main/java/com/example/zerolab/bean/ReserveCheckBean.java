package com.example.zerolab.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author DELL
 */
public class ReserveCheckBean {

    @SerializedName("Results")
    private Results results;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public static class Results {
        private List<Results.ResultList> resultList;

        public List<Results.ResultList> getResultList() {
            return resultList;
        }

        public void setResultList(List<Results.ResultList> resultList) {
            this.resultList = resultList;
        }

        public static class ResultList {
            private String stuName;
            private String stuNum;
            private String labName;
            private String experimentName;
            private String stuSum;
            private String experimentTime;
            private String reserveStatus;
            private String checkTeacher;

            public String getStuName() {
                return stuName;
            }

            public void setStuName(String stuName) {
                this.stuName = stuName;
            }

            public String getStuNum() {
                return stuNum;
            }

            public void setStuNum(String stuNum) {
                this.stuNum = stuNum;
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

            public String getStuSum() {
                return stuSum;
            }

            public void setStuSum(String stuSum) {
                this.stuSum = stuSum;
            }

            public String getExperimentTime() {
                return experimentTime;
            }

            public void setExperimentTime(String experimentTime) {
                this.experimentTime = experimentTime;
            }

            public String getReserveStatus() {
                return reserveStatus;
            }

            public void setReserveStatus(String reserveStatus) {
                this.reserveStatus = reserveStatus;
            }

            public String getCheckTeacher() {
                return checkTeacher;
            }

            public void setCheckTeacher(String checkTeacher) {
                this.checkTeacher = checkTeacher;
            }
        }
    }
}
