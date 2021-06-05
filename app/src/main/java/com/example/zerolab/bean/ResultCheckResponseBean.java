package com.example.zerolab.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author DELL
 */
public class ResultCheckResponseBean {

    @SerializedName("Result")
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private String result;
        private String checkResult;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getCheckResult() {
            return checkResult;
        }

        public void setCheckResult(String checkResult) {
            this.checkResult = checkResult;
        }
    }
}
