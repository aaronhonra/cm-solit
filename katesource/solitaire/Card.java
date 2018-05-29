package solitaire;

import com.ibm.solitaire.cons.Color;
import com.ibm.solitaire.cons.Type;

public class Card {
	private int rank;
	private boolean isFlipped;
	private Color color;
	private Type suit;
	public int test;

	public String getName() {
		return suit.name() + Integer.toString(rank);
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public boolean isFlipped() {
		return isFlipped;
	}
	public void setFlipped(boolean isFlipped) {
		this.isFlipped = isFlipped;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Type getSuit() {
		return suit;
	}
	public void setSuit(Type suit) {
		this.suit = suit;
	}
	
	void Card() {
		this.test = 1;
	}

}
