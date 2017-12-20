/**
* Represents a rook
* @author sbranham6
*/
public class Rook extends Piece {
    /**
    * Constructs a rook with a color from the Color enum
    */
    public Rook(Color color) {
        super(color);
    }

    /**
    * @return "R", algebraic name of King
    */
    public String algebraicName() {
        return "R";
    }

    /**
    * @return String "R" or "r", depending on color
    */
    public String fenName() {
        return (this.getColor().equals(Color.WHITE)) ? "R" : "r";
    }

    /**
    * Finds all locations a rook could've moved from depending on where it is
    * @param square an object representing a piece's location on the board
    * @return an array of Squares with where a rook could have moved from
    */
    @Override
    public Square[] movesFrom(Square square) {
        Square[] moves = new Square[14];
        int c = 0;
        int i = 1;
        while ((char) (square.getFile() + i) <= 'h') {
            moves[c] = new Square((char) (square.getFile() + i),
                                square.getRank());
            c++;
            i++;
        }
        i = 1;
        while ((char) (square.getFile() - i) >= 'a') {
            moves[c] = new Square((char) (square.getFile() - i),
                                square.getRank());
            c++;
            i++;
        }
        i = 1;
        while ((char) (square.getRank() + i) <= '8') {
            moves[c] = new Square(square.getFile(),
                    (char) (square.getRank() + i));
            c++;
            i++;
        }
        i = 1;
        while ((char) (square.getRank() - i) >= '1') {
            moves[c] = new Square(square.getFile(),
                    (char) (square.getRank() - i));
            c++;
            i++;
        }
        return moves;
    }

}
