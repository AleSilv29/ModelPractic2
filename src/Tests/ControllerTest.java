package Tests;

import Controller.Controller;
import Model.City;
import Model.Temperature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void addTemperature() {
        Temperature temperature1=new Temperature(5, 200, 2);
        List<Temperature> temperatureList=new ArrayList<Temperature>();
        temperatureList.add(temperature1);
        City city1=new City("Cluj", "Romania",temperatureList);
        List<City> cityList=new ArrayList<>();
        cityList.add(city1);
        Controller controller = new Controller(cityList);

        Temperature temperature2=new Temperature(10, 200, 2);
        Temperature temperature3=new Temperature(20, 200, 6);
        controller.addTemperature(city1,temperature1);
        controller.addTemperature(city1,temperature2);
        controller.addTemperature(city1,temperature3);
        for (City c: controller.cities){
            if(Objects.equals(c.getName(), "Cluj")){
                for (Temperature t:c.getTemperatures()){
                    if (t.getMonth()==2)
                        assertEquals(10,t.getTemp());
                    if (t.getMonth()==6)
                        assertEquals(20,t.getTemp());
                }
            }

        }
    }

    @org.junit.jupiter.api.Test
    void fahrenheitTemp() {
        Temperature temperature1=new Temperature(5, 200, 2);
        List<Temperature> temperatureList=new ArrayList<Temperature>();
        temperatureList.add(temperature1);
        City city1=new City("Cluj", "Romania",temperatureList);
        List<City> cityList=new ArrayList<>();
        cityList.add(city1);
        Controller controller = new Controller(cityList);
        double FahrTemp=controller.FahrenheitTemp(temperature1);
        assertEquals(169.0, FahrTemp);
    }
}