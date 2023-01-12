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

    }
}