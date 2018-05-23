package com.ibm.solitaire.cons;

public enum Type {
    DIAMOND("diamond"),
    HEART("heart"),
    SPADE("spade"),
    CLUBS("clubs")
    ;
    private String value;

    public String value() {
        return value;
    }

    Type(String value) {
        this.value = value;
    }
}
