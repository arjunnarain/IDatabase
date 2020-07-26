package model.schema;

import constants.Errors;
import exception.InvalidDataTypeException;
import exception.InvalidNumberOfArguments;
import exception.InvalidValueException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class
Table extends TableSchema{
    private final int tableId;
    private final LinkedList<Row> rowList;

    public int getTableId() {
        return tableId;
    }

    private static final AtomicInteger tableUID = new AtomicInteger(0);

    public Table() {
        this.tableId = tableUID.incrementAndGet();
        rowList = new LinkedList<>();
    }

    public void createTable(Map<String, String> columnSchema) throws InvalidDataTypeException {
        createTableSchema(columnSchema);
    }

    public Map<String, Object> getTableSchema() {
        return super.getTableSchema();
    }

    public LinkedList<Row> getRowList() {
        return rowList;
    }

    //this function expects order to be maintained
    public void insertIntoTable(String... values) throws InvalidValueException, InvalidNumberOfArguments, InvalidDataTypeException {
        Set<String> columnNames = this.tableSchemaMap.keySet();
        if (columnNames.size() == values.length) {
            int enforceInsertionOrder = 0;
            ArrayList<Object> schemaValues = new ArrayList<>(tableSchemaMap.values());
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
