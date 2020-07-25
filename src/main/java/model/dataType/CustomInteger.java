package model.dataType;

import constants.Constants;

public class CustomInteger {
    private Integer rawInteger;
    private Integer parsedInteger;

    public CustomInteger() {
        parsedInteger = -1;
    }

    public Integer getParsedData(int rawInteger) {
        setRawData(rawInteger);
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
