package com.ibm.solitaire;

import com.ibm.solitaire.cons.Color;
import com.ibm.solitaire.cons.Type;

public abstract class Card {

    public abstract Type getType();

    public abstract String getName();

    public abstract Character getValue();

    public abstract void setValue(Character value);

    public abstract boolean isFlipped();

    public abstract void setFlipped(boolean flipped);

    public abstract Color getColor();
}
