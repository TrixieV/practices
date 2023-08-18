package hard;

/*
A popular masseuse receives a sequence of back-to-back appointment requests and is debating which ones to accept.
She needs a 15-minute break between appointments and therefore she cannot accept any adjacent requests.
Given a sequence of back-to-back appointment requests (all multiples of 15 minutes, none overlap, and none can be moved),
find the optimal (highest total booked minutes) set the masseuse can honor. Return the number of minutes.

EXAMPLE
Input: {30, 15, 60, 75, 45, 15, 15, 45}
Output: 180 minutes ({30, 60, 45, 45}).
 */
public class MassageTime {
    public static void main(String[] args) {
        int[] massage = new int[]{30, 15, 60, 75, 45, 15, 15, 45};
        System.out.println(findBest(massage) + " minutes");
    }

    private static int findBest(int[] massage) {
        int oneAway = 0, twoAway = 0;
        for (int i = massage.length - 1; i >= 0; i--) {
            int bestWithCurrentTime = massage[i] + twoAway;
            int bestWithoutCurrentTime = oneAway;

            int max = Math.max(bestWithCurrentTime, bestWithoutCurrentTime);

            twoAway = oneAway;
            oneAway = max;

//            System.out.println("oneAway: " + oneAway);
//            System.out.println("twoAway: " + twoAway);
        }
        return oneAway;
    }
}
