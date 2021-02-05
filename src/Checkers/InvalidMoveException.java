package Checkers;

/**
 * InvalidMoveException.java
 * Description: Contains the methods for the extension of the Exception class for our InvalidMoveException
 *
 * @author Ethan Shama and Nathan Kowal
 * @version 1.0 (Last Updated: Jan 12 2019)
 **/


public class InvalidMoveException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidMoveException() {
        super();
    }

    public InvalidMoveException(String message) {
        super(message);
    }

    public InvalidMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMoveException(Throwable cause) {
        super(cause);
    }
}
