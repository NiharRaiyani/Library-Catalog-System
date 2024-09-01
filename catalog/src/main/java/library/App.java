package library;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("Library Catalog System");
            System.out.println("1. Add a new book");
            System.out.println("2. Search books");
            System.out.println("3. List all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();

                    Book book = new Book(title, author, isbn, year);
                    bookDAO.addBook(book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter title or author to search: ");
                    String keyword = scanner.nextLine();
                    List<Book> searchResults = bookDAO.searchBooks(keyword);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book b : searchResults) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    List<Book> books = bookDAO.listAllBooks();
                    for (Book b : books) {
                        System.out.println(b);
                    }
                    break;

                case 4:
                    System.out.println("");
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
