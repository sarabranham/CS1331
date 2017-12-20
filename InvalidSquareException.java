/**
* Exception to detect when a square is outside of the board
* @author sbranham6
* @version 1
*/
public class InvalidSquareException extends RuntimeException {
    // InvalidSquareException should be a checked exception because
    // declaring an invalid square is a recoverable condition, and the user
    // should be able to redefine the square. Having a checked exception will
    // also be beneficial later on, because if a user tries to move a piece to
    // an invalid square, the program will throw the error at compile time,
    // making errors like this easier to rectify.

    private String msg;

    /**
    * @param message - message containing rank and file of square
    */
    public InvalidSquareException(String message) {
        super(message);
    }

}
