package com.ibm.solitaire.Anie;

import com.ibm.solitaire.Anie.Color;

/*
 * By Anie Brimon
 * */

public class Diamond extends Card {

	public Diamond(String cardName) {
		super(cardName);
	}
	
	public Color getDiamondColor() {
		return Color.RED;
	}

	@Override
	String getCardName() {
		return super.cardName;
	}

}
