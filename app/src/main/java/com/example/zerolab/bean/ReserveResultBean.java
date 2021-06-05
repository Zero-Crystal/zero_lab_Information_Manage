package com.example.zerolab.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zero
 */
public class ReserveResultBean {

    @SerializedName("Result")
    private Results result;

    public Results getResult() {
        return result;
    }

    public void setResult(Results result) {
        this.result = result;
    }

    public static class Results {
        private List<Results.Result> results;

        public List<Results.Result> getResults() {
            return results;
        }

        public void setResults(List<Results.Result> results) {
            this.results = results;
        }

        public static class Result {
            private String labName;
            private String experimentName;
            private String experimentTime;
            private String reserveStatus;
            private String checkTeacher;

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
