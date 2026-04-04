package com.mendesapp.weathermap.dtos;


public class WeatherResponse {

    public Main main;
    public Wind wind;
    public String name;
    
    public static class Main{
        public double temp;
        public int humidity;

    }


    public static class Wind{
        public double speed;
    }

}
