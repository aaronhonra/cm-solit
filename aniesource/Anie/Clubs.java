package Anie;

import Anie.Color;

/*
 * By Anie Brimon
 * */

public class Clubs extends Card {

	public Clubs(String cardName) {
		super(cardName);		
	}
	
	public Color getClubsColor() {
		return Color.BLACK;
	}

	@Override
	String getCardName() {
		return super.cardName;
	}	

}
