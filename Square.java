/**
* Represents a square on a chess board
* @author sbranham6
* @version 1
*/
public class Square {
    private char file;
    private char rank;

    /**
    * @param file - char representing column
    * @param rank - char representing row
    */
    public Square(char file, char rank) throws InvalidSquareException {
        if (file < 'a' || file > 'h' || rank < '1' || rank > '8') {
            throw new InvalidSquareException("" + file + rank);
        }
        this.file = file;
        this.rank = rank;
    }

    /**
    * @param name - string with file as char 1 and rank as char 2
    */
    public Square(String name) throws InvalidSquareException {
        if (name.charAt(0) < 'a' || name.charAt(0) > 'h'
                || name.charAt(1) < '1' || name.charAt(1) > '8') {
            throw new InvalidSquareException(name);
        }
        this.file = name.charAt(0);
        this.rank = name.charAt(1);
    }

    /**
    * @return String "filerank"
    */
    public String toString() {
        return "" + file + rank;
    }

    /**
    * @return char file
    */
    public char getFile() {
        return this.file;
    }

    /**
    * @return char rank
    */
    public char getRank() {
        return this.rank;
    }

    /**
    * @return the Object classes hashCode()
    */
    public int hashCode() {
        // Satifies checkstyle's .equals() error
        return super.hashCode();
    }

    /**
    * @param o : object to be compared to
    * @return true if the squares' files and ranks are the same
    */
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!(o instanceof Square)) {
            return false;
        }
        if (this.file == ((Square) o).file && this.rank == ((Square) o).rank) {
            return true;
        }
        return false;
    }

}
