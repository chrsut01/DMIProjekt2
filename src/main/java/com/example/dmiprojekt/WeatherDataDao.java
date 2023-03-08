package com.example.dmiprojekt;

import java.util.List;

public interface WeatherDataDao {

    List<WeatherData> getWeatherData(WeatherData weatherData);

    List<WeatherData> getWeatherData(Station station);
}
