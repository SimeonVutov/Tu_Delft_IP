import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCardTest {

    @Test
    void createCard() {
        String data = "LEGENDARY\n" +
                "Heroes never die! - 6 Energy - Holy\n" +
                "Revive the most expensive allied unit that died this game.";

        Card card1 = SpellCard.createCard(data);
        Card card2 = new SpellCard(Rarity.LEGENDARY,
                "Heroes never die!",
                6,
                "Holy",
                "Revive the most expensive allied unit that died this game."
        );

        assertEquals(card2, card1);
    }
}