
/**
* Class to represent a given move
*
* @author sbranham6
* @version 1
 */
public class Move {
    private Ply whitePly;
    private Ply blackPly;

    /**
     * Instantiates a move with 2 pieces
     * @param whitePly - white player (piece, from, to, optional comment)
     * @param blackPly - black player (piece, from, to, optional comment)
     */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

    /**
     * @return current white player
     */
    public Ply getWhitePly() {
        return this.whitePly;
    }

    /**
     * @return current black player
     */
    public Ply getBlackPly() {
        return this.blackPly;
    }

    /**
     * @param ply player to set the white player to
     */
    public void setWhitePly(Ply ply) {
        this.whitePly = ply;
    }

    /**
     * @param ply player to set the black player to
     */
    public void setBlackPly(Ply ply) {
        this.blackPly = ply;
    }
}
