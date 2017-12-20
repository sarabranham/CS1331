import java.util.Optional;

/**
 * Class to represent a chess player
 *
 * @author sbranham6
 * @version 1
 */
public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    private String comment;

    /**
     * Instatiates a player
     * @param piece - piece that is being moved
     * @param from - the Square the piece is coming from
     * @param to - the Square the piece is going to
     * @param comment - optional parameter
     */
    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment.isPresent() ? comment.get() : "";
    }

    /**
     * @return the piece of interest
     */
    public Piece getPiece() {
        return this.piece;
    }

    /**
     * @param piece - a piece to replace the current piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * @return the Square the piece is coming from
     */
    public Square getFrom() {
        return this.from;
    }

    /**
     * @param square - Square to replace the square the piece is coming from
     */
    public void setFrom(Square square) {
        this.from = square;
    }

    /**
     * @return - the Square the piece is going towards
     */
    public Square getTo() {
        return this.to;
    }

    /**
     * @param square - Square to replace the square the piece is going towards
     */
    public void setTo(Square square) {
        this.to = square;
    }

    /**
     * @return - the optional Comment parameter
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @param comment - a String to replace the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
