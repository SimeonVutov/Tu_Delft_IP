import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallCollectionTest {
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
    private EmptyBall emptyBall1 = new EmptyBall(
            "White",
            "This ball contains a normal prize from the animal range."
    );
    private ExtraBallBall extraBallBall = new ExtraBallBall(
            "White",
            "This ball contains a normal prize from the animal range.",
            5
    );

    @Test
    void testFilter() {
        BallCollection ballCollection = new BallCollection(
                List.of(prizeBall1, prizeBall2, prizeBall2)
        );

        List<Ball> balls = ballCollection.filterUniqueBalls();

        List<Ball> balls2 = List.of(prizeBall1, prizeBall2);

        assertEquals(balls2, balls);
    }

    @Test
    void testToString() {
        BallCollection ballCollection = new BallCollection(
                List.of(prizeBall1, prizeBall2, prizeBall2)
        );

        String expects = "Normal Prize Ball (White), contains Capibara.\n" +
                "Normal Prize Ball (White), contains Otter.";

        assertEquals(expects, ballCollection.toString());
    }

    @Test
    void createPrizeBalls() {
        String data = "NORMAL PRIZE BALL [2]\n" +
                "White\n" +
                "This ball contains a normal prize from the animal range.\n" +
                "{Capibara}";
        List<Ball> balls = List.of(prizeBall1, prizeBall1);
        List<Ball> balls2 = BallCollection.createPrizeBalls(data);

        assertEquals(balls, balls2);
    }

    @Test
    void testRead() {
        String data2 = """
                EMPTY BALL [1]
                Red
                Oh no! This ball is completely empty. Better luck on the next one!
                """;
        BallCollection bc =  BallCollection.read(data2);

        BallCollection bc2 = new BallCollection(List.of(new EmptyBall(
                "Red",
                "Oh no! This ball is completely empty. Better luck on the next one!")
        ));

        assertEquals(bc2, bc);
    }

    @Test
    void testEquals() {
        BallCollection bc1 = new BallCollection(List.of(new EmptyBall(
                "Red",
                "Oh no! This ball is completely empty. Better luck on the next one!")
        ));
        BallCollection bc2 = new BallCollection(List.of(new EmptyBall(
                "Red",
                "Oh no! This ball is completely empty. Better luck on the next one!")
        ));

        assertEquals(bc1, bc2);
    }

    @Test
    void testHashCode() {
        BallCollection bc1 = new BallCollection(List.of(new EmptyBall(
                "Red",
                "Oh no! This ball is completely empty. Better luck on the next one!")
        ));
        BallCollection bc2 = new BallCollection(List.of(new EmptyBall(
                "Red",
                "Oh no! This ball is completely empty. Better luck on the next one!")
        ));

        assertEquals(bc1.hashCode(), bc2.hashCode());
    }
}