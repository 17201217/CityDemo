package com.springrain.vo;

public class CityVO {
    /*
    城市名称
    数量
     */
    private String cityName;
    private int amount;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CityVO{" +
                "cityName='" + cityName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
