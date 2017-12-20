public class Runner {
    public static void main(String[] args) {
        // HI FRIEND javac *.java
        // checkstyle *.java (don't do all of them manually it hurts)
        Piece knight = new Knight(Color.BLACK);
        assert knight.algebraicName().equals("N");
        assert knight.fenName().equals("n");
        Piece p = new Pawn(Color.BLACK);
        Square[] attackedSquares = p.movesFrom(new Square("h4"));
        // test that attackedSquares contains e8, g8, etc.
        Square a1 = new Square("a1");
        Square otherA1 = new Square('a', '1');
        Square h8 = new Square("h8");
        assert a1.equals(otherA1);
        assert !(a1.equals(h8));
    }
}
