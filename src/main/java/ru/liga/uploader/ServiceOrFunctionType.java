package ru.liga.uploader;

public enum ServiceOrFunctionType {
    SERVICE,
    FUNCTION;

    public String value() {
        return name();
    }

    public static ServiceOrFunctionType fromValue(String v) {
        return valueOf(v);
    }
}
