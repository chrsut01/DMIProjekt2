package com.example.dmiprojekt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
public class WeatherDataDaoImpl implements WeatherDataDao {



    @Override
    public List<WeatherData> getWeatherData(Station station) {
        List<WeatherData> wd = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Movie, Category, CatMovie WHERE " +
                    "Category.categoryID = CatMovie.categoryID AND CatMovie.movieID = Movie.movieID AND " +
                    "Station.stationID = ?;");
            ps.setInt(1, station.getStationID());
            ResultSet rs = ps.executeQuery();
            WeatherData movie;
            while (rs.next()) {
                int movieID = rs.getInt(1);
                String title = rs.getString(2);
                int myRating = rs.getInt(3);
                String imdbRating = rs.getString(4);
                String filelink = rs.getString(5);
                String lastview = rs.getString(6);

                movie = new Movie(movieID, title, myRating, imdbRating, filelink, lastview);
                wd.add(movie);
            }
        } catch (SQLException e) {
            System.err.println("cannot access records (MDaoImpl) " + e.getMessage());
        }
        return wd;
    }


 */