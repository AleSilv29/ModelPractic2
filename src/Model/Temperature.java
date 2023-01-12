package Model;

import java.util.Scanner;

public class Temperature {
    double temp;
    int mass;
    int month;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Temperature(double temp, int mass, int month) {
        this.temp = temp;
        this.mass = mass;
        this.month = month;
    }
}
