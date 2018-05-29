package Anie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

/*
 * By Anie Brimon
 * */

public class SolitaireMainWithObj {
	
	private static int CARD_COUNT_PER_SUIT = 13;
	private static String C = "clubs";
	private static String D = "diamond";	
	private static String H = "heart";
	private static String S = "spades";
	private static String BACK = "Back";
	private static String FRONT = "Front";
	private static String BLANK = " ";
	private static String INVALID_INPUT_MSG = "Please enter valid number 1 to 100 only!";
	
	public static void main(String[] args) {
		
		SolitaireMainWithObj solitaireMainWithObj = new SolitaireMainWithObj();		
		
		// Prepare the cards				
		List<Card> allCardsList = new ArrayList<Card>();		
		allCardsList = solitaireMainWithObj.prepareCards(allCardsList);
		
		// User entry
		System.out.println();
		System.out.println("Step 1 : Shuffle");
		int shuffleCardsByInt = solitaireMainWithObj.shuffleByInt();
		
		if (shuffleCardsByInt > 0) {
			// Pass all cards, then cut and shuffle
			allCardsList = solitaireMainWithObj.cutThenShuffleList(shuffleCardsByInt, allCardsList);
			
		}
		
		// Note : Every 8th shuffle, the cards are in order by suit		

		// Distribute
		System.out.println();
		System.out.println("Step 2 : Distribute");
		solitaireMainWithObj.distributeCard(allCardsList);

	}
	
	private List<Card> prepareCards(List<Card> cardsAll) {
		
		List<Anie.Clubs> clubsCardList = new ArrayList<Anie.Clubs>();
		List<Anie.Diamond> diamondCardList = new ArrayList<Anie.Diamond>();
		List<Anie.Heart> heartCardList = new ArrayList<Anie.Heart>();
		List<Anie.Spades> spadesCardList = new ArrayList<Anie.Spades>();
		int ind = 0;

		for (int x=0; x<CARD_COUNT_PER_SUIT; x++) {
			ind = x + 1;
			StringBuilder strB = new StringBuilder();
			
			// Clubs Cards			
			strB.append(C);
			if (ind < 10) {
				strB.append("0");
			}
			strB.append(String.valueOf(ind));
			clubsCardList.add(new Anie.Clubs(strB.toString()));
			clubsCardList.get(x).setCardBackFace(strB.toString() + BACK);
			clubsCardList.get(x).setCardFrontFace(strB.toString() + FRONT);
			//System.out.print(clubsCardList.get(x).getCardName() + ", ");
			
			// Diamond Cards
			strB = new StringBuilder();
			strB.append(D);
			if (ind < 10) {
				strB.append("0");
			}
			strB.append(String.valueOf(ind));
			diamondCardList.add(new Anie.Diamond(strB.toString()));
			diamondCardList.get(x).setCardBackFace(strB.toString() + BACK);
			diamondCardList.get(x).setCardFrontFace(strB.toString() + FRONT);
			//System.out.print(diamondCardList.get(x).getCardName() + ", ");
			
			// Heart Cards
			strB = new StringBuilder();
			strB.append(H);
			if (ind < 10) {
				strB.append("0");
			}
			strB.append(String.valueOf(ind));
			heartCardList.add(new Anie.Heart(strB.toString()));
			heartCardList.get(x).setCardBackFace(strB.toString() + BACK);
			heartCardList.get(x).setCardFrontFace(strB.toString() + FRONT);
			//System.out.print(heartCardList.get(x).getCardName() + ", ");
			
			// Spades Cards
			strB = new StringBuilder();
			strB.append(S);
			if (ind < 10) {
				strB.append("0");
			}
			strB.append(String.valueOf(ind));
			spadesCardList.add(new Anie.Spades(strB.toString()));
			spadesCardList.get(x).setCardBackFace(strB.toString() + BACK);
			spadesCardList.get(x).setCardFrontFace(strB.toString() + FRONT);
			//System.out.println(spadesCardList.get(x).getCardName() + ", getBackFace: " + spadesCardList.get(x).getCardBackFace());
						
		}
				
		cardsAll.addAll(clubsCardList);
		cardsAll.addAll(diamondCardList);
		cardsAll.addAll(heartCardList);
		cardsAll.addAll(spadesCardList);
				
		System.out.print("Initial setup of all cards: ");
		printCards(cardsAll);
				
		return cardsAll;
		
	}
	
	private void printCards(List<Card> cardList) {
		
		int listSize = cardList.size();
		
		for (int x=0; x<listSize; x++) {
			
			if (x == listSize - 1) {
				System.out.print(cardList.get(x).getCardName());
				break;
			}			
			System.out.print(cardList.get(x).getCardName() + ", ");
			
		}
		System.out.println();
		
	}
	
	private int shuffleByInt () {
		
		int shuffleByInt = 0;
		
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		String inputString = null;
				
		try {
			System.out.print("How many times do you want to shuffle the cards? ");
			inputString = input.readLine();
			input.close();
			
			if (inputString.isEmpty()) {
				System.out.println(INVALID_INPUT_MSG);
				return shuffleByInt;
			}
			
			shuffleByInt = Integer.parseInt (inputString);;
			if (shuffleByInt == 0 || shuffleByInt < 0 || shuffleByInt > 100) {
				System.out.println(INVALID_INPUT_MSG);
				return 0;
			}			
			
		} catch (IOException e1) {
			System.out.println(INVALID_INPUT_MSG);
		} catch (InputMismatchException e) {
			System.out.println(INVALID_INPUT_MSG);
		} catch (NumberFormatException e) {
			System.out.println(INVALID_INPUT_MSG);
		}
		
		return shuffleByInt;
		
	}
	
	private List<Card> cutThenShuffleList (int shuffleBy, List<Card> allCards) {
		
		List<Card> deck1List = new ArrayList<Card>();
		List<Card> deck2List = new ArrayList<Card>();
		
		int listSize = allCards.size();
		int halfListSize = listSize / 2;
		
		for (int x=0; x<shuffleBy; x++) {
			//System.out.println("SHUFFLE " + (x+1));
			
			// Cut cards
			deck1List = allCards.subList(0, halfListSize);
			deck2List = allCards.subList(halfListSize, listSize);
			
//			System.out.print("Deck 1 : ");
//			printCards(deck1List);
//			System.out.print("Deck 2 : ");
//			printCards(deck2List);
			
			allCards = new ArrayList<Card>();			
			
			// Shuffle Cards
			for (int y=0; y<halfListSize; y++) {
				allCards.add(deck1List.get(y));	
				allCards.add(deck2List.get(y));	
			}	
			
			if (x == (shuffleBy - 1)) {
				System.out.print("Shuffled Cards : ");
				printCards(allCards);
			}
			
		}
		
		return allCards;
		
	}
	
	private void distributeCard (List<Card> allCardsList) {
		
		LinkedList<Card> linkedAllPilList = new LinkedList<Card>();
		linkedAllPilList.addAll(allCardsList);
		
		LinkedList<Card> linkedpile1List = new LinkedList<Card>();
		LinkedList<Card> linkedpile2List = new LinkedList<Card>();
		LinkedList<Card> linkedpile3List = new LinkedList<Card>();
		LinkedList<Card> linkedpile4List = new LinkedList<Card>();
		LinkedList<Card> linkedpile5List = new LinkedList<Card>();
		LinkedList<Card> linkedpile6List = new LinkedList<Card>();
		LinkedList<Card> linkedpile7List = new LinkedList<Card>();
		
		for (int x=0; x<6; x++) {
	
//			if (linkedpile1List.size() == 1) {
//				linkedpile2List.add(allCardsList.get(x));
//				linkedAllPilList.poll();
//
//				linkedpile3List.add(allCardsList.get(++x));
//				linkedAllPilList.poll();
//
//				linkedpile4List.add(allCardsList.get(++x));
//				linkedAllPilList.poll();
//
//				linkedpile5List.add(allCardsList.get(++x));
//				linkedAllPilList.poll();
//
//				linkedpile6List.add(allCardsList.get(++x));
//				linkedAllPilList.poll();
//
//				linkedpile7List.add(allCardsList.get(++x));
//				linkedAllPilList.poll();
//				
//				if (linkedpile2List.size() == 2) {
//					linkedpile3List.add(allCardsList.get(x));
//					linkedAllPilList.poll();
//
//					linkedpile4List.add(allCardsList.get(++x));
//					linkedAllPilList.poll();
//
//					linkedpile5List.add(allCardsList.get(++x));
//					linkedAllPilList.poll();
//
//					linkedpile6List.add(allCardsList.get(++x));
//					linkedAllPilList.poll();
//
//					linkedpile7List.add(allCardsList.get(++x));
//					linkedAllPilList.poll();
//					
//					if (linkedpile3List.size() == 3) {
//						linkedpile4List.add(allCardsList.get(++x));
//						linkedAllPilList.poll();
//
//						linkedpile5List.add(allCardsList.get(++x));
//						linkedAllPilList.poll();
//
//						linkedpile6List.add(allCardsList.get(++x));
//						linkedAllPilList.poll();
//
//						linkedpile7List.add(allCardsList.get(++x));
//						linkedAllPilList.poll();
//						
//						if (linkedpile4List.size() == 4) {
//							linkedpile5List.add(allCardsList.get(++x));
//							linkedAllPilList.poll();
//
//							linkedpile6List.add(allCardsList.get(++x));
//							linkedAllPilList.poll();
//
//							linkedpile7List.add(allCardsList.get(++x));
//							linkedAllPilList.poll();
//							
//							if (linkedpile5List.size() == 5) {
//								linkedpile6List.add(allCardsList.get(++x));
//								linkedAllPilList.poll();
//
//								linkedpile7List.add(allCardsList.get(++x));
//								linkedAllPilList.poll();
//								
//								if (linkedpile6List.size() == 6) {
//									linkedpile7List.add(allCardsList.get(++x));
//									linkedAllPilList.poll();
//								}
//								
//							}
//						}
//					}
//				}
//			}
			linkedpile1List.add(allCardsList.get(x));
			linkedAllPilList.poll();

			linkedpile2List.add(allCardsList.get(++x));
			linkedAllPilList.poll();

			linkedpile3List.add(allCardsList.get(++x));
			linkedAllPilList.poll();

			linkedpile4List.add(allCardsList.get(++x));
			linkedAllPilList.poll();

			linkedpile5List.add(allCardsList.get(++x));
			linkedAllPilList.poll();

			linkedpile6List.add(allCardsList.get(++x));
			linkedAllPilList.poll();

			linkedpile7List.add(allCardsList.get(++x));
			linkedAllPilList.poll();
			
		}
		
		linkedpile2List = distributeMini(linkedAllPilList, linkedpile2List, 1, false);
		linkedpile3List = distributeMini(linkedAllPilList, linkedpile3List, 2, true);
		linkedpile4List = distributeMini(linkedAllPilList, linkedpile4List, 3, true);
		linkedpile5List = distributeMini(linkedAllPilList, linkedpile5List, 4, true);
		linkedpile6List = distributeMini(linkedAllPilList, linkedpile6List, 5, true);
		linkedpile7List = distributeMini(linkedAllPilList, linkedpile7List, 6, true);
		
		linkedAllPilList.removeAll(linkedpile2List);
		linkedAllPilList.removeAll(linkedpile3List);
		linkedAllPilList.removeAll(linkedpile4List);
		linkedAllPilList.removeAll(linkedpile5List);
		linkedAllPilList.removeAll(linkedpile6List);
		linkedAllPilList.removeAll(linkedpile7List);
		
		System.out.print("Remaining list : ");
		printCards(linkedAllPilList);
		System.out.print("Pile1 list : ");
		printCards(linkedpile1List);
		System.out.print("Pile2 list : ");
		printCards(linkedpile2List);
		System.out.print("Pile3 list : ");
		printCards(linkedpile3List);
		System.out.print("Pile4 list : ");
		printCards(linkedpile4List);
		System.out.print("Pile5 list : ");
		printCards(linkedpile5List);
		System.out.print("Pile6 list : ");
		printCards(linkedpile6List);
		System.out.print("Pile7 list : ");
		printCards(linkedpile7List);
		
//		System.out.print("linkedAllPilList : ");
//		printCards(linkedAllPilList);
//		System.out.print("linkedpile2List : ");
//		printCards(linkedpile2List);
//		System.out.print("linkedpile3List : ");
//		printCards(linkedpile3List);
//		System.out.print("linkedpile4List : ");
//		printCards(linkedpile4List);
		
//		List<String> pile1List = new ArrayList<String>();
//		List<String> pile2List = new ArrayList<String>();
//		List<String> pile3List = new ArrayList<String>();
//		List<String> pile4List = new ArrayList<String>();
//		List<String> pile5List = new ArrayList<String>();
//		List<String> pile6List = new ArrayList<String>();
//		List<String> pile7List = new ArrayList<String>();
		
		List<Card> pileSummary = allCardsList.subList(0, 28);
		
//		HashMap<Heart, Card> hm = new HashMap<Heart, Card>();
//		hm.put(new Heart("heartsamp"), pileSummary.get(0));
//		System.out.println("hm - " + hm.values().getClass());
		
//		for (int x=0; x<pileSummary.size(); x++) {
//			//allCardsList.get(x)
//
//			if (x == 0) {
//				pile1List.add(pileSummary.get(x).getCardFrontFace());
//				continue;
//			}else if (x == 1 || x == 7) {
//				if (x == 7) {
//					pile2List.add(pileSummary.get(x).getCardFrontFace());
//					continue;
//				}
//				pile2List.add(pileSummary.get(x).getCardBackFace());
//			}else if (x == 2 || x == 8 || x == 13) {
//				if (x == 13) {
//					pile3List.add(pileSummary.get(x).getCardFrontFace());
//					continue;
//				}
//				pile3List.add(pileSummary.get(x).getCardBackFace());
//			}else if (x == 3 || x == 9 || x == 14 || x == 18) {
//				if (x == 18) {
//					pile4List.add(pileSummary.get(x).getCardFrontFace());
//					continue;
//				}
//				pile4List.add(pileSummary.get(x).getCardBackFace());
//			}else if (x == 4 || x == 10 || x == 15 || x == 19 || x == 22) {
//				if (x == 22) {
//					pile5List.add(pileSummary.get(x).getCardFrontFace());
//					continue;
//				}
//				pile5List.add(pileSummary.get(x).getCardBackFace());
//			}else if (x == 5 || x == 11 || x == 16 || x == 20 || x == 23 || x == 25) {
//				if (x == 25) {
//					pile6List.add(pileSummary.get(x).getCardFrontFace());
//					continue;
//				}
//				pile6List.add(pileSummary.get(x).getCardBackFace());
//			}else {
//				if (x == 27) {
//					pile7List.add(pileSummary.get(x).getCardFrontFace());
//					continue;
//				}
//				pile7List.add(pileSummary.get(x).getCardBackFace());
//			}												
//		}
//		System.out.println("Pile 1: " + pile1List);
//		System.out.println("Pile 2: " + pile2List);
//		System.out.println("Pile 3: " + pile3List);
//		System.out.println("Pile 4: " + pile4List);
//		System.out.println("Pile 5: " + pile5List);
//		System.out.println("Pile 6: " + pile6List);
//		System.out.println("Pile 7: " + pile7List);
		//printCards(pileSummary);
	}
	
	private LinkedList<Card> distributeMini(LinkedList<Card> linkedListFrom, LinkedList<Card> linkedListTo, int times, boolean isMany) {
		int startInterval = 4;

		for (int x=0; x<1; x++) {
			linkedListTo.add(linkedListFrom.get(x));
			linkedListFrom.poll();
			
			if (isMany) {
				if (times >= 2) {
					for (int y=0; y<(times-1);y++) {
						linkedListTo.add(linkedListFrom.get(startInterval));
						//linkedListFrom.poll();
						//System.out.println("A0:" + linkedListFrom.get(0).getCardName());
						//System.out.println("A:" + linkedListFrom.get(startInterval).getCardName());
						//System.out.println("times = " + times + ", startInterval = " + startInterval );
						startInterval--;

					}
					break;
				}
				linkedListTo.add(linkedListFrom.get(startInterval));				
				break;
			}			
		}
		
		return linkedListTo;
	}

}
