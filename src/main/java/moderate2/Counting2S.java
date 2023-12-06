package moderate2;

public class Counting2S {

    private static int countTwo(int range) {
        int count = 0;
        for (int i = 0; i <= range; i++) {
            count += count2InNum(i);
        }

        return count;
    }

    private static int count2InNum(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 2) {
                count++;
            }
            num /= 10;
        }

        return count;
    }
}
