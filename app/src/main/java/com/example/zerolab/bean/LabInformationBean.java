package com.example.zerolab.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author DELL
 */
public class LabInformationBean {

    @SerializedName("LabInformation")
    private LabInformation labInformation;

    public LabInformation getLabInformation() {
        return labInformation;
    }

    public void setLabInformation(LabInformation labInformation) {
        this.labInformation = labInformation;
    }

    public static class LabInformation {
        @SerializedName("Labs")
        private List<LabInformation.Labs> labs;

        public List<LabInformation.Labs> getLabs() {
            return labs;
        }

        public void setLabs(List<LabInformation.Labs> labs) {
            this.labs = labs;
        }

        public static class Labs {
            private String labName;
            private String labIntroduce;
            private String labAddress;
            private String labOpenTime;
            private String labEquip;
            private String labReserve;

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
    }
}
