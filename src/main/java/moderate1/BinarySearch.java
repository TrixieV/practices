package moderate1;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};

        System.out.println(search(arr, 6));
    }

    private static int search(int[] nums, int target) {
        if (target > nums[nums.length - 1] || target < nums[0]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
