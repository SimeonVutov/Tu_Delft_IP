import java.util.*;

public class Machine {
    private List<BallCollection> collections;
    private List<Ball> allBalls = new ArrayList<>();
    private String log = "";

    /**
     * Creates a new Machine using the collections
     * @param collections all ball collections inside of the machine
     */
    public Machine(List<BallCollection> collections) {
        for (BallCollection collection : collections) {
            allBalls.addAll(collection.getBalls());
        }
        this.collections = collections;
    }

    /**
     * Creates a new Machine use the specified data
     * @param data the data that will be read
     * @return a new Machine object
     */
    public static Machine read(String data) {
        List<BallCollection> collections = new ArrayList<>();
        Scanner sc = new Scanner(data);
        String line;
        String tempData = "";

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            tempData = line + "\n";
            tempData += sc.nextLine() + "\n";
            tempData += sc.nextLine() + "\n";

            if(line.contains("PRIZE") || line.contains("EXTRA")) {
                tempData += sc.nextLine() + "\n";
            }
            collections.add(
                    BallCollection.read(
                            tempData.substring(0, tempData.length() - 1)
                    )
            );
        }

        return new Machine(collections);
    }

    /**
     * Creates a text representation of the object
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        String result = "";
        for (BallCollection collection : collections) {
            result += collection.toString() + "\n";
        }

        return result.substring(0, result.length() - 1);
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
        Machine machine = (Machine) o;
        return Objects.equals(collections, machine.collections);
    }

    /**
     * Creates a hashcode for the object
     * @return the hashcode that was generated
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(collections);
    }

    /**
     * Calculates the chance of winning the legendary reward
     * @return the change of winning
     */
    public int getChanceOfWinning() {
        boolean isPossible = false;

        for (var ball : allBalls) {
            if(ball instanceof PrizeBall) {
                PrizeBall prizeBall = (PrizeBall) ball;
                if(prizeBall.getRarity() == Rarity.LEGENDARY) {
                    isPossible = true;
                    break;
                }
            }
        }

        if(isPossible) {
            double chance = ((double) 1 / allBalls.size()) * 100;
            return (int) chance;
        }

        return 0;
    }
}
