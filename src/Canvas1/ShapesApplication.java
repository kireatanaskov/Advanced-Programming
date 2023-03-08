package Canvas1;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ShapesApplication {
    List<Canvas> canvases;

    public ShapesApplication() {

    }

    public int readCanvases(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        this.canvases = bufferedReader.lines()
                .map(CanvasFactory::createCanvas)
                .collect(Collectors.toList());

        return canvases.stream()
                .mapToInt(Canvas::squareCount)
                .sum();
    }

    private int findLargest() {
        int max = canvases.get(0).sumPerimeter();
        int index = 0;
        for (int i=1; i<canvases.size(); i++) {
            if (canvases.get(i).sumPerimeter() > max) {
                max = canvases.get(i).sumPerimeter();
                index = i;
            }
        }
        return index;
    }

    public void printLargestCanvasTo(OutputStream outputStream) {
        PrintWriter pw = new PrintWriter(outputStream);

        int max = findLargest();
        Canvas canvas = canvases.get(max);
        pw.print(canvas);

        pw.flush();
    }
}
