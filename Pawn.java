/**
* Represents a Pawn
* @author sbranham6
*/
public class Pawn extends Piece {
    /**
    * Constructs a pawn with a color from the Color enum
    */
    public Pawn(Color color) {
        super(color);
    }

    /**
    * @return "", algebraic name of Pawn
    */
    public String algebraicName() {
        return "";
    }

    /**
    * @return String "P" or "p", depending on color
    */
    public String fenName() {
        return (this.getColor().equals(Color.WHITE)) ? "P" : "p";
    }

    /**
    * Finds all locations a pawn could've moved from depending on where it is
    * @param square an object representing a piece's location on the board
    * @return an array of Squares with where a pawn could have moved from
    */
    public Square[] movesFrom(Square square) {
        Square[] moves = new Square[2];
        int c = 0;
        int dir = (this.getColor().equals(Color.WHITE)) ? 1 : -1;
        if ((this.getColor().equals(Color.WHITE) && square.getRank() == '2')
                || (this.getColor().equals(Color.BLACK) && square.getRank()
                        == '7')) {
            moves[c] = new Square(square.getFile(),
                    (char) (square.getRank() + dir * 2));
            c++;
        }
        if (this.getColor().equals(Color.WHITE)
                && (char) (square.getRank() + 1) <= '8') {
            moves[c] = new Square(square.getFile(),
                    (char) (square.getRank() + 1));
            c++;
        }
        if (this.getColor().equals(Color.BLACK)
                && (char) (square.getRank() - 1) >= '1') {
            moves[c] = new Square(square.getFile(),
                    (char) (square.getRank() - 1));
            c++;
        }
        Square[] finalMoves = new Square[c];
        for (int i = 0; i < c; i++) {
            finalMoves[i] = moves[i];
        }
        return finalMoves;
    }

}
