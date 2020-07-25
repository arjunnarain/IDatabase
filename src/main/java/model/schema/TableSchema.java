package model.schema;

import enums.CustomType;
import exception.InvalidDataTypeException;

import java.util.LinkedHashMap;
import java.util.Map;

public class TableSchema {
    private Map<String, Object> tableSchemaMap;

    TableSchema() {
        tableSchemaMap = new LinkedHashMap<>();
    }

    public void addTableColumn(String columnName, String columnType) throws InvalidDataTypeException {
        if (columnType.equalsIgnoreCase(CustomType.CUSTOM_INTEGER.getTypeName()))
            this.tableSchemaMap.put(columnName, CustomType.CUSTOM_INTEGER.getDataType());
        else if (columnType.equalsIgnoreCase(CustomType.CUSTOM_STRING.getTypeName()))
            this.tableSchemaMap.put(columnName, CustomType.CUSTOM_STRING.getDataType());
        else
            throw new InvalidDataTypeException("Invalid Data Type for schema");
    }

    public Map<String, Object> getTableSchema() {
        return tableSchemaMap;
    }
}
