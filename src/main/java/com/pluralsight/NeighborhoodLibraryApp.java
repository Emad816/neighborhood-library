package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibraryApp {

    public static Book[] inventory = buildInventory();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the Neighborhood Library!");
        boolean running = true;








    }

    private static void showHomeScreen() {
        System.out.println();
        System.out.println("===== HOME =====");
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Exit");
        System.out.print("Enter your choice: ");
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
