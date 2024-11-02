import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static String prompt = "Please make your choice:  \n" +
            "1 – Show all balls currently in the machine. \n" +
            "2 – Show current chance to win the legendary prize. \n" +
            "3 – Draw a ball. \n" +
            "4 – Write debug output to file. \n" +
            "5 – Reset machine state. \n" +
            "6 – Quit the application.\n";
    private static String data;
    private static Machine machine;
    /**
     * Main
     * @param args args
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String filename = sc.nextLine();

        data = readFile(filename);
        machine = Machine.read(data);

        int choice;

        do{
            System.out.println(prompt);
            choice = Integer.parseInt(sc.nextLine());
            optionsLogic(choice);
        } while(choice != 6);
    }

    /**
     * Logic for selecting options
     * @param choice choice
     */
    public static void optionsLogic(int choice) {
        switch (choice) {
            case 1:
                System.out.println(machine.toString());
                break;
            case 2:
                System.out.println(machine.getChanceOfWinning() + "%");
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Quiting application...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }

    /**
     * Reads the file's contents
     * @param fileName name of File
     * @return data from file
     * @throws FileNotFoundException file not found
     */
    public static String readFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        String data = "";

        while(sc.hasNextLine()) {
            data += sc.nextLine() + "\n";
        }

        sc.close();
        return data.substring(0, data.length() - 1);
    }
}
