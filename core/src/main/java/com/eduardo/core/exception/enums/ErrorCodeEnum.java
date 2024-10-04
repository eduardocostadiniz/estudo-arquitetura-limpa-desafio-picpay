package com.eduardo.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Tax Number invalid", "ON-0001"),
    ON0002("Tax Number unavailable", "ON-0002"),
    ON0003("E-mail unavailable", "ON-0003"),

    TR0001("Shop Keeper has not transfer allowed", "TR-0001"),
    TR0002("Balance is not enough", "TR-0002"),

    TP0001("PIN is invalid", "TP-0001");

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
