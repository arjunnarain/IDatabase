package model.schema;

import model.schema.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Row {
    private static final AtomicInteger rowUID = new AtomicInteger(0);
    private int rowID;
    private LinkedList<Column> columnList;

    Row() {
        rowUID.incrementAndGet();
    }

    public void addRow(List<Column> columnArrayList) {
        this.columnList = (LinkedList<Column>) columnArrayList;
        this.rowID = rowUID.getAndIncrement();
    }

    public int getRowID() {
        return rowID;
    }

    public LinkedList<Column> getColumnList() {
        return columnList;
    }
}
