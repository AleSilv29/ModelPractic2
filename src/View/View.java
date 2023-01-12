package View;

import Controller.Controller;
import Model.City;
import Model.Temperature;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class View {
    Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void menu() {
        System.out.println("0) Exit\n1) Add temperature to city!\n2) Show temperature in Celsius!\n3) Show temperature in Fahrenheit!\n4) Show city list!\n");
        Integer option;
        do {
            System.out.println();
            System.out.print("Choose an option: ");
            System.out.println();
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            if (option == 1) {
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                double scanTemp;
                int scanMass, scanMonth;
                System.out.println("City: ");
                String scanCity = myObj.nextLine();  // Read user input
                boolean cityExists=false;
                for (City c: controller.cities){
                    if (Objects.equals(c.getName(), scanCity))
                        cityExists=true;
                }
                if (!cityExists){
                    System.out.println("City is not in city list, please enter the city data:\n");
                    System.out.println("City name: ");
                    String scanCity2 = myObj.nextLine();
                    System.out.println("Country name: ");
                    String scanCountry= myObj.nextLine();
                    City newCityinserted=new City(scanCity2,scanCountry,new ArrayList<Temperature>());
                    controller.cities.add(newCityinserted);
                }

                System.out.print("Temperature: ");
                scanTemp = myObj.nextDouble();

                System.out.print("Mass: ");
                scanMass = myObj.nextInt();

                System.out.print("Month: ");
                scanMonth = myObj.nextInt();
                if (scanMonth<=1 || scanMonth>12){
                    System.out.println("Invalid Month");
                    break;
                }

                Temperature newTemp = new Temperature(scanTemp, scanMass, scanMonth);

            /*System.out.println("City: ");
            String scanCity= myObj.nextLine();  // Read user input*/
                for (City c : controller.cities) {
                    if (Objects.equals(c.getName(), scanCity)) {
                        controller.addTemperature(c, newTemp);
                    }
                }
            }

            if (option == 2) {
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                System.out.println("City: ");
                String scanCity = myObj.nextLine();  // Read user input
                for (City c : controller.cities) {
                    if (c.getName().equals(scanCity)) {
                        for (Temperature t : c.getTemperatures()) {
                            System.out.println("Month: "+t.getMonth() + " with Temperature " + t.getTemp());
                        }
                    }
                }
            }

            if (option==3){
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                System.out.println("City: ");
                String scanCity = myObj.nextLine();  // Read user input
                for (City c : controller.cities) {
                    if (c.getName().equals(scanCity)) {
                        for (Temperature t : c.getTemperatures()) {
                            double FahrTemp=controller.FahrenheitTemp(t);
                            System.out.println("Month: "+t.getMonth() + " with Temperature "+FahrTemp);
                        }
                    }
                }
            }

            if (option==4){
                for(City c: controller.cities){
                    System.out.println("City: "+ c.getName());
                }
            }

        } while (option != 0);
    }
}
