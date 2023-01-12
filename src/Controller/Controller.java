package Controller;

import Model.City;
import Model.Temperature;

import java.util.List;

public class Controller {

    public List<City> cities;
    public Controller(List<City> cities) {
        this.cities = cities;
    }

    public void addTemperature(City city, Temperature temperature){
        int month;
        boolean foundCity=false;
        for (City c : cities){
            if (c==city){
                foundCity=true;
                month= temperature.getMonth();
                c.addTemperatureinCity(temperature,month);
            }
        }
        if (!foundCity)
            cities.add(city);
    }

    public double FahrenheitTemp(Temperature temperature){
        return temperature.getTemp()*(33.8);
    }
}

