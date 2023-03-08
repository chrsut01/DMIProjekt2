package com.example.dmiprojekt;

import java.sql.Timestamp;

public class WeatherData {

        String stationID;
        String datoTid;
        String precip;
        String precipMinutes;
        String avgTemp;
        String maxTemp;
        String minTemp;
        String sunshine;
        String avgWind;
        String maxWind;
        String cloudHeight;
        String cloudCover;



    // LinkedList<WeatherData> weatherData = new LinkedList<>();
        //currently, both station and weatherData has a connection to each other through their constructors.
        // Is this good practice?
        public WeatherData(String stationID, String datoTid, String precip, String precipMinutes, String avgTemp, String maxTemp, String minTemp, String sunshine, String avgWind, String maxWind, String cloudHeight, String cloudCover) {
            this.stationID = stationID;
            this.datoTid = datoTid;
            this.precip = precip;
            this.precipMinutes = precipMinutes;
            this.avgTemp = avgTemp;
            this.maxTemp = maxTemp;
            this.minTemp = minTemp;
            this.sunshine = sunshine;
            this.avgWind = avgWind;
            this.maxWind = maxWind;
            this.cloudHeight = cloudHeight;
            this.cloudCover = cloudCover;
        }
    public String getStation() {
        return stationID;
    }

    public String getDatoTid() {
        return datoTid;
    }


    public String getPrecip() {
        return precip;
    }

    public String getPrecipMinutes() {
        return precipMinutes;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getAvgTemp() {
        return avgTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getSunshine() {
        return sunshine;
    }

    public String getAvgWind() {
        return avgWind;
    }

    public String getMaxWind() {
        return maxWind;
    }

    public String getCloudHeight() {
        return cloudHeight;
    }

    public String getCloudCover() {
        return cloudCover;
    }

}
