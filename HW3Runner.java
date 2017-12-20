public class HW3Runner {

    public static void main(String[] args) {
        try {
            new Square('a', '0');
            System.out.println("bad 1");
        } catch (InvalidSquareException e) {
            System.out.println("good 1: " + e.getMessage());
        }
        try {
            String invalidSquare = "a9";
            new Square(invalidSquare);
            System.out.println("bad 2");
        } catch (InvalidSquareException e) {
            System.out.println("good 2: " + e.getMessage());
        }
        try {
            Square s = new Square("f7");
            System.out.println('f' == s.getFile());
            System.out.println('7' == s.getRank());
            Square s2 = new Square('e', '4');
            System.out.println("e4".equals(s2.toString()));
        } catch (InvalidSquareException e) {
            System.out.println(":(");
        }

    }

}
