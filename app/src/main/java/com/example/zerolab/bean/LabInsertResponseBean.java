package com.example.zerolab.bean;

public class LabInsertResponseBean {

    private LabParams labParams;

    public LabParams getLabParams() {
        return labParams;
    }

    public void setLabParams(LabParams labParams) {
        this.labParams = labParams;
    }

    public static class LabParams {
        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
