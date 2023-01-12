package Model;

import java.util.List;

public class City {
    String name;
    String land;
    List<Temperature> temperatures;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public List<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public City(String name, String land, List<Temperature> temperatures) {
        this.name = name;
        this.land = land;
        this.temperatures = temperatures;
    }

    public void addTemperatureinCity(Temperature temperature, int month){
        boolean monthExists=false;
        for (Temperature t:temperatures){
            if (t.month==month){
                monthExists=true;
                t.setTemp(temperature.getTemp());
            }
        }
        if (!monthExists){
            temperatures.add(temperature);
        }
    }
}
