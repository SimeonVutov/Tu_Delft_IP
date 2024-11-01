import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitCardTest {

    @Test
    void createCard() {
        String data = "RARE\n" +
                "Longbow Archer - 3 Energy\n" +
                "4 Attack – 2 Defence";

        Card card = UnitCard.createCard(data);
        Card card2 = new UnitCard(Rarity.RARE, "Longbow Archer", 3, 4, 2);

        assertEquals(card2, card);
    }
}