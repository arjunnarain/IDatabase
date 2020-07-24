public class CustomInteger {
    private Integer rawInteger;
    private Integer parsedInteger;

    CustomInteger(Integer rawInteger) {
        this.rawInteger = rawInteger;
    }

    public Integer getParsedInteger() {
        return validateValue();
    }

    private Integer validateValue() {
        if(rawInteger >= Constants.INT_LOWERBOUND && rawInteger <= Constants.INT_UPPERBOUND)
            this.parsedInteger =  this.rawInteger;
        else
            parsedInteger = -1;
        return parsedInteger;
    }
}
