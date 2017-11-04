package ru.sevenbits.noskov.codeFormatter.inputOutput;

/**
 * Enum: arguments from command line.
 */
enum Parameters {

    FILE("-f"),
    CONSOLE("-c");

    private final String parameter;

    private Parameters(final String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

}
