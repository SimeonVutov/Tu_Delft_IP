import java.util.List;
import java.util.Scanner;

public class EquipmentFactory {
    /**
     * Reads the data string and creates new equipment from all possible
     * @param data the data that will be used
     * @return the new Equipment
     */
    public static Equipment readEquipment(String data) {
        data = data.replaceFirst("EQUIPMENT - ", "");
        Scanner main = new Scanner(data);
        String line = main.nextLine();

        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(" - ");
        String name = lineScanner.next();
        EquipmentCategory category = EquipmentCategory.valueOf(lineScanner.next().toUpperCase());
        int id = Integer.parseInt(lineScanner.next());
        String stats = main.nextLine();
        String lastLine = main.nextLine();
        List<String> strength = DataReader.readStrengths(lastLine);
        List<String> weaknesses = DataReader.readWeaknesses(lastLine);

        int stat = 0;
        if(category == EquipmentCategory.OFFENSIVE) {
            stat = OffensiveEquipment.readStat(stats);
            return new OffensiveEquipment(
                    name,
                    id,
                    strength,
                    weaknesses,
                    stat
            );
        }
        else if(category == EquipmentCategory.DEFENSIVE) {
            stat = DefensiveEquipment.readStat(stats);
            return new DefensiveEquipment(
                    name,
                    id,
                    strength,
                    weaknesses,
                    stat
            );
        }

        // Not recognized type of equipment
        return null;
    }
}
