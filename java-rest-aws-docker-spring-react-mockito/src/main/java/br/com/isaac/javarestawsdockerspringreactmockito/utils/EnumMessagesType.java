package br.com.isaac.javarestawsdockerspringreactmockito.utils;

public enum EnumMessagesType {
    VALUE_SHOULD_BE_NUMBER("The value needs to be a number"),
    INTERNAL_ERROR("Internal server error"),
    ERROR_UNSUPPERTED_MATH_OPERATION_ERROR("Unsupported math operation error");

    private final String message;

    EnumMessagesType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
