import java.util.Objects;
import java.util.Scanner;

public class WeaponCard extends Card {
    private int durability;

    public WeaponCard(Rarity rarity, String name, int energyCost, int durability) {
        super(rarity, name, energyCost);
        this.durability = durability;
    }

    /**
     * Creates a card from the specified data
     * @param data the data String from which the Card will be created
     * @return a new WeaponCard object
     */
    public static Card createCard(String data) {
        Scanner sc = new Scanner(data);
        String rarity = sc.nextLine();
        Scanner otherDataScanner = new Scanner(sc.nextLine());
        otherDataScanner.useDelimiter(" - ");
        String name = otherDataScanner.next();
        Scanner energyCostScanner = new Scanner(otherDataScanner.next());
        int energyCost = energyCostScanner.nextInt();
        int durability = sc.nextInt();

        return new WeaponCard(Rarity.valueOf(rarity), name, energyCost, durability);
    }

    @Override
    public String toString() {
        return String.format("Weapon: %s (%s), costs %d.\n%d Durability",
                name,
                rarity,
                energyCost,
                durability
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WeaponCard that = (WeaponCard) o;
        return super.equals(o) && durability == that.durability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), durability);
    }
}
