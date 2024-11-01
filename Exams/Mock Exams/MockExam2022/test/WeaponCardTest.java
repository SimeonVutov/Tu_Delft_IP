import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeaponCardTest {

    @Test
    void testCreateCard() {
        String data = "RARE\n" +
                "Warhammer - 3 Energy \n" +
                "2 Durability";

        Card card1 = WeaponCard.createCard(data);
        Card card2 = new WeaponCard(Rarity.RARE, "Warhammer", 3, 2);

        assertEquals(card2, card1);
    }
}