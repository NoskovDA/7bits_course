package ru.sevenbits.noskov.codeFormatter.inputOutput;
/**
 * Enum: error codes.
 */
public enum ErrorCodes {

    UNKNOWN_PARAMETER("Unknown parameter"),
    WRONGN_NUMBER_PARAMETERS("Wrong number of parameters"),
    EMTY_PARAMETER("Parameter is empty"),
    END_STREAM("There is nothing to read more."),
    STREAM_READER_NOT_CLOSED("This reader is not closed: "),
    STREAM_WRITER_NOT_CLOSED("This writer is not closed: "),
    EMPTY_INPUT_STRING("Input string is empty.");

    private final String errorString;

    private ErrorCodes(String errorString) {
        this.errorString = errorString;
    }
    public String getErrorString() {
        return errorString;
    }

}
