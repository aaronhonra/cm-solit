package solitaire;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ibm.solitaire.cons.Color;
import com.ibm.solitaire.cons.Type;

public class DealDeck implements Shuffable, Distribution {
	
	LinkedList<Card> d1 = new LinkedList<Card>();
	LinkedList<Card> d2 = new LinkedList<Card>();
	LinkedList<Card> d3 = new LinkedList<Card>();
	LinkedList<Card> d4 = new LinkedList<Card>();
	LinkedList<Card> d5 = new LinkedList<Card>();
	LinkedList<Card> d6 = new LinkedList<Card>();
	LinkedList<Card> d7 = new LinkedList<Card>();
	List<Card> heartPile = new ArrayList<Card>();
	List<Card> diamondPile = new ArrayList<Card>();
	List<Card> clubsPile = new ArrayList<Card>();
	List<Card> spadePile = new ArrayList<Card>();
	
	List<Card> createDeck(Type type, Color color) {
		List<Card> deckList = new ArrayList<Card>();
		
		for (int i = 1; i <= 13; i++) {
			Card card = new Card();
			card.setRank(i);
			card.setSuit(type);
			card.setColor(color);
			deckList.add(card);
		}
		
		return deckList;
	}
	
	public List<Card> shuffleDeck(List<Card> deck) {
		int halfDeckSize = deck.size() / 2;

		List<Card> shuffledDeck = new ArrayList<Card>();
		List<Card> deckOne = deck.subList(0, halfDeckSize);
		List<Card> deckTwo = deck.subList(halfDeckSize, deck.size());
		System.out.println("First half deck: ");
		printCardList(deckOne);
		System.out.println("Second half deck: ");
		printCardList(deckTwo);

		for (int i = 0; i < halfDeckSize; i++) {
			shuffledDeck.add(deckOne.get(i));
			shuffledDeck.add(deckTwo.get(i));
		}

		return shuffledDeck;
	}
	
	private static void printCardList(List<Card> cardList) {
		cardList.forEach(card -> System.out.print(card.getName() + " "));
		System.out.print("\n");
	}
	
	public List<Card> distributeCards(List<Card> deck) {
		loopCards(1, deck, d1);
		loopCards(2, deck, d2);
		loopCards(3, deck, d3);
		loopCards(4, deck, d4);
		loopCards(5, deck, d5);
		loopCards(6, deck, d6);
		loopCards(7, deck, d7);
		
		d1.getLast().setFlipped(true);
		d2.getLast().setFlipped(true);
		d3.getLast().setFlipped(true);
		d4.getLast().setFlipped(true);
		d5.getLast().setFlipped(true);
		d6.getLast().setFlipped(true);
		d7.getLast().setFlipped(true);
		
		return deck;
	}
	
	List<Card> loopCards(int noOfIterations, List<Card> primaryDeck, LinkedList<Card> stackDeck) {
		for(int i = 0; i < noOfIterations; i++) {
			if(stackDeck.isEmpty()) {
				primaryDeck.get(i).setFlipped(false);
				stackDeck.add(primaryDeck.get(i));
				primaryDeck.remove(i);
			} else {
				primaryDeck.get(i).setFlipped(false);
				stackDeck.add(primaryDeck.get(i));
				primaryDeck.remove(i);
			}
		}
		
		return primaryDeck;
	}
	
//	static void playCards(LinkedList<Card> stackDeck) {
//		if(stackDeck.getLast().isFlipped()) {
//			sta
//		}
//	}
}
