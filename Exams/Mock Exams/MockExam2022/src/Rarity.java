import java.io.Serializable;

public enum Rarity implements Serializable {
    NORMAL(0.74, 1),
    RARE(0.16, 2),
    EPIC(0.08, 4),
    LEGENDARY(0.02, 10);

    public final double rarity;
    public final int goldPrice;

    Rarity(double rarity, int goldPrice) {
        this.rarity = rarity;
        this.goldPrice = goldPrice;
    }
}
