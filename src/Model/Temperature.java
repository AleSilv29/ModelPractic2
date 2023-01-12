package Model;

public class Temperature {
    double temp;
    String unit;
    int month;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Temperature(double temp, String unit, int month) {
        this.temp = temp;
        this.unit = unit;
        this.month = month;
    }
}
