import java.util.concurrent.atomic.AtomicInteger;

public class Column {

    public static AtomicInteger columnUID;

    private String columnName;
    private Object columnValue;
    private int columnId;

    static {
        columnUID.set(0);
    }

    Column() {
        columnUID.getAndIncrement();
    }

    public Column addColumn(String columnName, Object columnValue, Column columnObject) throws InvalidValueException{
        if (columnValue.toString().equals("") || columnValue.equals(-1))
            throw new InvalidValueException("Invalid Value for Column");
        else {
            columnObject.setColumnName(columnName);
            columnObject.setColumnValue(columnValue);
            columnObject.setColumnId(columnUID.get());
            return columnObject;
        }
    }

    private void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    private void setColumnValue(Object columnValue) {
        this.columnValue = columnValue;
    }

    private void setColumnId(int columnId) {
        this.columnId = columnId;
    }
}
