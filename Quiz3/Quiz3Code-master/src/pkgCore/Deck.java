package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}
	public int getRemaining(Object eNum) {
		int num =0;
		if (eNum instanceof eSuit) {
			for(Card c: cardsInDeck) {
				if (c.geteSuit()== eNum) {
					num++;
				}
				return num;
			}
		}
		if (eNum instanceof eRank) {
				for(Card c: cardsInDeck) {
					if(c.geteRank()== eNum) {
						num++;
					}
					return num;
				}
			}
		int intt=-1;
		return intt;
		
	}
}