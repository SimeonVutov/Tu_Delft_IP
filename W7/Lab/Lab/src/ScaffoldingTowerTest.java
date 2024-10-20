import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScaffoldingTowerTest {

    @Test
    void testToString() {
        ScaffoldingTower scaffoldingTower = new ScaffoldingTower("To not be afraid of heights");
        Assertions.assertEquals("This scaffolding tower requires: To not be afraid of heights", scaffoldingTower.toString());
    }

    @Test
    void testEquals() {
        ScaffoldingTower scaffoldingTower = new ScaffoldingTower("To be afraid of heights");
        ScaffoldingTower scaffoldingTower1 = new ScaffoldingTower("To be afraid of heights");
        Assertions.assertEquals(scaffoldingTower, scaffoldingTower1);
    }
}