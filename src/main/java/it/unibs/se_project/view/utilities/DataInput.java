package it.unibs.se_project.view.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class provides methods for input handling.
 */
public class DataInput {
	private static final Scanner reader = createScanner();

	private static final String FORMAT_ERROR = "Il dato inserito non e' nel formato corretto.";
	private static final String MINIMUM_ERROR = "E' richiesto un valore maggiore a ";
	private static final String EMPTY_STRING_ERROR = "Non hai inserito alcun carattere.";
	private static final String ALLOWED_CHARS = "I caratteri ammissibili sono: ";
	private static final char YES = 'S';
	private static final char NO = 'N';
	private static final char DOT = '.';


    private DataInput() {
        // private constructor to prevent instantiation
    }

    /**
     * Creates a Scanner instance for reading user input.
     *
     * @return the created Scanner instance
     */
	private static Scanner createScanner() {
        return new Scanner(System.in).useDelimiter(System.lineSeparator() + "|\n");
	}

    /**
     * Reads a string from the user.
     *
     * @param message the message to display before reading the input
     * @return the string entered by the user
     */
	public static String readString(String message) {
		System.out.print(message);
		return reader.next();
	}

    /**
     * Reads a non-empty string from the user.
     *
     * @param message the message to display before reading the input
     * @return the non-empty string entered by the user
     */
	public static String readNotEmptyString(String message) {
		String read;

		do {
			read = readString(message).trim();
			if (read.isEmpty()) {
				System.out.println(EMPTY_STRING_ERROR);
			}
		} while(read.isEmpty());

		return read;
	}

    /**
     * Reads a character from the user.
     *
     * @param message the message to display before reading the input
     * @return the character entered by the user
     */
	public static char readChar(String message) {
		char readValue;

        do {
            System.out.print(message);
            String reading = reader.next();
            if (!reading.isEmpty()) {
                readValue = reading.charAt(0);
            } else {
                System.out.println(EMPTY_STRING_ERROR);
                readValue = '\0'; // Assigning null character for invalid input
            }
        } while (readValue == '\0');

        return readValue;
	}

    /**
     * Reads an uppercase character from the user.
     *
     * @param read    the message to display before reading the input
     * @param allowed the allowed characters as a string
     * @return the uppercase character entered by the user
     */
	public static char readUpperChar(String read, String allowed) {
		char readValue;
        
        do {
            readValue = Character.toUpperCase(readChar(read));
            if (allowed.indexOf(readValue) == -1) {
                System.out.println(ALLOWED_CHARS + allowed + DOT);
            }
        } while (allowed.indexOf(readValue) == -1);

        return readValue;
	}

    /**
     * Reads an integer from the user.
     *
     * @param message the message to display before reading the input
     * @return the integer entered by the user
     */
	public static int readInt(String message) {
        int readValue;
        
        do {
            System.out.print(message);

            try {
                readValue = reader.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println(FORMAT_ERROR);
                reader.next(); // Clear the invalid input
            }
        } while (true);

        return readValue;
    }

	/**
     * Reads a positive integer from the user.
     *
     * @param message the message to display before reading the input
     * @return the positive integer entered by the user
     */
    public static int readPositiveInt(String message) {
        return readIntWithMinimum(message, 1);
    }

	/**
     * Reads a non-negative integer from the user.
     *
     * @param message the message to display before reading the input
     * @return the non-negative integer entered by the user
     */
    public static int readNonNegativeInt(String message) {
        return readIntWithMinimum(message, 0);
    }

	/**
     * Reads an integer with a minimum value from the user.
     *
     * @param message the message to display before reading the input
     * @param minimum the minimum allowed value
     * @return the integer entered by the user
     */
    public static int readIntWithMinimum(String message, int minimum) {
        int readValue;
        do {
            readValue = readInt(message);
            if (readValue < minimum) {
                System.out.println(MINIMUM_ERROR + minimum + DOT);
            }
        } while (readValue < minimum);

        return readValue;
    }

	/**
     * Reads a double from the user.
     *
     * @param message the message to display before reading the input
     * @return the double entered by the user
     */
    public static double readDouble(String message) {
        double readValue;
        do {
            System.out.print(message);

            try {
                readValue = reader.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println(FORMAT_ERROR);
                reader.next(); // Clear the invalid input
            }
        } while (true);

        return readValue;
    }

	/**
     * Reads a positive double from the user.
     *
     * @param message the message to display before reading the input
     * @return the positive double entered by the user
     */
    public static double readPositiveDouble(String message) {
        return readDoubleWithMinimum(message, 0.0);
    }

	/**
     * Reads a double with a minimum value from the user.
     *
     * @param message the message to display before reading the input
     * @param minimum the minimum allowed value
     * @return the double entered by the user
     */
    public static double readDoubleWithMinimum(String message, double minimum) {
        double readValue;
        do {
            readValue = readDouble(message);
            if (readValue <= minimum) {
                System.out.println(MINIMUM_ERROR + minimum + DOT);
            }
        } while (readValue <= minimum);

        return readValue;
    }

	/**
     * Prompts the user with a yes or no question and reads the response.
     *
     * @param message the message to display before reading the input
     * @return true if the user responds with "Y" (yes), false if the user responds with "N" (no)
     */
    public static boolean yesOrNo(String message) {
        String myMessage = message + " (" + YES + "/" + NO + ")";
        char readValue = readUpperChar(myMessage, String.valueOf(YES) + String.valueOf(NO));
        return readValue == YES;
    }
}
