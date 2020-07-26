package client;

import exception.InvalidDataTypeException;
import exception.InvalidNumberOfArguments;
import exception.InvalidValueException;
import model.schema.Column;
import model.schema.Row;
import model.schema.Table;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Invoke {
    static Table table = new Table();
    public static LinkedList<Column> columnList = new LinkedList<>();
    public static void main(String[] args) throws InvalidDataTypeException, InvalidValueException, InvalidNumberOfArguments, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Map<String, String> tableSchema = new HashMap<>();
        tableSchema.put("NAME", "string");
        tableSchema.put("ID", "int");
        try {
            table.createTable(tableSchema);
        } catch (InvalidDataTypeException e) {
            e.printStackTrace();
        }
//        for(Map.Entry<String, Object> schemaEntry : table.getTableSchema().entrySet()) {
//            Scanner scanner = new Scanner(System.in);
//            String columnName = schemaEntry.getKey();
//            System.out.println("Enter the value for " + columnName);
//            Column tempColumn = new Column(columnName, 1234, schemaEntry.getValue());
//            columnList.add(tempColumn);
//        }
//        Row row = new Row();
//        row.addRow(columnList);
        table.insertIntoTable("1234", "Arjun Narain");
    }
}
