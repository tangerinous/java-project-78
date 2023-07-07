package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        addCheck(
                "required",
                value -> value instanceof Map
        );
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(
                "sizeof",
                value -> ((Map) value).size() == size
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(
                "shape",
                value -> {
                    return schemas.entrySet().stream().allMatch(e -> {
                        Object v = ((Map) value).get(e.getKey());
                        return e.getValue().isValid(v);
                    });
                }
        );
        return this;
    }
}
