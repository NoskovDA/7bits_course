package ru.sevenbits.Noskov.codeFormatter.InputOutput;

enum Parameters {

    FILE("-f"),
    CONSOLE("-c");

    private final String parameter;

    private Parameters(String parameter) {
        this.parameter = parameter;
    }
    public String getParameter() {
        return parameter;
    }

}
