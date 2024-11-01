import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataProcessingApplication {

    private static int numbersRead = 0;
    private static final int TOTAL_NUMBERS = 10_000_000;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        ProgressBarThread progressBarThread = new ProgressBarThread();
        progressBarThread.start();
        try (Scanner sc = new Scanner(new File("resources/numbers.txt"))) {
            while (numbersRead < TOTAL_NUMBERS) {
                numbers.add(sc.nextInt());
                numbersRead++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long total = 0;
        for (int n : numbers) total += n;
        try {
            // Ensure last progress bar is printed before the total is printed
            progressBarThread.join();
        } catch (InterruptedException e) {}
        System.out.println("Total: " + total);
    }

    public static int getTotalNumbers() {
        return TOTAL_NUMBERS;
    }

    public static int getNumbersRead() {
        return numbersRead;
    }
}
