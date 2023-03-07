package F1Race;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class F1Race {
    private final ArrayList<Racer> racers;

    public F1Race() {
        racers = new ArrayList<Racer>();
    }

    public void readResults(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            Racer racer = new Racer(parts[0], Racer.stringToTime(parts[1]),
                    Racer.stringToTime(parts[2]),
                    Racer.stringToTime(parts[3]));
            racers.add(racer);
        }
        scanner.close();
    }

    public void printSorted(OutputStream outputStream) {
        Collections.sort(racers);
        PrintWriter printWriter = new PrintWriter(outputStream);
        int i = 1;
        for(Racer racer : racers) {
            printWriter.printf("%d. %s\n", i++, racer);
        }
        printWriter.close();
    }
}