import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {
    private PrizeBall prizeBall1 = new PrizeBall(
            "White",
            "This ball contains a normal prize from the animal range.",
            Rarity.NORMAL,
            "Capibara"
    );
    private PrizeBall prizeBall2 = new PrizeBall(
            "White",
            "This ball contains a normal prize from the animal range.",
            Rarity.NORMAL,
            "Otter"
    );
    private PrizeBall reward = new PrizeBall(
            "White",
            "This ball contains a normal prize from the animal range.",
            Rarity.LEGENDARY,
            "Otter"
    );
    private EmptyBall emptyBall1 = new EmptyBall(
            "White",
            "Oh no! This ball is completely empty. Better luck on the next one!"
    );
    private ExtraBallBall extraBallBall = new ExtraBallBall(
            "White",
            "This ball is special, you get to pull a few more balls!",
            5
    );
    @Test
    void read() {
        String data = """
                NORMAL PRIZE BALL [2]
                White
                This ball contains a normal prize from the animal range.
                {Capibara, Otter}
                EMPTY BALL [1]
                White
                Oh no! This ball is completely empty. Better luck on the next one!
                EXTRA BALLS BALL [1]
                White
                This ball is special, you get to pull a few more balls!
                5""";
        Machine machine = Machine.read(data);
        Machine machine1 = new Machine(List.of(
                new BallCollection(List.of(prizeBall1, prizeBall2)),
                new BallCollection(List.of(emptyBall1)),
                new BallCollection(List.of(extraBallBall))
        ));

        assertEquals(machine1, machine);
    }

    @Test
    void testToString() {
        String data = """
            Normal Prize Ball (White), contains Capibara.
            Normal Prize Ball (White), contains Otter.
            Empty ball (White), contains... nothing.
            Extra Ball Ball (White), gives 5 extra draws.""";
        Machine machine1 = new Machine(List.of(
                new BallCollection(List.of(prizeBall1, prizeBall2)),
                new BallCollection(List.of(emptyBall1)),
                new BallCollection(List.of(extraBallBall))
        ));

        assertEquals(data, machine1.toString());
    }

    @Test
    void testEquals() {
        Machine machine1 = new Machine(List.of(
                new BallCollection(List.of(prizeBall1, prizeBall2)),
                new BallCollection(List.of(emptyBall1)),
                new BallCollection(List.of(extraBallBall))
        ));
        Machine machine2 = new Machine(List.of(
                new BallCollection(List.of(prizeBall1, prizeBall2)),
                new BallCollection(List.of(emptyBall1)),
                new BallCollection(List.of(extraBallBall))
        ));

        assertEquals(machine1, machine2);
    }

    @Test
    void testHashCode() {
        Machine machine1 = new Machine(List.of(
                new BallCollection(List.of(prizeBall1, prizeBall2)),
                new BallCollection(List.of(emptyBall1)),
                new BallCollection(List.of(extraBallBall))
        ));
        Machine machine2 = new Machine(List.of(
                new BallCollection(List.of(prizeBall1, prizeBall2)),
                new BallCollection(List.of(emptyBall1)),
                new BallCollection(List.of(extraBallBall))
        ));

        assertEquals(machine1.hashCode(), machine2.hashCode());
    }

    @Test
    void testGetChanceOfWinning() {
        Machine machine1 = new Machine(List.of(
                new BallCollection(List.of(prizeBall1, reward)),
                new BallCollection(List.of(emptyBall1)),
                new BallCollection(List.of(extraBallBall))
        ));

        assertEquals(25, machine1.getChanceOfWinning());
    }
}