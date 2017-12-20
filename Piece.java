/**
* Abstract class representing a chess piece.
* @author sbranham6
*/
public abstract class Piece {
    private Color color;

    /**
    * Creates a chess piece
    * @param color white/black, define in Color enum
    */
    public Piece(Color color) {
        this.color = color;
    }

    /**
    * Returns the color of a piece
    * @return color from Color enum
    */
    public Color getColor() {
        return color;
    }

    public boolean isInBoard(char file, char rank) {
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
    }

    /**
    * Returns the algebraic name of a piece
    * @return String representation of algebraic name
    */
    public abstract String algebraicName();

    /**
    * Returns fen name of a piece
    * @return String representation of FEN name
    */
    public abstract String fenName();

    /**
    * Finds all locations a piece could have moved from depending on where it is
    * @param square an object representing a piece's location on the board
    * @return an array of Squares with where a piece could have moved from
    */
    public abstract Square[] movesFrom(Square square);

}
