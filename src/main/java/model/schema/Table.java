package model.schema;

import constants.Constants;
import constants.Errors;
import exception.InvalidDataTypeException;
import exception.InvalidNumberOfArguments;
import exception.InvalidValueException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Table extends TableSchema{
    private int tableId;
    private LinkedList<Row> rowList;

    private static final AtomicInteger tableUID = new AtomicInteger(0);

    Table() {
        tableUID.getAndIncrement();
        rowList = new LinkedList<>();
    }

    public void createTable(Map<String, String> columnSchema) throws InvalidDataTypeException {
        createTableSchema(columnSchema);
    }

    public LinkedList<Row> getRowList() {
        return rowList;
    }

    //this function expects order to be maintained
    public void insertIntoTable(String... values) throws InvalidValueException, InvalidNumberOfArguments, InvalidDataTypeException {
        LinkedHashSet<String> columnNames = (LinkedHashSet<String>) tableSchemaMap.keySet();
        if (columnNames.size() == values.length) {
            int enforceInsertionOrder = 0;
            ArrayList<Object> schemaValues = (ArrayList<Object>) tableSchemaMap.values();
            LinkedList<Column> columns = new LinkedList<>();
            Row row = new Row();
            Iterator<String> columnIterator = columnNames.iterator();
            for (String value : values) {
                Column column = new Column(columnIterator.next(), value, schemaValues.get(enforceInsertionOrder));
                columns.add(column);
                enforceInsertionOrder++;
            }
            row.addRow(columns);
            this.rowList.add(row);
        }
        else
            throw new InvalidNumberOfArguments(Errors.INVALID_NUMBER_OF_ARGUMENTS);
    }
}
