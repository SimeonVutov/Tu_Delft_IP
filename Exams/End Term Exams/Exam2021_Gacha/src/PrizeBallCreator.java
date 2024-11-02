import java.util.ArrayList;
import java.util.List;

public class PrizeBallCreator {
    /**
     * Sets the prizes of all balls in the list
     * @param ball ball type
     * @param numberOfBalls number of balls to create
     * @param prizes list of prizes
     * @return list of balls with assigned prizes
     */
    public static List<Ball> createPrizeBalls(
            PrizeBall ball,
            int numberOfBalls,
            List<String> prizes) {

        int prizeIndex = 0;
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < numberOfBalls; i++) {
            PrizeBall newBall = new PrizeBall(ball);
            if(prizeIndex == prizes.size()) {
                prizeIndex = 0;
            }
            newBall.setSelectedPrize(prizes.get(prizeIndex));
            balls.add(newBall);
            prizeIndex++;
        }
        return balls;
    }
}
