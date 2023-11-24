package moderate1;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }
    private static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i-1] + stairs[i-2];
        }
        return stairs[n-1];
    }
}
