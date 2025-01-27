package ucl.ac.uk.model;

import java.util.ArrayList;

public class Column {
//    private String getName() {
//        Input input = new Input();
//        System.out.println("Input a patient name: ");
//        return input.nextLine();
//    }
    private String name;
    private ArrayList<String> rows;

    public Column(String name){
        this.name = name;
        this.rows = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return rows.size();
    }

    public String getRowValue(int index){
        if (index >= 0 && index < rows.size()) {
            return rows.get(index);
        } else {
            return null;
        }
    }

    public void setRowValue(int index, String value) {
        if (index >= 0 && index < rows.size()){
            rows.set(index, value);
        }
    }

    public void addRowValue(String newRowValue){
        rows.add(newRowValue);
    }
}
