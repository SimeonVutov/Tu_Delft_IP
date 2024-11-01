import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class LibraryThread extends Thread {

    private Socket socket;
    private BookCatalogue catalogue;

    /**
     * Creates a library thread.
     *
     * @param socket The socket to read from and write to
     * @param catalogue The catalogue with books
     */
    public LibraryThread(Socket socket, BookCatalogue catalogue) {
        this.socket = socket;
        this.catalogue = catalogue;
    }

    /**
     * Handles the interaction with the client and performs the requested actions.
     */
    @Override
    public void run() {
        try (Scanner input = new Scanner(socket.getInputStream());
             PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            output.println("What is your name: ");
            String name = input.nextLine();

            int option;
            do {
                printMenu(output);
                option = Integer.parseInt(input.nextLine());
                try {
                    executeOption(input, output, name, option);
                } catch (IllegalArgumentException e) {
                    output.println(e.getMessage());
                }
            } while (option != 4);

            output.println("Goodbye!");
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the menu.
     *
     * @param output The output to print to
     */
    private void printMenu(PrintWriter output) {
        output.println("Please enter an option:");
        output.println("  1 - Lend a book");
        output.println("  2 - Return your lent book");
        output.println("  3 - See all available books");
        output.println("  4 - Leave the library");
    }

    /**
     * Executes an option.
     *
     * @param input The input to read from
     * @param output The output to write to
     * @param name The name of the user
     * @param option The option to execute
     */
    private void executeOption(Scanner input, PrintWriter output, String name, int option) {
        switch (option) {
            case 1:
                output.println("What book would you like to lend?");
                catalogue.lendBookTo(input.nextLine(), name);
                break;
            case 2:
                Book returned = catalogue.returnBook(name);
                output.println(returned + " returned");
                break;
            case 3:
                for (Book book : catalogue.getAllAvailableBooks()) {
                    output.println(book);
                }
        }
    }

}
