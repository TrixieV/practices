package moderate1;

public class FactZero {
    public static void main(String[] args) {
        int number = 30;
        System.out.println(countFactZero(30));
    }
    private static int countFactZero(int num) {
        int count = 0;
        if (num < 1) return -1;
        for (int i = 5; num / i > 0; i *= 5) {
            count += (num / i);
        }
        return count;
    }
}
