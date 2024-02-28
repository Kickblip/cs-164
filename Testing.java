public class Testing {
    public static void main (String[] args) {
        int counter = 10;
        String tracker = "Track: ";
        do {
            tracker += " " + counter;
        } while (++counter < 11);

        System.out.println(counter);
        System.out.println(tracker);

    }
}
