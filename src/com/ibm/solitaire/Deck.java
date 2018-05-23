package com.ibm.solitaire;

import java.util.ArrayList;
import java.util.List;

public class Deck<E extends Card> extends ArrayList implements Shuffable<E>{

    public Deck(Integer capacity) {
        super(capacity);
    }

    private Deck() {}


    @Override
    public void shuffle() {

    }
}
