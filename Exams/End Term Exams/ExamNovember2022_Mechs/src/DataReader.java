import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataReader {

    /**
     * Reads the data and creates a new Mech object from it
     * @param data the data that will be used
     * @return the new Mech object
     */
    public static List<Mech> readMechs(String data) {
        Scanner sc = new Scanner(data);
        int numberOfMechs = Integer.parseInt(sc.nextLine());
        String result = "";
        List<Mech> mechs = new ArrayList<Mech>();

        for(int i = 0; i < numberOfMechs; i++) {
            for(int j = 0; j < 3; j++) {
                result += sc.nextLine();
                if(j < 2) {
                    result += "\n";
                }
            }
            mechs.add(Mech.read(result));
            result = "";
        }

        return mechs;

    }

    /**
     * Reads all Equipments from the data
     * @param data the data from which we will read
     * @return a list of all equipments
     */
    public static List<Equipment> readEquipments(String data) {
        Scanner sc = new Scanner(data);
        int numberOfMechs = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < numberOfMechs * 3; i++) {
            sc.nextLine();
        }

        int numberOfEquipment = Integer.parseInt(sc.nextLine());
        String result = "";
        List<Equipment> equipments = new ArrayList<>();

        for(int i = 0; i < numberOfEquipment; i++) {
            for(int j = 0; j < 3; j++) {
                result += sc.nextLine();
                if(j < 2) {
                    result += "\n";
                }
            }
            if(result.endsWith("\n")) {
                result += "\n";
            }
            equipments.add(EquipmentFactory.readEquipment(result));
            result = "";
        }

        return equipments;
    }

    /**
     * Reads the strengths from the data
     * @param data the data from which we will read
     * @return a list of all strengths
     */
    public static List<String> readStrengths(String data) {
        Scanner sc = new Scanner(data);
        sc.useDelimiter(" - ");
        String item = "";
        List<String> strengths = new ArrayList<>();

        while(sc.hasNext()) {
            item = sc.next();

            if(item.contains("strength")) {
                item = item.replace("strength: ", "");
                strengths.add(item);
            }
        }

        return strengths;
    }

    /**
     * Reads the weaknesses from the data
     * @param data the data from which we will read
     * @return a list of all weaknesses
     */
    public static List<String> readWeaknesses(String data) {
        Scanner sc = new Scanner(data);
        sc.useDelimiter(" - ");
        String item = "";
        List<String> strengths = new ArrayList<>();

        while(sc.hasNext()) {
            item = sc.next();

            if(item.contains("weakness")) {
                item = item.replace("weakness: ", "");
                strengths.add(item);
            }
        }

        return strengths;
    }
}
