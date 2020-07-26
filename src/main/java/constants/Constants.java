package constants;

import java.util.regex.Pattern;

public class Constants {
    public static final int STRING_MAX_LENGTH = 20;
    public static final int INT_UPPERBOUND = 1024;
    public static final int INT_LOWERBOUND = -1024;
    public static final String CUSTOM_INTEGER = "int";
    public static final String CUSTOM_STRING = "String";
    public static final Pattern CONST_PATTERN
            = Pattern.compile("([^0-9a-zA-Z])((?:[0-9]+(?:\\.[0-9]*)?|[0-9]*\\.[0-9]+)"
            + "(?:[Ee][+-][0-9]+])?"
            + "|(?:\\'[^']*\\')+)", Pattern.CASE_INSENSITIVE);
}
