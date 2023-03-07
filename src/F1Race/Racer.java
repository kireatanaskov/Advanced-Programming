package F1Race;

public class Racer implements Comparable<Racer> {
    private String name;
    private int lap1;
    private int lap2;
    private int lap3;
    private int best;

    public Racer(String name, int lap1, int lap2, int lap3) {
        this.name = name;
        this.lap1 = lap1;
        this.lap2 = lap2;
        this.lap3 = lap3;
        this.best = Math.min(Math.min(lap1, lap2), lap3);
    }

    public static int stringToTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 * 1000
                + Integer.parseInt(parts[1]) * 1000
                + Integer.parseInt(parts[2]);
    }

    public static String timeToString(int time) {
        int minutes = (time / 1000) / 60;
        int seconds = (time - minutes * 1000 * 60) / 1000;
        int ms = time % 1000;
        return String.format("%d:%02d:%03d", minutes, seconds, ms);
    }

    @Override
    public int compareTo(Racer o) {
        return this.best - o.best;
    }

    @Override
    public String toString() {
        return String.format("%-10s%10s", name, timeToString(best));
    }
}
