package com.example.zerolab.bean;

/**
 * @author DELL
 */
public class ResultBean {

    private Params params;

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public static class Params {
        private String experimentTime;
        private String labName;
        private String checkResult;
        private String experimentName;
        private String checkTeacher;

        public String getExperimentTime() {
            return experimentTime;
        }

        public void setExperimentTime(String experimentTime) {
            this.experimentTime = experimentTime;
        }

        public String getLabName() {
            return labName;
        }

        public void setLabName(String labName) {
            this.labName = labName;
        }

        public String getCheckResult() {
            return checkResult;
        }

        public void setCheckResult(String checkResult) {
            this.checkResult = checkResult;
        }

        public String getExperimentName() {
            return experimentName;
        }

        public void setExperimentName(String experimentName) {
            this.experimentName = experimentName;
        }

        public String getCheckTeacher() {
            return checkTeacher;
        }

        public void setCheckTeacher(String checkTeacher) {
            this.checkTeacher = checkTeacher;
        }
    }
}
