import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardManager {
    private List<Card> normalCards;
    private List<Card> rareCards;
    private List<Card> epicCards;
    private List<Card> legendaryCards;

    public CardManager(List<Card> draftCards) {
        normalCards = new ArrayList<Card>();
        rareCards = new ArrayList<>();
        epicCards = new ArrayList<>();
        legendaryCards = new ArrayList<>();

        sortCardsByRarity(draftCards);
    }

    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(normalCards);
        cards.addAll(rareCards);
        cards.addAll(epicCards);
        cards.addAll(legendaryCards);

        return cards;
    }

    /**
     * Sorts the cards by rarity
     * @param cards the list of cards that needs to be sorted
     */
    private void sortCardsByRarity(List<Card> cards) {
        for(Card card : cards) {
            switch(card.getRarity()) {
                case NORMAL -> normalCards.add(card);
                case RARE -> rareCards.add(card);
                case EPIC -> epicCards.add(card);
                case LEGENDARY -> legendaryCards.add(card);
            }
        }
    }

    /**
     * Makes a pack of five cards and returns the list of the unpacked cards
     * @return the list of the unpacked cards
     */
    public List<Card> unpackCardPack() {
        List<Card> unpackedCards = new ArrayList<>();

        // Rarity select
        double number;
        double compareValue = Rarity.LEGENDARY.rarity;

        if(getAllCards().isEmpty()) {
            return unpackedCards;
        }

        for(int i = 0; i < 5; i++) {
            number = Math.random();
            if(number < compareValue) {
                if(legendaryCards.size() > 0) {
                    Card selectedCard = selectRandomCard(legendaryCards);
                    unpackedCards.add(selectedCard);
                    continue;
                }
                i--;
            }
            else if(number < compareValue + Rarity.EPIC.rarity) {
                if(epicCards.size() > 0) {
                    Card selectedCard = selectRandomCard(epicCards);
                    unpackedCards.add(selectedCard);
                    continue;
                }
                i--;
            }
            else if(number < compareValue + Rarity.EPIC.rarity + Rarity.RARE.rarity) {
                if(rareCards.size() > 0) {
                    Card selectedCard = selectRandomCard(rareCards);
                    unpackedCards.add(selectedCard);
                    continue;
                }
                i--;
            }
            else {
                if(normalCards.size() > 0) {
                    Card selectedCard = selectRandomCard(normalCards);
                    unpackedCards.add(selectedCard);
                    continue;
                }
                i--;
            }
        }

        return unpackedCards;
    }

    /**
     * Selects a card randomly from the specified rarity
     * @param cards the list of cards from which we need to get random  card
     * @return
     */
    private Card selectRandomCard(List<Card> cards) {
        Card card = cards.get((int) (Math.random() * cards.size()));
        cards.remove(card);
        return card;
    }
}
