import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class to represent a chess game
 *
 * @author sbranham6
 * @version 2
 */
public class ChessGame {
    //private List<Move> moves;
    private StringProperty event = new SimpleStringProperty(this, "NA");
    private StringProperty site = new SimpleStringProperty(this, "NA");
    private StringProperty date = new SimpleStringProperty(this, "NA");
    private StringProperty white = new SimpleStringProperty(this, "NA");
    private StringProperty black = new SimpleStringProperty(this, "NA");
    private StringProperty result = new SimpleStringProperty(this, "NA");
    private List<String> moves;

    /**
     * Creates an instance of ChessGame
     * @param moves a List of move objects made in the game
     */
    // public ChessGame(List<Move> moves) {
    //     this.moves = moves;
    // }

    /**
     * instantiates chessgame - compatible with chessgui
     * @param event String for game title
     * @param site String for game setting
     * @param date String for game data
     * @param white String for name of white player
     * @param black String for name of black plaer
     * @param result String w/ final score
     */
     public ChessGame(String event, String site, String date,
                      String white, String black, String result) {
        this.event.set(event);
        this.site.set(site);
        this.date.set(date);
        this.white.set(white);
        this.black.set(black);
        this.result.set(result);
        moves = new ArrayList<>();
     }

     /**
      * adds a move to the list of moves
      * @param move Move object to be added
      */
     public void addMove(String move) {
         moves.add(move);
     }

    /**
     * @return List of moves
     */
    public List<Move> getMoves() {
        return this.moves;
    }
    /**
     * Retrieves a move at a specific index
     * @param n int index
     * @return Move at the desired index
     */
    public Move getMove(int n) {
        return moves.get(n - 1);
    }

    /**
     * @return String event
     */
    public String getEvent() {
        return event.get();
    }

    /**
     * @return String site
     */
    public String getSite() {
        return site.get();
    }

    /**
     * @return String date
     */
    public String getDate() {
        return date.get();
    }

    /**
     * @return String white player
     */
    public String getWhite() {
        return white.get();
    }

    /**
     * @return String black player
     */
    public String getBlack() {
        return black.get();
    }

    /**
     * @return String final score
     */
    public String getResult() {
        return result.get();
    }

    /**
     * returns a list filtered by the Predicate
     * @param filter based on implementation of Predicate
     * @return new List filtered by the predicate
     */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> a = new ArrayList<Move>();
        for (Move m : moves) {
            if (filter.test(m)) {
                a.add(m);
            }
        }
        return a;
    }

    /**
     * Uses a lambda expression to get all moves with comments
     * @return list of moves with comments
     */
    public List<Move> getMovesWithComment() {
        return filter((Move m) -> {
                if (!m.getWhitePly().getComment().isEmpty()
                        || !m.getBlackPly().getComment().isEmpty()) {
                    return true;
                }
                return false;
            });
    }

    /**
     * Uses an anonymous inner class to get all moves without comments
     * @return a list of moves without comments
     */
    public List<Move> getMovesWithoutComment() {
        return filter(new Predicate<Move>() {
            public boolean test(Move m) {
                if (m.getWhitePly().getComment().isEmpty()
                        && m.getBlackPly().getComment().isEmpty()) {
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * Uses an inner class to get moves with a specified piece
     * @param p - specified piece
     * @return - list of moves containing the specified piece
     */
    public List<Move> getMovesWithPiece(Piece p) {
        class MovePredicate implements Predicate<Move> {
            String name = p.algebraicName();
            public boolean test(Move m) {
                Ply w = m.getWhitePly();
                Ply b = m.getBlackPly();
                if (w.getPiece().algebraicName().equals(name)
                    || b.getPiece().algebraicName().equals(name)) {
                    return true;
                }
                return false;
            }
        }
        return filter(new MovePredicate());
    }
}
