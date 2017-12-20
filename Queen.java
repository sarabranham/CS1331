/**
* Represents a king
* @author sbranham6
*/
public class Queen extends Piece {
    /**
    * Constructs a queen with a color from the Color enum
    */
    public Queen(Color color) {
        super(color);
    }

    /**
    * @return "Q", algebraic name of Queen
    */
    public String algebraicName() {
        return "Q";
    }

    /**
    * @return String "Q" or "q", depending on color
    */
    public String fenName() {
        return (this.getColor().equals(Color.WHITE)) ? "Q" : "q";
    }

    /**
    * Finds all locations a queen could've moved from depending on where it is
    * @param square an object representing a piece's location on the board
    * @return an array of Squares with where a queen could have moved from
    */
    public Square[] movesFrom(Square square) {
        Square[] moves = new Square[28];
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
        i = 1;
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
