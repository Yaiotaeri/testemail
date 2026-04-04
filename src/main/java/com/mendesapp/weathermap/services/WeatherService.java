package com.mendesapp.weathermap.services;

import com.mendesapp.weathermap.dtos.WeatherDto;
import com.mendesapp.weathermap.dtos.WeatherResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class WeatherService {

    private final RestTemplate restTemplate;
    private final EmailService emailService;

    private final String API_KEY = "5a30c42ac4874294d00659cb4e731a43";

    private final Double lat = -21.3593877;
    private final Double lon = -46.1420689;

    public WeatherService(RestTemplate restTemplate, EmailService emailService) {
        this.restTemplate = restTemplate;
        this.emailService = emailService;
    }

    public WeatherDto getWeather() {

        String url = "https://api.openweathermap.org/data/2.5/weather?lat="
                + lat + "&lon=" + lon
                + "&appid=" + API_KEY
                + "&units=metric&lang=pt_br";

        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        return new WeatherDto(
                response.main.temp,
                response.main.humidity,
                response.wind.speed * 3.6,
                response.name
        );
    }

    public void enviarClimaPorEmail(WeatherDto clima) {

        String msg = "Cidade: " + clima.cidade +
                "\nTemperatura: " + clima.temperatura + "°C" +
                "\nUmidade: " + clima.umidade + "%" +
                "\nVento: " + clima.vento + " km/h";

        emailService.enviarEmail("testevscode5566@gmail.com", msg);
    }


    @Scheduled(fixedRate = 60000)
    public void teste rapido() {
        WeatherDto clima = getWeather();
        enviarClimaPorEmail(clima);

        System.out.println("Teste automático!");
    }
}