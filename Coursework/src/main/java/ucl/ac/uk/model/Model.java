package ucl.ac.uk.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {
    private DataFrame dataFrame;

    public Model(String filePath) {
//        this.dataFrame = new DataFrame();
        this.dataFrame = DataLoader.loadData(filePath);
    }

    public DataFrame getDataFrame(String filePath){
//        dataFrame = DataLoader.loadData(filePath);
        return dataFrame;
    }

    public ArrayList<Map<String, String>> getAllPatients() {
        ArrayList<Map<String, String>> patientList = new ArrayList<>();
        // Assuming the DataFrame provides a way to iterate over rows
        int rowCount = dataFrame.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Map<String, String> patientData = new HashMap<>();
            for (String columnName : dataFrame.getColumnNames()) {
                patientData.put(columnName, dataFrame.getValue(columnName, i));
            }
            patientList.add(patientData);
        }
        return patientList;
    }
}
