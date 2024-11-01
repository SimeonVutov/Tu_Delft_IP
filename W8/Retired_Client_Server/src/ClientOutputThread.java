import java.io.InputStream;
import java.util.Scanner;

public class ClientOutputThread extends Thread {

    private InputStream stream;

    /**
     * Creates an output thread.
     *
     * @param stream The stream to read output from
     */
    public ClientOutputThread(InputStream stream) {
        this.stream = stream;
    }

    /**
     * Continuously reads the input stream and prints the input.
     * Stops the programme if &quot;Goodbye&quot; is sent.
     */
    @Override
    public void run() {
        try (Scanner input = new Scanner(stream)) {
            while (input.hasNextLine()) {
                String response = input.nextLine();
                System.out.println(response);
                if (response.startsWith("Goodbye")) {
                    System.exit(0);
                }
            }
        }
    }
}
