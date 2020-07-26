package model.schema;

import constants.Errors;
import enums.CustomType;
import exception.InvalidDataTypeException;
import exception.InvalidValueException;
import model.dataType.CustomInteger;
import model.dataType.CustomString;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;

public class Column {
    private String columnName;
    private Object columnValue;

    public Column(String columnName, Object columnValue, Object columnType) throws InvalidValueException, InvalidDataTypeException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (validateDataType(columnType)) {
            this.setColumnName(columnName);
            this.setColumnValue(columnValue);
        } else
            throw new InvalidDataTypeException(Errors.INVALID_DATA_TYPE);
    }

    private boolean validateDataType(Object columnType) {
        return columnType instanceof CustomInteger || columnType instanceof CustomString;
    }

    private void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    private void setColumnValue(Object columnValue) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NullPointerException, InstantiationException, InvalidValueException {
        columnValue = getFormattedValue(columnValue);
        if (columnValue.toString().equals("") || columnValue.equals(-1))
            throw new InvalidValueException("Invalid Value for model.schema.Column");
        else if (columnValue != null)
            this.columnValue = columnValue;
        else
            throw new NullPointerException();
    }

    public String getColumnName() {
        return columnName;
    }

    public Object getColumnValue() {
        return columnValue;
    }

    private Object getFormattedValue(Object columnValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        CustomType[] values = CustomType.values();
        Object parsedValue = null;
        CustomInteger customInteger = new CustomInteger();
        if (StringUtils.isNumeric((CharSequence) columnValue))
            columnValue = Integer.valueOf(columnValue.toString());
        for (CustomType dataTypeEnum : values) {
            if (columnValue.getClass().getCanonicalName().equals(dataTypeEnum.getRawClassName()))
                //parsedValue = customInteger.getParsedData(columnValue.toString());
                parsedValue = dataTypeEnum.getDataType().getClass().getMethod("getParsedData", String.class).invoke(dataTypeEnum.getDataType().getClass().getDeclaredConstructor().newInstance(), columnValue.toString());

        }
        return parsedValue;
    }
}
