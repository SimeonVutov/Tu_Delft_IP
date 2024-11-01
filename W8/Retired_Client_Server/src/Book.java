public class Book {

    private String title;
    private String author;

    /**
     * Creates a book.
     *
     * @param title The title
     * @param author The author
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Gets the title.
     *
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author.
     *
     * @return The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Checks whether this book is equal to another.
     *
     * @param other The other book
     * @return True iff both books have the same title and author
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) return false;
        Book that = (Book) other;
        return this.title.equals(that.title) && this.author.equals(that.author);
    }

    /**
     * Converts the book to a string.
     *
     * @return The string representation of this book
     */
    @Override
    public String toString() {
        return title + " by " + author;
    }
}
