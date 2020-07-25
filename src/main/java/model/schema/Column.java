package model.schema;

import exception.InvalidValueException;

public class Column {
    private String columnName;
    private Object columnValue;

    public Column(String columnName, Object columnValue) throws InvalidValueException {
        if (columnValue.toString().equals("") || columnValue.equals(-1))
            throw new InvalidValueException("Invalid Value for model.schema.Column");
        else {
            this.setColumnName(columnName);
            this.setColumnValue(columnValue);
        }
    }

    private void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    private void setColumnValue(Object columnValue) {
        this.columnValue = columnValue;
    }

    public String getColumnName() {
        return columnName;
    }

    public Object getColumnValue() {
        return columnValue;
    }
}
