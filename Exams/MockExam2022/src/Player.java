import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    public int gold;
    List<Card> cardCollection;

    public Player() {
        this.gold = 0;
        this.cardCollection = new ArrayList<Card>();
    }

    public List<Card> getCardCollection() {
        return cardCollection;
    }

    public int getGold() {
        return gold;
    }

    /**
     * Adds a card to player collection
     * If the card is already present, we sell it
     * @param card the card that will be added
     */
    public void addCard(Card card) {
        if(cardCollection.contains(card)) {
            sellCard(card);
        }
        else {
            cardCollection.add(card);
        }
    }

    /**
     * Adds gold based on card rarity
     * @param card the card that is used to add gold
     */
    public void sellCard(Card card) {
        gold += card.getRarity().goldPrice;
    }

    /**
     * Process the unpacked cards
     * @param cards the list of unpacked cards
     */
    public void processUnpackedCards(List<Card> cards) {
        for(Card card : cards) {
            addCard(card);
        }
    }
}
