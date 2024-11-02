import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BallCollection {
    private List<Ball> balls;

    /**
     * Creates a new BallCollection
     * @param balls list of balls
     */
    public BallCollection(List<Ball> balls) {
        this.balls = balls;
    }

    /**
     * Returns the list of balls in the collection
     * @return the list of balls
     */
    public List<Ball> getBalls() {
        return balls;
    }

    /**
     * Creates a new BallCollection
     * @param data data
     * @return new Ball collection object
     */
    public static BallCollection read(String data) {
        List<Ball> balls = new ArrayList<>();
        int number;
        String colour, description;
        Scanner sc = new Scanner(data);

        if(data.contains("PRIZE")) {
            balls = createPrizeBalls(data);
            return new BallCollection(balls);
        }
        else if(data.contains("EXTRA")) {
            sc.next(); sc.next(); sc.next();
            number = readNumber(sc.next());
            sc.nextLine();
            colour = sc.nextLine();
            description = sc.nextLine();
            int amount = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < number; i++) {
                balls.add(new ExtraBallBall(colour, description, amount));
            }
        }
        else if(data.contains("EMPTY")) {
            sc.next(); sc.next();
            number = readNumber(sc.next());
            sc.nextLine();
            colour = sc.nextLine();
            description = sc.nextLine();
            for(int i = 0; i < number; i++) {
                balls.add(new EmptyBall(colour, description));
            }
        }

        return new BallCollection(balls);
    }

    /**
     * Creates all prize balls from reading the data
     * @param data data that will be read and used for creating the balls
     * @return a list of all balls
     */
    public static List<Ball> createPrizeBalls(String data) {
        Scanner sc = new Scanner(data);
        Rarity rarity = Rarity.valueOf(sc.next());
        sc.next(); sc.next();
        int number = readNumber(sc.next());
        sc.nextLine();
        String colour = sc.nextLine();
        String description = sc.nextLine();
        List<String> prizes = readPrizes(sc.nextLine());
        List<Ball> balls = PrizeBallCreator.createPrizeBalls(
                new PrizeBall(colour, description, rarity, ""),
                number,
                prizes);
        return balls;
    }

    private static int readNumber(String data) {
        return Integer.parseInt(data.substring(1, data.length() - 1));
    }

    private static List<String> readPrizes(String data) {
        data = data.substring(1, data.length() - 1);
        Scanner sc = new Scanner(data);
        sc.useDelimiter(", ");
        List<String> prizes = new ArrayList<>();

        while(sc.hasNext()) {
            prizes.add(sc.next());
        }

        return prizes;
    }

    /**
     * Creates a text representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        String result = "";
        List<Ball> balls = filterUniqueBalls();
        for (var ball : balls) {
            result += ball.toString() + "\n";
        }

        return result.substring(0, result.length() - 1);
    }

    /**
     * Filters the list of all balls in the collection so it only includes unique
     * @return list of unique balls
     */
    public List<Ball> filterUniqueBalls() {
        return balls.stream()
                .distinct()
                .toList();
    }

    /**
     * Checks if the specified object is equal to this
     * @param o the object we check this with
     * @return true/false based on whether the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallCollection that = (BallCollection) o;
        return Objects.equals(balls, that.balls);
    }

    /**
     * Creates a hashcode for the object
     * @return the hashcode that was generated
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(balls);
    }
}
