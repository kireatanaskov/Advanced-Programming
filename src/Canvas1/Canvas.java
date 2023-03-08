package Canvas1;

import java.util.List;

public class Canvas {
    String id;
    List<Square> squares;

    public Canvas(String id, List<Square> squares) {
        this.id = id;
        this.squares = squares;
    }

    public int squareCount() {
        return squares.size();
    }

    public int sumPerimeter() {
        return squares.stream()
                .mapToInt(Square::perimeter)
                .sum();
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", id, squares.size(), sumPerimeter());
    }
}
