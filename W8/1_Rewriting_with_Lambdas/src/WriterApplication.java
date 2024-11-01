import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterApplication {

    /**
     * Asks the user for input and asynchronously writes the user's input to file.
     */
    public static void main(String[] args) {

        List<String> toWrite = new ArrayList<>();
        toWrite.add("The user put in:");

        Scanner scanner = new Scanner(System.in);
        System.out.println("What to write?");
        toWrite.add(scanner.nextLine());
        scanner.close();

        // Anonymous class
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                writeToFile(toWrite);
//            }
//        });

        // Lambda
        Thread thread = new Thread(() -> writeToFile(toWrite));

        thread.start();
        System.out.println("Writing...");

    }

    private static void writeToFile(List<String> dataToWrite) {
        File file = new File("output.txt");

        try {

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for (String line : dataToWrite) {
                writer.println(line);
            }
            writer.close();

        } catch (IOException e) {
            System.err.println("Writing failed");
            e.printStackTrace();
        }
    }

}
