import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testEquals() {
        Player player = new Player(
                new Stats(1, 1, 1, 1)
        );
        Player player2 = new Player(
                new Stats(1, 1, 1, 1)
        );

        assertEquals(player, player2);
    }

    @Test
    void testHashCode() {
        Player player = new Player(
                new Stats(1, 1, 1, 1)
        );
        Player player2 = new Player(
                new Stats(1, 1, 1, 1)
        );

        assertEquals(player.hashCode(), player2.hashCode());
    }

    @Test
    void testToStringPlayer() {
        Player player = new Player(new Stats(1, 1, 1, 1));
        String data = """
                Player stats:
                    1 Attack
                    1 Defense
                    1 Health
                    1 Speed
                    Equipments:
                        Attack: Not equiped
                        Defense: Not equiped""";

        assertEquals(data, player.toString());
    }
}