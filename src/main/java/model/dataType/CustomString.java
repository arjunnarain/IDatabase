package model.dataType;

import constants.Constants;

public class CustomString {
    private String rawString;
    private String parsedString;
    private boolean isTruncate;

    private void setRawString(String rawString) {
        this.rawString = rawString;
    }

    public CustomString() {
        parsedString = "";
        isTruncate = false;
    }

    public String getParsedData(String rawString) {
        setRawString(rawString);
        validateValue();
        return parsedString;
    }

    private void validateValue() {
        if (rawString.length() <= Constants.STRING_MAX_LENGTH)
            this.parsedString = rawString;
        else {
            if (isTruncate)
                this.parsedString = rawString.substring(0, Math.min(rawString.length(), Constants.STRING_MAX_LENGTH));
        }
    }
}
