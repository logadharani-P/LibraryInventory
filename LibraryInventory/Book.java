/**
 * Book.java
 * Represents a single book in the library inventory.
 * This is the "Model" class that holds book data.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    // Constructor
    public Book(int id, String title, String author, String isbn, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublicationYear() { return publicationYear; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    // Display book details in a readable format
    @Override
    public String toString() {
        return "ID: " + id +
               " | Title: " + title +
               " | Author: " + author +
               " | ISBN: " + isbn +
               " | Year: " + publicationYear;
    }
}