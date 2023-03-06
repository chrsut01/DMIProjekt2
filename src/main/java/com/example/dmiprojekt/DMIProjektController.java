package com.example.dmiprojekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class DMIProjektController {




        @FXML
        private ComboBox<String> startDateCB;

        @FXML
        private ComboBox<String> endDateCB;


        @FXML
        private ComboBox<String> hourEndCB;

        @FXML
        private ComboBox<String> hourStartCB;


        @FXML
        private Button showDataButton;

        @FXML
        private ComboBox<String> stationCB;

        @FXML
        private ComboBox<String> weatherDataCB;
        @FXML
        void showData(ActionEvent event) {

        }





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

                hourStartCB.getItems().addAll("00:00:00","01:00:00","02:00:00","03:00:00","04:00:00","05:00:00",
                        "06:00:00","07:00:00","08:00:00","09:00:00","10:00:00","11:00:00","12:00:00","13:00:00",
                        "14:00:00","15:00:00","16:00:00","17:00:00","18:00:00","19:00:00","20:00:00","21:00:00",
                        "22:00:00","23:00:00");
                hourEndCB.getItems().addAll("00:00:00","01:00:00","02:00:00","03:00:00","04:00:00","05:00:00",
                        "06:00:00","07:00:00","08:00:00","09:00:00","10:00:00","11:00:00","12:00:00","13:00:00",
                        "14:00:00","15:00:00","16:00:00","17:00:00","18:00:00","19:00:00","20:00:00","21:00:00",
                        "22:00:00","23:00:00");

        }



}