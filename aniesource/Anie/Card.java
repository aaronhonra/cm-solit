package Anie;

import Anie.Color;

/*
 * By Anie Brimon
 * */

public abstract class Card {
	
	protected String cardName;
	private String cardFrontFace;
	private String cardBackFace;
	private boolean isFlipped;

	public String getCardFrontFace() {
		return cardFrontFace;
	}

	public void setCardFrontFace(String cardFrontFace) {
		this.cardFrontFace = cardFrontFace;
	}

	public String getCardBackFace() {
		return cardBackFace;
	}

	public void setCardBackFace(String cardBackFace) {
		this.cardBackFace = cardBackFace;
	}
	
	public Color getCardColor (Card c) {
		Color cardColor = null;
		String cardStr = c.cardName;
		
		if (cardStr.contains("clubs")) {
			cardColor = Color.BLACK;
		}else if (cardStr.contains("diamond")) {
			cardColor = Color.RED;
		}else if (cardStr.contains("heart")) {
			cardColor = Color.RED;
		}else if (cardStr.contains("spades")) {
			cardColor = Color.BLACK;
		}
		
		return cardColor;
	}

	public Card(String cardName) {
		this.cardName = cardName;
	}
	
	abstract String getCardName();

}
