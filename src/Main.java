import Controller.Controller;
import Model.City;
import Model.Temperature;
import View.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        String land,area;
        List<String> filteredLands=new ArrayList<>();
        File csvFile = new File("outputFile.csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        try {
            reader = new BufferedReader(new FileReader("laender.txt"));
            String line = reader.readLine();


            while (line != null) {
                //System.out.println(line); //print line
                // read next line
                String[] splitStr = line.split("\\s+");
                land=splitStr[0];
                area=splitStr[2];
                int number = Integer.parseInt(area);
                if (land.charAt(0)=='M' && number>10000){
                    //System.out.println(land);
                    //System.out.println(number);
                    StringBuilder lineCsv = new StringBuilder();
                    lineCsv.append(land.toString());
                    lineCsv.append(';');
                    lineCsv.append("\n");
                    fileWriter.write(lineCsv.toString());
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.close();

        Temperature temperature1=new Temperature(5, "Celsius", 1);
        Temperature temperature2=new Temperature(2, "Celsius", 2);
        Temperature temperature3=new Temperature(8, "Celsius", 3);
        Temperature temperature4=new Temperature(10, "Celsius", 4);
        Temperature temperature5=new Temperature(15, "Celsius", 5);
        Temperature temperature6=new Temperature(20, "Celsius", 6);
        Temperature temperature7=new Temperature(28, "Celsius", 7);
        Temperature temperature8=new Temperature(30, "Celsius", 8);
        Temperature temperature9=new Temperature(25, "Celsius", 9);
        Temperature temperature10=new Temperature(15, "Celsius", 10);
        Temperature temperature11=new Temperature(8, "Celsius", 11);
        Temperature temperature12=new Temperature(2, "Celsius", 12);
        List<Temperature> temperatureList=new ArrayList<>();
        temperatureList.add(temperature1);
        temperatureList.add(temperature2);
        temperatureList.add(temperature3);
        temperatureList.add(temperature4);
        temperatureList.add(temperature5);

        List<Temperature> temperatureList2=new ArrayList<>();
        temperatureList2.add(temperature6);
        temperatureList2.add(temperature7);
        temperatureList2.add(temperature8);
        temperatureList2.add(temperature9);
        temperatureList2.add(temperature10);

        City city1=new City("Cluj", "Romania", temperatureList);
        City city2=new City("Satu Mare", "Romania", temperatureList2);
        List<City> cityList=new ArrayList<>();
        cityList.add(city1);
        cityList.add(city2);
        Controller c=new Controller(cityList);
        View v=new View(c);
        v.menu();
    }
}