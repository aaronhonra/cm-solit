package Anie;

import Anie.Color;

/*
 * By Anie Brimon
 * */

public class Spades extends Card {

	public Spades(String cardName) {
		super(cardName);
	}
	
	public Color getSpadesColor() {
		return Color.BLACK;
	}

	@Override
	String getCardName() {
		return super.cardName;
	}

}
