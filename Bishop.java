/**
* Represents a bishop
* @author sbranham6
*/
public class Bishop extends Piece {
    /**
    * Constructs a bishop with a color from the Color enum
    */
    public Bishop(Color color) {
        super(color);
    }

    /**
    * @return "B", algebraic name of Bishop
    */
    public String algebraicName() {
        return "B";
    }

    /**
    * @return String "B" or "b", depending on color
    */
    public String fenName() {
        return (this.getColor().equals(Color.WHITE)) ? "B" : "b";
    }

    /**
    * Finds all locations a bishop could've moved from depending on where it is
    * @param square an object representing a piece's location on the board
    * @return an array of Squares with where a bishop could have moved from
    */
    public Square[] movesFrom(Square square) {
        Square[] moves = new Square[14];
        int c = 0;
        int i = 1;
        while ((char) (square.getFile() + i) <= 'h'
                && (char) (square.getRank() + i) <= '8') {
            moves[c] = new Square((char) (square.getFile() + i),
                                  (char) (square.getRank() + i));
            c++;
            i++;
        }
        i = 1;
        while ((char) (square.getFile() + i) <= 'h'
                && (char) (square.getRank() - i) >= '1') {
            moves[c] = new Square((char) (square.getFile() + i),
                                  (char) (square.getRank() - i));
            c++;
            i++;
        }
        i = 1;
        while ((char) (square.getFile() - i) >= 'a'
                && (char) (square.getRank() + i) <= '8') {
            moves[c] = new Square((char) (square.getFile() - i),
                                  (char) (square.getRank() + i));
            c++;
            i++;
        }
        i = 1;
        while ((char) (square.getFile() - i) >= 'a'
                && (char) (square.getRank() - i) >= '1') {
            moves[c] = new Square((char) (square.getFile() - i),
                                  (char) (square.getRank() - i));
            c++;
            i++;
        }
        Square[] finalMoves = new Square[c];
        for (int j = 0; j < c; j++) {
            finalMoves[j] = moves[j];
        }
        return finalMoves;
    }


}
