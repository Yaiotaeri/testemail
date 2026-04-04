package com.mendesapp.weathermap.controllers;

import com.mendesapp.weathermap.dtos.WeatherDto;
import com.mendesapp.weathermap.services.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public WeatherDto getWeather() {
        return weatherService.getWeather();
    }

    @GetMapping("/email")
    public String enviarEmail() {
        WeatherDto clima = weatherService.getWeather();
        weatherService.enviarClimaPorEmail(clima);
        return "Email enviado!";
    }
}