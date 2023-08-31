package hard;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations
and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinsChange {
    public static void main(String[] args) {
        int[] coins = new int[]{2, 5};
        System.out.println(coinChange(coins, 8));
    }


    private static int calculating(int[][] map, int[] arr, int len, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (len == 0) {
            return 100000;
        }
        if (map[len][amount] != -1) {
            return map[len][amount];
        }
        int take = 100000;
        if (arr[len-1] <= amount) {
            take = calculating(map, arr, len, amount - arr[len-1]);
        }
        int notTake = calculating(map, arr, len - 1, amount);
        map[len][amount] = Math.min(take+1 , notTake);
        return map[len][amount];
    }

    private static int coinChange(int[] coins, int amount) {

        int len = coins.length;
        int[][] map = new int[len+1][amount+1];
        for(int[] x : map) {
            Arrays.fill(x,-1);
        }

        int ans = calculating(map, coins, len, amount);
        if(ans >= 100000)
            return -1;
        return ans;
    }

}
