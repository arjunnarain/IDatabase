//package client;
//
//import constants.Constants;
//import exception.InvalidQuerySyntax;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//
//import static constants.Errors.INVALID_QUERY_SYNTAX;
//
//public class Parser extends ParameterizedQuery {
//    Parser(String sql, Parameter[] params) {
//        super(sql, params);
//    }
//
//    static ParameterizedQuery parse(String query) {
//        List<Parameter> parms = new ArrayList<>();
//        Matcher matcher = Constants.CONST_PATTERN.matcher(query);
//        int start = 0;
//        StringBuilder buf = new StringBuilder();
//        while (matcher.find()) {
//            int pos = matcher.start();
//            buf.append(query, start, pos)
//                    .append(matcher.group(1))
//                    .append("?");
//            parms.add(new Parameter(buf.length() - 1, matcher.group(2)));
//            start = matcher.end();
//        }
//        buf.append(query, start, query.length());
//        return new ParameterizedQuery(
//                buf.toString(), parms.toArray(new Parameter[parms.size()]));
//    }
//
//    public static void main(String[] args) {
//        ParameterizedQuery parameterizedQuery = parse("CREATE TABLE Persons (\n" +
//                "    PersonID int,\n" +
//                "    LastName varchar(255),\n" +
//                "    FirstName varchar(255),\n" +
//                "    Address varchar(255),\n" +
//                "    City varchar(255)\n" +
//                ");");
//        System.out.println(parameterizedQuery.sql);
//    }
//}
