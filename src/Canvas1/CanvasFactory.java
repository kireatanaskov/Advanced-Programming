package Canvas1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CanvasFactory {
    public static Canvas createCanvas(String line) {
        String[] parts = line.split("\\s+");
        String id = parts[0];
        List<Square> squares;

        squares = Arrays.stream(parts)
                .skip(1)
                .map(part -> new Square(Integer.parseInt(part)))
                .collect(Collectors.toList());

        return new Canvas(id, squares);
    }
}
