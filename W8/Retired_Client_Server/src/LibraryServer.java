import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LibraryServer {

    public static final int PORT = 8080;

    /**
     * Waits for incoming connections and starts a thread for every client.
     */
    public static void main(String[] args) {
        BookCatalogue catalogue = loadBooks();
        try (ServerSocket socket = new ServerSocket(PORT)) {
            while (true) {
                Socket client = socket.accept();
                new LibraryThread(client, catalogue).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a catalogue with some sample books.
     *
     * @return The created catalogue
     */
    private static BookCatalogue loadBooks() {
        BookCatalogue catalogue = new BookCatalogue();
        catalogue.addBook(new Book("1984", "George Orwell"));
        catalogue.addBook(new Book("A Game of Thrones", "George R.R. Martin"));
        catalogue.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling"));
        catalogue.addBook(new Book("Frankenstein", "Mary Shelley"));
        catalogue.addBook(new Book("The Bell Jar", "Sylvia Plath"));
        return catalogue;
    }

}
