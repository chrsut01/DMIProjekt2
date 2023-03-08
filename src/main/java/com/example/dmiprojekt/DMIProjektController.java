package com.example.dmiprojekt;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.Axis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DMIProjektController {


    public static void splitter(){

        String splitThis = "Lukas Og Chris";

        String[] splittetString = splitThis.split(" ");

        System.out.println(splittetString[0]);
        System.out.println(splittetString[1]);
        System.out.println(splittetString[2]);
    }



        @FXML
        private ComboBox<String> startDateCB;

        @FXML
        private ComboBox<String> endDateCB;

        @FXML
        private ComboBox<String> endTimeCB;

        @FXML
        private ComboBox<String> startTimeCB;

        @FXML
        private Button showChartButton;

        @FXML
        private ComboBox<String> stationCB;

        @FXML
        private ComboBox<String> weatherDataCB;

        @FXML
        private AreaChart<Number, Number> areaChart;

        public void initialize() {

                Station station1 = new Station("06041","Skagen Fyr","’54.8978/9.1282","3.2","1 Jan 53");
                Station station2 = new Station("06068", "Isenvad","’56.0939/9.1811","\"60,35\"","10 okt 2022");
                Station station3 = new Station("06104","Billund Lufthavn","’57.7354/10.6316","75","11 May 1973");
                Station station4 = new Station("06116","Store Jyndevad","’54.8978/9.1282","\"15,3\"","5 sep 1984");
                Station station5 = new Station("06159","Røsnæs Fyr","55.7433/10.8694","14.16","1 Jan 59");
                Station station6 = new Station("06193","Hammer Odde Fyr","55.2979/14.7718","7.81","1 Jan 59");

                stationCB.getItems().add(station1.getStationName());
                stationCB.getItems().add(station2.getStationName());
                stationCB.getItems().add(station3.getStationName());
                stationCB.getItems().add(station4.getStationName());
                stationCB.getItems().add(station5.getStationName());
                stationCB.getItems().add(station6.getStationName());


                weatherDataCB.getItems().addAll("Precip","AvgTemp","MaxTemp","MinTemp","Sunshine","AvgWind",
                        "MaxWind","CloudHeight","CloudCover");

                startDateCB.getItems().addAll("2023-01-01","2023-01-02","2023-01-03","2023-01-04","2023-01-05",
                        "2023-01-06","2023-01-07","2023-01-08","2023-01-09","2023-01-10","2023-01-11","2023-01-12",
                        "2023-01-13","2023-01-14","2023-01-15","2023-01-16","2023-01-17","2023-01-18","2023-01-19",
                        "2023-01-20","2023-01-21","2023-01-22","2023-01-23","2023-01-24","2023-01-25","2023-01-26",
                        "2023-01-27","2023-01-28","2023-01-29","2023-01-30","2023-01-31");
                endDateCB.getItems().addAll("2023-01-01","2023-01-02","2023-01-03","2023-01-04","2023-01-05",
                        "2023-01-06","2023-01-07","2023-01-08","2023-01-09","2023-01-10","2023-01-11","2023-01-12",
                        "2023-01-13","2023-01-14","2023-01-15","2023-01-16","2023-01-17","2023-01-18","2023-01-19",
                        "2023-01-20","2023-01-21","2023-01-22","2023-01-23","2023-01-24","2023-01-25","2023-01-26",
                        "2023-01-27","2023-01-28","2023-01-29","2023-01-30","2023-01-31");

                startTimeCB.getItems().addAll("00:00:00","01:00:00","02:00:00","03:00:00","04:00:00","05:00:00",
                        "06:00:00","07:00:00","08:00:00","09:00:00","10:00:00","11:00:00","12:00:00","13:00:00",
                        "14:00:00","15:00:00","16:00:00","17:00:00","18:00:00","19:00:00","20:00:00","21:00:00",
                        "22:00:00","23:00:00");
                endTimeCB.getItems().addAll("00:00:00","01:00:00","02:00:00","03:00:00","04:00:00","05:00:00",
                        "06:00:00","07:00:00","08:00:00","09:00:00","10:00:00","11:00:00","12:00:00","13:00:00",
                        "14:00:00","15:00:00","16:00:00","17:00:00","18:00:00","19:00:00","20:00:00","21:00:00",
                        "22:00:00","23:00:00");

        }


    @FXML
    void getWeatherData(ActionEvent event) {

        //int numberRows = 0;
        String insertStation = stationCB.getSelectionModel().getSelectedItem();
        String insertStartDate = startDateCB.getSelectionModel().getSelectedItem();
        String insertStartTime = startTimeCB.getSelectionModel().getSelectedItem();
        String insertEndDate = endDateCB.getSelectionModel().getSelectedItem();
        String insertEndTime = endTimeCB.getSelectionModel().getSelectedItem();
        String insertDataType = weatherDataCB.getSelectionModel().getSelectedItem();


        //String insert = passwordTF.getText();

        insertStation = "'" + insertStation + "'";
        insertStartDate = "'" + insertStartDate + "'";
        insertStartTime = "'" + insertStartTime + "'";
        insertEndDate = "'" + insertEndDate + "'";
        insertEndTime = "'" + insertEndTime + "'";
        insertDataType = "'" + insertDataType + "'";


        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT WeatherID FROM WeatherData WHERE StationID = " + insertStation + " " +
                    "AND DatoTid(SELECT LEFT('', 1, 10)) >= " + insertStartDate +
                    "AND DatoTid(SELECT RIGHT('', 12, 8)) = " + insertStartTime +
                    "AND DatoTid(SELECT LEFT('', 1, 10) AS ExtractString) <= " + insertEndDate +
                    "AND DatoTid(SELECT RIGHT('', 12, 8) AS ExtractString) = " + insertEndTime;


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


        }
        // Exception handling: skriv fejlen ud og log den
        catch (SQLException sqlse) {
            System.out.println(sqlse);
        }

        //readOutLabel.setText(numberRows + " were accessed");
        stationCB.getItems().clear();
        weatherDataCB.getItems().clear();
        startDateCB.getItems().clear();
        startTimeCB.getItems().clear();
        endDateCB.getItems().clear();
        endTimeCB.getItems().clear();

    }


        @FXML
        void showChart(ActionEvent event) {

                        areaChart.getData().clear();
                        Axis<Number> xAxis = areaChart.getXAxis();
                        xAxis.setLabel("Age");

                        Axis<Number> yAxis = areaChart.getYAxis();
                        yAxis.setLabel("Folketallet");

                        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
                        series.setName("2020");

                        series.getData().add(new XYChart.Data<>(200, 1018));
                        series.getData().add(new XYChart.Data<>(300, 1103));

                        areaChart.getData().add(series);

                }

}