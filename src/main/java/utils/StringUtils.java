package utils;

import exception.InvalidQuerySyntax;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    public static Map<String, String> splitCreateQuery(String query) {
        Map<String, String> columnSchema = new HashMap<>();
        query = query.split("[(]")[1].split("[)]")[0];
        String[] splitQuery = query.split(",");
        for(String s : splitQuery) {
            String[] schemaSplit = s.replace("\"", "").split(" ");
            columnSchema.put(schemaSplit[0], schemaSplit[1]);
        }
        return columnSchema;
    }

//    public static void main(String[] args) throws InvalidQuerySyntax {
//        splitCreateQuery("CREATE TABLE (ID int, NAME String)");
//    }
}
