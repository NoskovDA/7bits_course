package ru.sevenbits.noskov.codeFormatter.inputOutput;
/**
 * Enum: error codes.
 */
enum ErrorCodes {

    UNKNOWN_PARAMETER("Unknown parameter"),
    WRONGN_NUMBER_PARAMETERS("Wrong number of parameters"),
    EMTY_PARAMETER("Parameter is empty");

    private final String errorString;

    private ErrorCodes(String errorString) {
        this.errorString = errorString;
    }
    public String getErrorString() {
        return errorString;
    }

}