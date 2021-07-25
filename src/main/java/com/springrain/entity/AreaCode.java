package com.springrain.entity;

import lombok.Data;

public class AreaCode {
    private String id;
    private String provinceName;
    private String provinceId;
    private String cityId;
    private String cityName;
    private String areaCode;
    private String areaCode_Other;
    private String operateTime;
    private String remark;

    public String getId() {
        return id;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }



    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaCode_Other() {
        return areaCode_Other;
    }

    public void setAreaCode_Other(String areaCode_Other) {
        this.areaCode_Other = areaCode_Other;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AreaCode{" +
                "id='" + id + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", areaCode_Other='" + areaCode_Other + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
