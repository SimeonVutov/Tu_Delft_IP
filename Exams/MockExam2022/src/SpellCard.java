import java.util.Objects;
import java.util.Scanner;

public class SpellCard extends Card {
    private String spellType;
    private String description;

    public SpellCard(Rarity rarity, String name, int energyCost, String spellType, String description) {
        super(rarity, name, energyCost);
        this.spellType = spellType;
        this.description = description;
    }

    /**
     * Creates a card from the specified data
     * @param data the data that will be used to create the card
     * @return a new Spell card
     */
    public static Card createCard(String data) {
        Scanner sc = new Scanner(data);
        String rarity = sc.nextLine();
        Scanner otherDataScanner = new Scanner(sc.nextLine());
        otherDataScanner.useDelimiter(" - ");
        String name = otherDataScanner.next();
        Scanner energyCostScanner = new Scanner(otherDataScanner.next());
        int energyCost = energyCostScanner.nextInt();
        String spellType = otherDataScanner.next();
        String description = sc.nextLine();

        return new SpellCard(Rarity.valueOf(rarity), name, energyCost, spellType, description);
    }

    @Override
    public String toString() {
        return String.format("Spell: %s (%s), costs %d.\n%s - %s",
                name,
                rarity,
                energyCost,
                spellType,
                description
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpellCard spellCard = (SpellCard) o;
        return super.equals(o) && Objects.equals(spellType, spellCard.spellType) && Objects.equals(description, spellCard.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), spellType, description);
    }
}
