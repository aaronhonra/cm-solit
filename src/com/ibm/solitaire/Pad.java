package com.ibm.solitaire;

public class Pad implements Distributable{
    private Deck<Card> deck;

    public Deck<Card> getDeck() {
        return deck;
    }

    public void setDeck(Deck<Card> deck) {
        this.deck = deck;
    }

    @Override
    public void distribute() {

    }
}
