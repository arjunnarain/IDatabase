import java.util.Map;

public class Constraints {

    public Map<String, Object> getStringLengthConstraint() {
        return Utils.getMap(Constants.STRING_LENGTH_CONSTRAINT_KEY, Constants.STRING_LENGTH_CONSTRAINT_VALUE);
    }

    public Map<String, Object> getIntegerValueConstraint() {
        return Utils.getMap(Constants.STRING_LENGTH_CONSTRAINT_KEY, Constants.STRING_LENGTH_CONSTRAINT_VALUE);
    }
}
