package utils;

import model.schema.Column;
import model.schema.Row;

public class PrinterUtils {
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
