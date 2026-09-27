import java.util.Scanner;

/**
 * LibraryApp.java
 * Main entry point - provides a menu-driven command-line interface.
 */
public class LibraryApp {

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("========================================");
        System.out.println("   LIBRARY BOOK INVENTORY SYSTEM");
        System.out.println("========================================");

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1: // Add book
                    try {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        int year = readInt(scanner, "Enter publication year: ");
                        manager.addBook(title, author, isbn, year);
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 2: // List all books
                    manager.listAllBooks();
                    break;

                case 3: // Update book
                    int updateId = readInt(scanner, "Enter book ID to update: ");
                    System.out.print("Enter new title (leave blank to skip): ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author (leave blank to skip): ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new ISBN (leave blank to skip): ");
                    String newIsbn = scanner.nextLine();
                    int newYear = readInt(scanner, "Enter new year (0 to skip): ");
                    manager.updateBook(updateId, newTitle, newAuthor, newIsbn, newYear);
                    break;

                case 4: // Delete book
                    int deleteId = readInt(scanner, "Enter book ID to delete: ");
                    manager.deleteBook(deleteId);
                    break;

                case 5: // Exit
                    running = false;
                    System.out.println("👋 Thank you! Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    /** Prints the main menu. */
    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add Book");
        System.out.println("2. List All Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Exit");
    }

    /** Safely reads an integer from the user. */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
    }
}