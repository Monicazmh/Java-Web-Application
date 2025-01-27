package ucl.ac.uk.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {
    public static DataFrame loadData(String filePath) {
        DataFrame dataFrame = new DataFrame();
        ArrayList<String> columnNames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine();
            if (line != null) {
                for (String columnName : line.split(",")) {
                    String cleanedName = columnName.trim();
                    dataFrame.addColumn(cleanedName);
                    columnNames.add(cleanedName);
                }
            }
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    dataFrame.addValue(columnNames.get(i), values[i].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return dataFrame;
    }

//    // Test DataLoader
//    public static void main(String[] args) {
//        DataFrame dataFrame = loadData("patients100.csv");
//        System.out.println(dataFrame);
//    }
}
