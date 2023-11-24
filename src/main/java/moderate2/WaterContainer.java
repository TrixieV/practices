package moderate2;

/*
You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.

Notice that you may not slant the container.
 */
public class WaterContainer {
    public static void main(String[] args) {
        int[] height = new int[]{1,1,1,2,5,4,1,1,1};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(currentArea, max);
            if (height[left] == height[right]) {
                left++;
                right--;
            } else {
                if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return max;
    }
}




















