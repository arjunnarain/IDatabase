package model.schema;

import enums.CustomType;
import exception.InvalidDataTypeException;

import java.util.LinkedHashMap;
import java.util.Map;

public class TableSchema {
    protected Map<String, Object> tableSchemaMap = new LinkedHashMap<>();

    private void addTableColumn(String columnName, String columnType) throws InvalidDataTypeException {
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

    public void createTableSchema(Map<String, String> userColumnMap) throws InvalidDataTypeException {
        for (Map.Entry<String, String> mapEntry : userColumnMap.entrySet())
            addTableColumn(mapEntry.getKey(), mapEntry.getValue());
    }
}
