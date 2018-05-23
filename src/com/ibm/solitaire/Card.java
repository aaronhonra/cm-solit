package com.ibm.solitaire;

import com.ibm.solitaire.cons.Color;
import com.ibm.solitaire.cons.Type;

public class Card {
    private String name;
    private int value;
    private boolean isFlipped;
    private Color color;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private Type type;

    public String getName() {
        return type.value() + value ;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
