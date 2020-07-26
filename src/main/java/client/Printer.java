package client;

import model.schema.Column;
import model.schema.Row;
import utils.Utils;

import static utils.PrinterUtils.getColumnString;
import static utils.PrinterUtils.getRowString;

public class Printer {

    public void printRowToConsole(Row row) {
        System.out.println(getRowString(row));
    }

    public void printColumnToConsole(Column column) {
        System.out.println(getColumnString(column));
    }
}
