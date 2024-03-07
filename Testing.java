public class Testing {
    public static void main (String[] args) {
        checkTwo();
    }

    public static void checkTwo() {
        for (char c = 'A'; c < 'D'; c++) {
            for (int i = 0; i <= 2; i++) {
                System.out.println("seat " + c + i);
            }
        }
    }

}
