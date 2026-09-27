import java.util.ArrayList;
import java.util.List;

/**
 * BookManager.java
 * Handles all CRUD operations for books.
 * Uses ArrayList to store books in memory.
 */
public class BookManager {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    /**
     * CREATE - Add a new book to the inventory.
     * Validates input before adding.
     */
    public void addBook(String title, String author, String isbn, int year) {
        // Input validation
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty.");
        }
        if (year < 1000 || year > 2100) {
            throw new IllegalArgumentException("Publication year must be between 1000 and 2100.");
        }

        Book book = new Book(nextId++, title.trim(), author.trim(), isbn.trim(), year);
        books.add(book);
        System.out.println("✅ Book added successfully with ID: " + book.getId());
    }

    /**
     * READ - List all books in the inventory.
     */
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 No books in inventory yet.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    /**
     * READ - Find a book by ID.
     */
    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    /**
     * UPDATE - Update book details by ID.
     */
    public void updateBook(int id, String newTitle, String newAuthor,
                           String newIsbn, int newYear) {
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("❌ Book with ID " + id + " not found.");
            return;
        }
        if (newTitle != null && !newTitle.trim().isEmpty()) book.setTitle(newTitle.trim());
        if (newAuthor != null && !newAuthor.trim().isEmpty()) book.setAuthor(newAuthor.trim());
        if (newIsbn != null && !newIsbn.trim().isEmpty()) book.setIsbn(newIsbn.trim());
        if (newYear >= 1000 && newYear <= 2100) book.setPublicationYear(newYear);
        System.out.println("✅ Book updated successfully.");
    }

    /**
     * DELETE - Remove a book by ID.
     */
    public void deleteBook(int id) {
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("❌ Book with ID " + id + " not found.");
            return;
        }
        books.remove(book);
        System.out.println("✅ Book deleted successfully.");
    }
}