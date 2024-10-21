import java.io.Serializable;
import java.util.Objects;

public abstract class Card implements Serializable {
    protected Rarity rarity;
    protected String name;
    protected int energyCost;

    public Card(Rarity rarity, String name, int energyCost) {
        this.rarity = rarity;
        this.name = name;
        this.energyCost = energyCost;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return energyCost == card.energyCost && rarity == card.rarity && Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rarity, name, energyCost);
    }
}
