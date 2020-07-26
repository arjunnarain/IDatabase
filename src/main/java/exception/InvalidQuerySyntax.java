package exception;

public class InvalidQuerySyntax extends Exception{
    public InvalidQuerySyntax(String exceptionMessage) {
        super(exceptionMessage);
    }
}
