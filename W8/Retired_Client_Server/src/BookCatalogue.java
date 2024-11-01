import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookCatalogue {

    private List<Book> availableBooks;
    private Map<String, Book> lentBooks;

    /**
     * Creates an empty book catalogue.
     */
    public BookCatalogue() {
        this.availableBooks = new ArrayList<>();
        this.lentBooks = new HashMap<>();
    }

    /**
     * Adds a book to the catalogue.
     *
     * @param book The book to add
     */
    public void addBook(Book book) {
        availableBooks.add(book);
    }

    /**
     * Gets all available books.
     *
     * @return A list of all available books
     */
    public List<Book> getAllAvailableBooks() {
        return List.copyOf(availableBooks);
    }

    /**
     * Lends a book to a person.
     *
     * @param title The title of the book
     * @param person The name of the person
     */
    public void lendBookTo(String title, String person) {
        if (lentBooks.containsKey(person)) throw new IllegalArgumentException("You already have a book");
        Book found = null;
        for (Book book : availableBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                found = book;
                break;
            }
        }
        if (found == null) throw new IllegalArgumentException("Book is not available");
        availableBooks.remove(found);
        lentBooks.put(person, found);
    }

    /**
     * Returns the book for a person.
     *
     * @param person The person
     * @return The book that was returned
     */
    public Book returnBook(String person) {
        if (!lentBooks.containsKey(person)) throw new IllegalArgumentException("You do not have a book");
        Book book = lentBooks.get(person);
        availableBooks.add(book);
        lentBooks.remove(person);
        return book;
    }

}
