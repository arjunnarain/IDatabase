package client;

import exception.InvalidDataTypeException;
import model.schema.Table;

import java.util.HashMap;
import java.util.Map;

public class Invoke {
    static Table table = new Table();
    static Table table1 = new Table();
    public static void main(String[] args) {
        Map<String, String> tableSchema = new HashMap<>();
        tableSchema.put("NAME", "string");
        tableSchema.put("ID", "int");
        try {
            table.createTable(tableSchema);
            table.getTableSchema();
        } catch (InvalidDataTypeException e) {
            e.printStackTrace();
        }
        Map<String, String> tableSchema1 = new HashMap<>();
        tableSchema.put("NAME", "string");
        tableSchema.put("ID", "int");
        try {
            table1.createTable(tableSchema1);
            table1.getTableSchema();
        } catch (InvalidDataTypeException e) {
            e.printStackTrace();
        }
    }
}
