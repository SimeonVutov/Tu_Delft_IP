import java.util.Objects;
import java.util.Scanner;

public class UnitCard extends Card {
    private int attackValue;
    private int defenseValue;

    public UnitCard(Rarity rarity, String name, int energyCost, int attackValue, int defenseValue) {
        super(rarity, name, energyCost);
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
    }

    /**
     * Creates a card from the specified data
     * @param data the data from which the new card will be made
     * @return a new Unit card
     */
    public static Card createCard(String data) {
        Scanner sc = new Scanner(data);
        String rarity = sc.nextLine();
        Scanner otherDataScanner = new Scanner(sc.nextLine());
        otherDataScanner.useDelimiter(" - ");
        String name = otherDataScanner.next();
        Scanner energyScanner = new Scanner(otherDataScanner.next());
        int energyCost = energyScanner.nextInt();

        String[] parts = sc.nextLine().split(" ");
        int attack = Integer.parseInt(parts[0]);
        int defense = Integer.parseInt(parts[3]);

        return new UnitCard(Rarity.valueOf(rarity), name, energyCost, attack, defense);
    }

    @Override
    public String toString() {
        return String.format("Unit: %s (%s), costs %d.\n%d Attack - %d Defense",
                name,
                rarity,
                energyCost,
                attackValue,
                defenseValue
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitCard unitCard = (UnitCard) o;
        return attackValue == unitCard.attackValue && defenseValue == unitCard.defenseValue && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackValue, defenseValue);
    }
}
