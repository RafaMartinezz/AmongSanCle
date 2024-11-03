package Logica;

import java.util.Scanner;

/**
 * SingletonScanner provides a single, shared instance of a {@link Scanner}
 * object
 * to read user input throughout the application, following the Singleton design
 * pattern.
 * This approach prevents the creation of multiple {@link Scanner} instances
 * tied to
 * {@code System.in}, avoiding potential input conflicts.
 */
public final class SingletonScanner {

    /** Private static instance of SingletonScanner (Singleton pattern) */
    private static SingletonScanner instance;

    /** Private Scanner object for user input */
    private Scanner scanner;

    /**
     * Private constructor to prevent external instantiation.
     * Initializes the Scanner for reading from standard input.
     */
    private SingletonScanner() {
        scanner = new Scanner(System.in);
    }

    /**
     * Returns the single instance of SingletonScanner, creating it if it does not
     * already exist.
     *
     * @return the unique SingletonScanner instance
     */
    public static SingletonScanner getInstance() {
        if (instance == null) {
            instance = new SingletonScanner();
        }
        return instance;
    }

    /**
     * Reads a line of text input from the user.
     *
     * @return the line of text entered by the user
     */
    public String nextLine() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer input from the user.
     *
     * @return the integer entered by the user
     */
    public int nextInt() {
        return scanner.nextInt();
    }

    /**
     * Reads the next word or token input from the user.
     *
     * @return the word or token entered by the user
     */
    public String next() {
        return scanner.next();
    }
}
