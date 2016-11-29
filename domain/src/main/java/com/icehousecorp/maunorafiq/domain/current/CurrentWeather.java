package com.icehousecorp.maunorafiq.domain.current;

/**
 * Created by maunorafiq on 11/28/16.
 */

public class CurrentWeather {
    private final int cityId;

    public CurrentWeather(int cityId) {
        this.cityId = cityId;
    }

    private String cityName;
    private int utcTime;
    private int weatherId;
    private String weatherName;
    private String weatherDescription;
    private String weatherIcon;

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(int utcTime) {
        this.utcTime = utcTime;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*** Current Weather ***");
        stringBuilder.append("City id : " + this.getCityId() + "\n");
        stringBuilder.append("City name : " + this.getCityName() + "\n");
        stringBuilder.append("UTC Time : " + this.getUtcTime() + "\n");
        stringBuilder.append("Weather id : " + this.getWeatherId() + "\n");
        stringBuilder.append("Weather name : " + this.getWeatherName() + "\n");
        stringBuilder.append("Weather Description : " + this.getWeatherDescription() + "\n");
        stringBuilder.append("Weather Icon : " + this.getWeatherIcon() + "\n");

        return stringBuilder.toString();
    }
}
