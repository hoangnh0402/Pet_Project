package com.hit.identityservice.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(false, "Uncategorized exception"),
    USER_EXISTED(false, "User existed"),
    USER_NOT_EXISTED(false, "User is not exist"),
    USERNAME_INVALID(false,"Username is invalid" ),
    PASSWORD_INVALID(false, "Password must be at least 8 characters");


    private final boolean success;
    private final String message;


    ErrorCode(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
