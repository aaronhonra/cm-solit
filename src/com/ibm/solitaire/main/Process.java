package com.ibm.solitaire.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ibm.solitaire.*;
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
        Deck<Card> deck = new Deck<>(52);
        for (int i = 1,  ctr = 1; i <= 13 && ctr <= 4; i++) {

            char value = (char) i;

            switch (i){
                case 11:
                    value = 'J';
                    break;
                case 12:
                    value = 'Q';
                    break;
                case 13:
                    value = 'K';
                    break;
                case 1:
                    value = 'A';
                    break;
            }

            switch (ctr){
                case 1:
                    HeartCard heart = new HeartCard();
                    heart.setValue(value);
                    deck.add(heart);
                    break;
                case 2:
                    DiamondCard diamond = new DiamondCard();
                    diamond.setValue(value);
                    deck.add(diamond);
                    break;
                case 3:
                    ClubCard club = new ClubCard();
                    club.setValue(value);
                    deck.add(club);
                    break;
                case 4:
                    SpadeCard spade = new SpadeCard();
                    spade.setValue(value);
                    deck.add(spade);
                    break;
            }
            if(i==13){
                ctr++;
                i = 0;
            }



        }

        return deck;
    }
}
