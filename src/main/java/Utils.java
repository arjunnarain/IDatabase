import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, Object> getMap(String key, Object value) {
        Map<String, Object> localMap = new HashMap<String, Object>();
        localMap.putIfAbsent(key, value);
        return localMap;
    }
}
