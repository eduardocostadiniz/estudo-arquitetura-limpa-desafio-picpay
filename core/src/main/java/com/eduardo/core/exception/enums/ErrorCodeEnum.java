package com.eduardo.core.exception.enums;

public enum ErrorCodeEnum {

    AU0001("Error when authenticating the user", "AU-0001"),

    ON0001("Tax Number invalid", "ON-0001"),
    ON0002("Tax Number unavailable", "ON-0002"),
    ON0003("E-mail unavailable", "ON-0003"),
    ON0004("Error when creating the user", "ON-0004"),

    TR0001("Shop Keeper has not transfer allowed", "TR-0001"),
    TR0002("Balance is not enough", "TR-0002"),
    TR0003("Error when doing the transfer", "TR-0003"),
    TR0004("Transfer not authorized", "TR-0004"),

    TP0001("PIN is invalid", "TP-0001"),
    TP0002("User PIN is blocked", "TP-0002"),
    TP0003("Transaction PIN incorrect. %d left", "TP-0003"),

    NO0001("Error when notifying transfer", "NO-0001"),

    WA0001("Wallet not found", "WA-0001");

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
