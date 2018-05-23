package com.ibm.solitaire.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ibm.solitaire.Card;
import com.ibm.solitaire.cons.Color;
import com.ibm.solitaire.cons.Type;

public class Process {
    public static void main(String[] args) {//
        List<Card> cardList = createCards();

        System.out.println("Current Cards:");
        printCardList(cardList);

        Scanner scanner = new Scanner(System.in);
        int numberOfShuffles = scanner.nextInt();

        if (numberOfShuffles >= 0) {
            List<Card> shuffledList = shuffleCards(numberOfShuffles, cardList);

            printCardList(shuffledList);
        } else {

            System.err.println("invalid input");
        }
    }

    private static List<Card> shuffleCards(int numberOfShuffles, List<Card> cardList) {
        if (numberOfShuffles == 0) {
            return cardList;
        } else {
            List<Card> shuffledList = new ArrayList<>();
            for (int i = 0, j = cardList.size()/2; i < cardList.size()/2; i++, j++) {
                shuffledList.add(cardList.get(i));
                shuffledList.add(cardList.get(j));
            }

            return shuffleCards(--numberOfShuffles, shuffledList);
        }
    }

    private static void printCardList(List<Card> cardList) {
        cardList.forEach(card -> System.out.print(card.getName() + " "));
    }

    private static List<Card> createCards() {
        List<Card> cardList = new ArrayList<>();

        for (int i = 0, counter = 1; i < 52; i++, counter++) {
            Card card = new Card();
            if (i <= 12) {
                card.setColor(Color.BLACK);
                card.setType(Type.CLUBS);
            } else if (i > 12 && i <= 25) {
                card.setColor(Color.RED);
                card.setType(Type.DIAMOND);
            } else if (i > 25 && i <= 38) {
                card.setColor(Color.RED);
                card.setType(Type.HEART);
            } else if (i > 38 && i <= 51) {
                card.setColor(Color.BLACK);
                card.setType(Type.SPADE);
            }

            card.setValue(counter);
            cardList.add(card);
            if (counter % 13 == 0) {
                counter = 0;
            }
        }

        return cardList;
    }
}
