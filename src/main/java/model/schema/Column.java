package model.schema;

import constants.Errors;
import exception.InvalidDataTypeException;
import exception.InvalidValueException;

public class Column {
    private String columnName;
    private Object columnValue;

    public Column(String columnName, Object columnValue, Object columnType) throws InvalidValueException, InvalidDataTypeException {
        if(validateDataType(columnType)) {
            if (columnValue.toString().equals("") || columnValue.equals(-1))
                throw new InvalidValueException("Invalid Value for model.schema.Column");
            else {
                this.setColumnName(columnName);
                this.setColumnValue(columnValue);
            }
        }
        else
            throw new InvalidDataTypeException(Errors.INVALID_DATA_TYPE);
    }

    private boolean validateDataType(Object columnType) {
        return columnType.getClass().isInstance(Integer.class) || columnType.getClass().isInstance(String.class);
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
