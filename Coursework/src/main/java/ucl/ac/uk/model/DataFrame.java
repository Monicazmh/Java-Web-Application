package ucl.ac.uk.model;

import java.util.ArrayList;

public class DataFrame {
    private ArrayList<Column> columns;

    public DataFrame() {
        this.columns = new ArrayList<>();
    }

    public void addColumn(String columnName) {
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                return;
            }
        }
        columns.add(new Column(columnName));
    }

    public ArrayList<String> getColumnNames() {
        ArrayList<String> columnNames = new ArrayList<>();
        for (Column column : columns) {
            columnNames.add(column.getName());
        }
        return columnNames;
    }

    public int getRowCount() {
        if (columns.isEmpty()) {
            throw new IndexOutOfBoundsException("No column exists.");
        } else {
            Column column = columns.get(0);
            return column.getSize();
        }
    }

    public String getValue(String columnName, int row) {
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                return column.getRowValue(row);
            }
        }
        throw new IllegalArgumentException("Column does not exist: " + columnName);
    }

    public void putValue(String columnName, int row, String value) {
        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                column.setRowValue(row, value);
                return;
            }
        }
        throw new IllegalArgumentException("Column does not exist: " + columnName);
    }

    public void addValue(String columnName, String value) {

        for (Column column : columns) {
            if (column.getName().equals(columnName)) {
                //System.out.println("Attempting to add value to column: " + columnName);
                column.addRowValue(value);
                return;
            }
        }
        throw new IllegalArgumentException("Column does not exist: " + columnName);
    }

}



//public class MainComponent {
//    public static void main(String[] args) {
//        // Since Column is now a static inner class, it can be instantiated directly.
//        // Also, the constructor now expects a name for the column, so "SampleName" is passed as an example.
//        Column Column1 = new Column("Name1");
//        Column Column2 = new Column("Name2");
//
//        // Example of using the newColumn object.
//        Column1.addRowValue("Row1");
//        Column1.addRowValue("Row2");
//
//        Column2.addRowValue("row1");
//        Column2.addRowValue("row2");
//
//        ArrayList<Column> columns = new ArrayList<>();
//        columns.add(Column1);
//        columns.add(Column2);
//
//        DataFrame frame = new DataFrame(columns);
//
//        ArrayList<String> columnNames = frame.getColumnNames();
//
//        for (int i = 0; i < columnNames.size(); i++) {
//            System.out.println(columnNames.get(i));
//        }
//    }
//}
