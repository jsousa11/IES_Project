package com.ProjetoIES.easyfarming.beans;

public class Message {
    Integer temperature;
    Integer humidity;
    Integer precipitation;

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Integer precipitation) {
        this.precipitation = precipitation;
    }
}
