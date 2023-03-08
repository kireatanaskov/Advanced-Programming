package Canvas1;

public class Square implements Comparable<Square> {
    int side;

    public Square(int side) {
        this.side = side;
    }

    public int perimeter() {
        return 4*side;
    }

    @Override
    public int compareTo(Square o) {
        return Integer.compare(this.perimeter(), o.perimeter());
    }
}
