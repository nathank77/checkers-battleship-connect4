package Checkers;

/**
 * SquareOccupiedException.java
 * Description: Contains the methods for the extension of the Exception class for our SquareOccupiedException
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/

public class SquareOccupiedException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SquareOccupiedException() {
        super();
    }

    public SquareOccupiedException(String message) {
        super(message);
    }

    public SquareOccupiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SquareOccupiedException(Throwable cause) {
        super(cause);
    }

}
