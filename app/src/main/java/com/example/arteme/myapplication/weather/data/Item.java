package com.example.arteme.myapplication.weather.data;

public class Item {
    private int atmosphere;
    private int temperature;
    private int windDirection;
    private double windSpeed;

    private static int SCALE_DIVISION =  6;
    private static double MILES = 1609.34;//1 mile = 1609.34 meters
    private static int HOUR = 3600;//1 hour = 3600 seconds
    private static int FAHRENHEIT_COEFFICIENT_1 = 32;
    private static double FAHRENHEIT_COEFFICIENT_2 = 1.8;
    private static double MMHG = 0.75006375541921; //1 mbar = 0.75006375541921 mmHg

    public Item(double atm, int temp, int windD, double windS) {
        atmosphere = atmosphereTransormation(atm);
        temperature = temperatureTransformFromFahrenheit(temp);
        windDirection = windDirectionTransformation(windD);
        windSpeed = windSpeedTransformation(windS);
    }

    private int atmosphereTransormation(double atm) {
        return (int) (atm * MMHG);
    }

    private int temperatureTransformFromFahrenheit(int temp) {
        return (int) ((temp - FAHRENHEIT_COEFFICIENT_1)/ FAHRENHEIT_COEFFICIENT_2);
    }

    private int windDirectionTransformation(int wind) {
        return wind/SCALE_DIVISION;
    }

    private int windSpeedTransformation(double wind) {
        return (int) ((wind * MILES) / HOUR);
    }

    public int getAtmosphere() {
        return atmosphere;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}
