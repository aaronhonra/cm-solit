package com.ibm.solitaire.Anie;

import com.ibm.solitaire.Anie.Color;

/*
 * By Anie Brimon
 * */

public class Heart extends Card {

	public Heart(String cardName) {
		super(cardName);
	}
	
	public Color getDHeartColor() {
		return Color.RED;
	}

	@Override
	String getCardName() {
		return super.cardName;
	}

}
