package kate.solitaire;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.ibm.kate.solitaire.Card;
import com.ibm.solitaire.constants.Color;
import com.ibm.solitaire.constants.Type;

public class Main{

	public static void main(String[] args) {
		List<Card> initialDeck = new ArrayList<Card>();
		DealDeck deal = new DealDeck();

		initialDeck.addAll(deal.createDeck(Type.CLUBS, Color.BLACK));
		initialDeck.addAll(deal.createDeck(Type.DIAMOND, Color.RED));
		initialDeck.addAll(deal.createDeck(Type.HEART, Color.RED));
		initialDeck.addAll(deal.createDeck(Type.SPADE, Color.BLACK));

		System.out.println("Initial Deck: ");
		printCardList(initialDeck);
		System.out.println("How many times do you want to shuffle?");
		Scanner scanner = new Scanner(System.in);
		int ctr = scanner.nextInt();

		for (int i = 0; i < ctr; i++) {
			initialDeck = deal.shuffleDeck(initialDeck);
			System.out.println("Shuffled deck: ");
			printCardList(initialDeck);
		}

		System.out.println("Distributed cards: ");
		initialDeck = deal.distributeCards(initialDeck);
		System.out.println("Stack 1: ");
		printCardList(deal.d1);
		System.out.println("Stack 2: ");
		printCardList(deal.d2);
		System.out.println("Stack 3: ");
		printCardList(deal.d3);
		System.out.println("Stack 4: ");
		printCardList(deal.d4);
		System.out.println("Stack 5: ");
		printCardList(deal.d5);
		System.out.println("Stack 6: ");
		printCardList(deal.d6);
		System.out.println("Stack 7: ");
		printCardList(deal.d7);
		System.out.println("Remaining deck: ");
		printCardList(initialDeck);
	}
	
	private static void printCardList(List<Card> cardList) {
		cardList.forEach(card -> System.out.print(card.getName() + " "));
		System.out.print("\n");
	}
	
	private static void printCardList(LinkedList<Card> cardList) {
		cardList.forEach(card -> System.out.print(card.getName() + " "));
		System.out.print("\n");
	}
	
	
}
