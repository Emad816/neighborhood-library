package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibraryApp {

    public static Book[] inventory = buildInventory();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the Neighborhood Library!");
        boolean running = true;

        while (running) {
            showHomeScreen();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    showAvailableBooks();
                    break;
                case "2":
                    showCheckedOutBooks();
                    break;
                case "3":
                    running = false;
                    System.out.println("Thanks for visiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    //display home screen
    private static void showHomeScreen() {
        System.out.println();
        System.out.println("===== HOME =====");
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Exit");
        System.out.print("Enter your choice: ");
    }

    //Runs a loop to check available books and display them
    private static void showAvailableBooks() {
        System.out.println();
        System.out.println("===== AVAILABLE BOOKS =====");

        boolean anyAvailable = false;
        for (Book book : inventory) {
            if (!book.isCheckedOut()) {
                anyAvailable = true;
                System.out.printf("Id: %-3d ISBN: %-15s Title: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle());
            }
        }

        if (!anyAvailable) {
            System.out.println("All books are currently checked out.");
            return;
        }
        System.out.print("\nEnter a book Id to check out, or 0 to go back home: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //clears leftover
        if (id == 0) {
            return;
        }
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("No book found with Id " + id + ".");
        } else if (book.isCheckedOut()) {
            System.out.println("Sorry, \"" + book.getTitle() + "\" is already checked out.");
        } else {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("A name is required to check out a book.");
                return;
            }
            book.checkOut(name);
            System.out.println("Enjoy \"" + book.getTitle() + "\", " + name + "!");
        }
    }

    private static void showCheckedOutBooks() {
        System.out.println();
        System.out.println("===== CHECKED OUT BOOKS =====");

        boolean anyCheckedOut = false;
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                anyCheckedOut = true;
                System.out.printf("Id: %-3d ISBN: %-15s Title: %-40s Checked out to: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
            }
        }
        if (!anyCheckedOut) {
            System.out.println("No books are currently checked out.");
            return;
        }
        System.out.print("\nC - Check In a book\nX - Go back to the home screen\nEnter your choice: ");
        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("C")) {
            checkInBook();
        } else if (!choice.equalsIgnoreCase("X")) {
            System.out.println("Invalid choice. Returning to the home screen.");
        }
    }

    private static void checkInBook() {
        System.out.print("Enter the Id of the book to check in: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //clears leftover

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("No book found with Id " + id + ".");
        } else if (!book.isCheckedOut()) {
            System.out.println("\"" + book.getTitle() + "\" is not checked out.");
        } else {
            book.checkIn();
            System.out.println("\"" + book.getTitle() + "\" has been checked in. Thank you!");
        }
    }

    //finds a book by id
    private static Book findBookById(int id) {
        for (Book book : inventory) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    //Methode to build library inventory
    private static Book[] buildInventory() {
        return new Book[]{
                new Book(1, "9780743273565", "The Great Gatsby"),
                new Book(2, "9780061120084", "To Kill a Mockingbird"),
                new Book(3, "9780451524935", "1984"),
                new Book(4, "9780141439518", "Pride and Prejudice"),
                new Book(5, "9780316769488", "The Catcher in the Rye"),
                new Book(6, "9780547928227", "The Hobbit"),
                new Book(7, "9780439708180", "Harry Potter and the Sorcerer's Stone"),
                new Book(8, "9780060850524", "Brave New World"),
                new Book(9, "9780142437247", "Moby-Dick"),
                new Book(10, "9780140449266", "The Count of Monte Cristo"),
                new Book(11, "9780486280615", "Adventures of Huckleberry Finn"),
                new Book(12, "9780375706677", "Beloved"),
                new Book(13, "9780062315007", "The Alchemist"),
                new Book(14, "9780385490818", "The Handmaid's Tale"),
                new Book(15, "9780743247221", "The Kite Runner"),
                new Book(16, "9780679723165", "Invisible Man"),
                new Book(17, "9780142437230", "Don Quixote"),
                new Book(18, "9780156012195", "The Little Prince"),
                new Book(19, "9780553213690", "Frankenstein"),
                new Book(20, "9780140177398", "Of Mice and Men"),
                new Book(21, "9780679783275", "Crime and Punishment")
        };
    }
}
