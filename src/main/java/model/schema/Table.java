package model.schema;

import model.schema.Row;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Table {
    private int tableId;
    private ArrayList<Row> rowList;

    private static final AtomicInteger tableUID = new AtomicInteger(0);

    Table() {
        tableUID.getAndIncrement();
    }

    public void createTable() {

    }
}
