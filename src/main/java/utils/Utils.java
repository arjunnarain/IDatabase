package utils;

import model.schema.Column;
import model.schema.Row;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, Object> getMap(String key, Object value) {
        Map<String, Object> localMap = new HashMap<String, Object>();
        localMap.putIfAbsent(key, value);
        return localMap;
    }

    public static String getColumnString(Column column) {
        return column.getColumnName() + " | " + column.getColumnValue().toString();
    }

    public static String getRowString(Row row) {
        StringBuilder columnValues = new StringBuilder();
        columnValues.append(row.getRowID()).append("  :  ");
        for (Column column : row.getColumnList()) {
            columnValues.append(getColumnString(column)).append("\n");
        }
        return columnValues.toString();
    }
}
