import java.util.Map;

public class Constraints {

    public Map<String, Object> getStringConstraint() {
        return Utils.getMap(Constants.STRING_LENGTH_CONSTRAINT_KEY, Constants.STRING_LENGTH_CONSTRAINT_VALUE);
    }
}
