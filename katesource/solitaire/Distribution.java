package solitaire;

import java.util.List;

public interface Distribution {
	List<Card> distributeCards(List<Card> deck);
}
