package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        addCheck(
                "required",
                value -> value instanceof String && !((String) value).isEmpty()
        );
    }

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck(
                "contains",
                value -> ((String) value).contains(substring)
        );
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck(
                "minLength",
                value -> ((String) value).length() >= length
        );
        return this;
    }
}
