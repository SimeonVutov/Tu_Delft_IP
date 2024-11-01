import java.util.Scanner;

public class CardFactory {
    public static Card createCard(String type, Scanner scanner) {
        String data = "";

        for(int i = 0; i < 3; i++) {
            data += scanner.nextLine() + "\n";
        }
        switch (type) {
            case "Unit":
                return UnitCard.createCard(data);
            case "Weapon":
                return WeaponCard.createCard(data);
            case "Spell":
                return SpellCard.createCard(data);
            default:
                throw new IllegalArgumentException("Invalid card type");
        }
    }
}
