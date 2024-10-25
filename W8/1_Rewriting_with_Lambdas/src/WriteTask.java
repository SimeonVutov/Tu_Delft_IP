import java.io.*;
import java.util.List;

public class WriteTask implements Runnable {

    private List<String> dataToWrite;

    /**
     * Creates a writer task.
     *
     * @param dataToWrite The data to be written
     */
    public WriteTask(List<String> dataToWrite) {
        this.dataToWrite = dataToWrite;
    }

    /**
     * Writes the data to output.txt.
     */
    @Override
    public void run() {
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
