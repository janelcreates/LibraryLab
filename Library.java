import java.util.*;

public class Library {
    // Add the missing implementation to this class
	private String address;
	ArrayList<Book> books;
	
	public Library(String libAddress) {
		this.address = libAddress;
		this.books = new ArrayList<Book>();
	}
	
	public void addBook(Book newBook) {
		this.books.add(newBook);
	}
	
	public static void printOpeningHours() {
		System.out.println("Libraries are open from 9 AM to 5 PM.");
	}
	
	public void printAddress() {
		System.out.println(this.address);
	}
	
	public void borrowBook(String title) {
		for(Book newBook:this.books) {
			if (title.equals(newBook.getTitle())) {
				if (newBook.isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
					return;
				}
				else {
					newBook.borrowed();
					System.out.println("You successfully borrowed " + newBook.getTitle() + ".");
					return;
				}	
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	public void printAvailableBooks() {
		if (this.books.isEmpty()) {
			System.out.println("No book in catalog.");
		} 
		for (Book newBook:this.books) {
			System.out.println(newBook.getTitle());
		}
	}
	
	public void returnBook(String title) {
		for (Book newBook: this.books) {
			if (title.equals(newBook.getTitle())) {
				newBook.returned();
				System.out.println("You successfully returned " + newBook.getTitle());
			}
		}
	}
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
