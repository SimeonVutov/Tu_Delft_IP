import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RarityTest {
    @Test
    public void testNormalToString() {
        assertEquals("Normal", Rarity.NORMAL.toString());
    }

    @Test
    public void testEpicToString() {
        assertEquals("Epic", Rarity.EPIC.toString());
    }

    @Test
    public void testRareToString() {
        assertEquals("Rare", Rarity.RARE.toString());
    }

    @Test
    public void testLegendaryToString() {
        assertEquals("Legendary", Rarity.LEGENDARY.toString());
    }
}