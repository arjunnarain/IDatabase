public class CustomString {
    private String rawString;
    private String parsedString;
    private boolean isTruncate;

    CustomString(String rawString, boolean isTruncate) {
        this.rawString = rawString;
        this.isTruncate = isTruncate;
    }

    public String getParsedString() {
        return validateString();
    }

    private String validateString() {
        if (rawString.length() <= Constants.STRING_MAX_LENGTH)
            this.parsedString = rawString;
        else {
            if (isTruncate)
                this.parsedString = rawString.substring(0, Math.min(rawString.length(), Constants.STRING_MAX_LENGTH));
            else
                this.parsedString = "";
        }
        return this.parsedString;
    }
}
