package model.schema;

import model.schema.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Row {
    private static final AtomicInteger rowUID = new AtomicInteger(0);
    private int rowID;
    private ArrayList<Column> columnList;

    Row() {
        rowUID.getAndIncrement();
    }

    public void addRow(Column... columnObjects) {
        this.columnList.addAll(Arrays.asList(columnObjects));
        this.rowID = rowUID.getAndIncrement();
    }

    public int getRowID() {
        return rowID;
    }

    public ArrayList<Column> getColumnList() {
        return columnList;
    }
}
