import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class LibraryClient {

    public static final String HOST = "localhost";
    public static final int PORT = 8080;

    /**
     * Opens a socket, sends console input to the server, and prints responses to the console.
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        try (Socket socket = new Socket(HOST, PORT)) {
            new ClientOutputThread(socket.getInputStream()).start();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            while (userInput.hasNextLine()) {
                writer.println(userInput.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
