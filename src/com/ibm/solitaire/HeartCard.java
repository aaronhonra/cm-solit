package com.ibm.solitaire;

import com.ibm.solitaire.cons.Color;
import com.ibm.solitaire.cons.Type;

public class HeartCard extends Card{

    private Character value;
    private boolean isFlipped;
    private static final Color COLOR = Color.RED;
    private static final Type TYPE = Type.HEART;

    public Type getType() {
        return TYPE;
    }

    public String getName() {
        return TYPE.value() + value ;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public Color getColor() {
        return COLOR;
    }
}
