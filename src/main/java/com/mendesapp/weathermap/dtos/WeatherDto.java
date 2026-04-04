package com.mendesapp.weathermap.dtos;

public class WeatherDto {

    public double temperatura;
    public int umidade;
    public double vento;
    public String cidade;

    public WeatherDto(double temperatura, int umidade,double vento, String cidade){
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.vento = vento;
        this.cidade = cidade;
    }
}

