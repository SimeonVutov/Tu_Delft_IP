import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String prompt = """
            Please make your choice: 
            1 – Show all mechs in the system.
            2 – Show player stats & equipment.
            3 – Fight a mech.
            4 – Write current state to file.
            5 – Restore state from file.
            6 – Quit the application.
            """;
    private static List<Mech> mechs;
    private static List<Equipment> equipments;
    private static Player player;

    /**
     * Main method
     * @param args args
     * @throws FileNotFoundException file not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        String output = readFile(fileName);
        mechs = DataReader.readMechs(output);
        equipments = DataReader.readEquipments(output);
        player = new Player(new Stats(3, 1, 30, 3));

        int choice;
        do{
            System.out.println(prompt);
            choice = Integer.parseInt(sc.nextLine());
            logic(choice);
        } while(choice != 6);
    }

    /**
     * Method for handling the logic
     * @param choice the number the user chose
     */
    public static void logic(int choice) {
        switch (choice) {
            case 1:
                showAllMechs();
                break;
            case 2:
                showPlayerStatsAndEquipments();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Quit application");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void showPlayerStatsAndEquipments() {
        System.out.println("Player stats: \n");
        System.out.println(player.toString());

        System.out.println("Equipments: \n");
        for(var e : equipments) {
            System.out.println(e.toString());
        }
    }

    private static void showAllMechs() {
        for(var mech : mechs) {
            System.out.println(mech);
        }
    }

    /**
     * Get the file using the fileName and reads everything from it
     * @param fileName the name of file
     * @return a string of the content of the file
     * @throws FileNotFoundException file not found
     */
    public static String readFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        String output = "";
        while(sc.hasNextLine()) {
            output += sc.nextLine() + "\n";
        }

        return output.substring(0, output.length() - 1);
    }
}