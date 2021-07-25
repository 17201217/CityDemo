package com.springrain.vo;

public class ProvinceVO {

    private String provinceId;
    private String provinceName;

    public ProvinceVO(String provinceId, String provinceName) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "ProvinceVO{" +
                "provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
