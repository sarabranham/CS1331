/**
* Represents a knight
* @author sbranham6
*/
public class Knight extends Piece {
    /**
    * Constructs a knight with a color from the Color enum
    */
    public Knight(Color color) {
        super(color);
    }

    /**
    * @return "N", algebraic name of Knight
    */
    public String algebraicName() {
        return "N";
    }

    /**
    * @return String "N" or "n", depending on color
    */
    public String fenName() {
        return (this.getColor().equals(Color.WHITE)) ? "N" : "n";
    }

    /**
    * Finds all locations a knight could've moved from depending on where it is
    * @param square an object representing a piece's location on the board
    * @return an array of Squares with where a knight could have moved from
    */
    @Override
    public Square[] movesFrom(Square square) {
        Square[] moves = new Square[8];
        int c = 0;
        if ((char) (square.getFile() + 2) <= 'h') {
            if ((char) (square.getRank() + 1) <= '8') {
                moves[c] = new Square((char) (square.getFile() + 2),
                                      (char) (square.getRank() + 1));
                c++;
            }
            if ((char) (square.getRank() - 1) >= '1') {
                moves[c] = new Square((char) (square.getFile() + 2),
                                      (char) (square.getRank() - 1));
                c++;
            }
        }
        if ((char) (square.getFile() - 2) >= 'a') {
            if ((char) (square.getRank() + 1) <= '8') {
                moves[c] = new Square((char) (square.getFile() - 2),
                                      (char) (square.getRank() + 1));
                c++;
            }
            if ((char) (square.getRank() - 1) >= '1') {
                moves[c] = new Square((char) (square.getFile() - 2),
                                      (char) (square.getRank() - 1));
                c++;
            }
        }
        if ((char) (square.getRank() + 2) <= '8') {
            if ((char) (square.getFile() + 1) <= 'h') {
                moves[c] = new Square((char) (square.getFile() + 1),
                                      (char) (square.getRank() + 2));
                c++;
            }
            if ((char) (square.getFile() - 1) >= 'a') {
                moves[c] = new Square((char) (square.getFile() - 1),
                                      (char) (square.getRank() + 2));
                c++;
            }
        }
        if ((char) (square.getRank() - 2) >= '1') {
            if ((char) (square.getFile() + 1) <= 'h') {
                moves[c] = new Square((char) (square.getFile() + 1),
                                      (char) (square.getRank() - 2));
                c++;
            }
            if ((char) (square.getFile() - 1) >= 'a') {
                moves[c] = new Square((char) (square.getFile() - 1),
                                      (char) (square.getRank() - 2));
                c++;
            }
        }
        Square[] finalMoves = new Square[c];
        for (int i = 0; i < c; i++) {
            finalMoves[i] = moves[i];
        }
        return finalMoves;
    }

}
