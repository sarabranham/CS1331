/**
* Represents a king
* @author sbranham6
*/
public class King extends Piece {
    /**
    * Constructs a king with a color from the Color enum
    */
    public King(Color color) {
        super(color);
    }

    /**
    * @return "K", algebraic name of King
    */
    public String algebraicName() {
        return "K";
    }

    /**
    * @return String "K" or "k", depending on color
    */
    public String fenName() {
        return (this.getColor().equals(Color.WHITE)) ? "K" : "k";
    }

    /**
    * Finds all locations a king could've moved from depending on where it is
    * @param square an object representing a piece's location on the board
    * @return an array of Squares with where a king could have moved from
    */
    public Square[] movesFrom(Square square) {
        Square[] moves = new Square[8];
        int c = 0;
        if ((char) (square.getFile() + 1) <= 'h') {
            moves[c] = new Square((char) (square.getFile() + 1),
                                          square.getRank());
            c++;
            if ((char) (square.getRank() + 1) <= '8') {
                moves[c] = new Square((char) (square.getFile() + 1),
                                      (char) (square.getRank() + 1));
                c++;
            }
            if ((char) (square.getRank() - 1) >= '1') {
                moves[c] = new Square((char) (square.getFile() + 1),
                                      (char) (square.getRank() - 1));
                c++;
            }
        }
        if ((char) (square.getFile() - 1) >= 'a') {
            moves[c] = new Square((char) (square.getFile() - 1),
                                          square.getRank());
            c++;
            if ((char) (square.getRank() + 1) <= '8') {
                moves[c] = new Square((char) (square.getFile() - 1),
                                      (char) (square.getRank() + 1));
                c++;
            }
            if ((char) (square.getRank() - 1) >= '1') {
                moves[c] = new Square((char) (square.getFile() - 1),
                                      (char) (square.getRank() - 1));
                c++;
            }
        }
        if ((char) (square.getRank() + 1) <= '8') {
            moves[c] = new Square(square.getFile(),
                                  (char) (square.getRank() + 1));
            c++;
        }
        if ((char) (square.getRank() - 1) >= '1') {
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
