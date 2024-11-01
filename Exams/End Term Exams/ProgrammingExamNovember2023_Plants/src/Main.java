import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static String prompt = """
            Please make your choice:
            1 – Show plants that meet all criteria.
            2 – Filter plants by size.
            3 – Filter plants by flower colour.
            4 - Filter plants by edibility.
            5 – Reset all criteria.
            6 – Simulate global warming.
            7 – Quit the application.
            """;
    private static PlantCollection plantCollection;

    /**
     * Main
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of file: ");
        String filename = sc.nextLine();
        Scanner fileScanner = new Scanner(new File(filename));

        String data = readFile(fileScanner);

        plantCollection = new PlantCollection(
                plantCollection.readPlants(data)
        );


        do {
            System.out.println(prompt);
            choice = Integer.parseInt(sc.nextLine());

            logic(choice);
        } while(choice != 7);

        fileScanner.close();
    }

    /**
     * Reads the data from the file
     * @param fileScanner
     * @return string from the data of the file
     */
    public static String readFile(Scanner fileScanner) {
        String result = "";

        while(fileScanner.hasNextLine()) {
            result += fileScanner.nextLine() + "\n";
        }

        return result.substring(0, result.length() - 1);
    }

    /**
     * Logic for ui
     * @param choice
     */
    public static void logic(int choice) {
        switch (choice) {
            case 1:
                // Fix
                System.out.println(plantCollection.toString());
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                plantCollection.resetFilters();
                break;
            case 6:
                break;
        }
    }
}