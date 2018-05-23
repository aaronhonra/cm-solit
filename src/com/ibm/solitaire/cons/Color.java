package com.ibm.solitaire.cons;

public enum Color {
    RED("red"),
    BLACK("black")
    ;
    private String value;

    public String value() {
        return value;
    }

    Color(String value) {
        this.value = value;
    }
}
