package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    protected boolean required = false;

    protected final void addCheck(String name, Predicate validate) {
        checks.put(name, validate);
    }

    public final boolean isValid(Object value) {
        if (!required) {
            Predicate validate = checks.get("required");
            if (!validate.test(value)) {
                return true;
            }
        }

        for (Predicate validate : checks.values()) {
            if (!validate.test(value)) {
                return false;
            }
        }

        return true;
    }
}
