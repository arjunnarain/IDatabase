package model.dataType;

import constants.Constants;

public class CustomInteger {
    private Integer rawInteger;
    private Integer parsedInteger;

    public CustomInteger() {
        parsedInteger = -1;
    }

    public Integer getParsedData(String unformattedString) {
        try {
            rawInteger = Integer.valueOf(unformattedString);
        }
        catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());
        }
        validateValue();
        return this.parsedInteger;
    }

    private void validateValue() {
        if(rawInteger >= Constants.INT_LOWERBOUND && rawInteger <= Constants.INT_UPPERBOUND)
            this.parsedInteger =  this.rawInteger;
    }

    private void setRawData(int rawInteger) {
        this.rawInteger = rawInteger;
    }
}
