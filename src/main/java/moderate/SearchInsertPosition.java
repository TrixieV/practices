package moderate;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3,4,5};
        System.out.println(searchInsert(nums, 1));
    }

    private static int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        int insertPosition = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                insertPosition = mid;
                break;
            } else if (nums[mid] > target) {
                insertPosition = mid;
                right = mid - 1;
            } else {
                insertPosition = mid + 1;
                left = mid + 1;
            }
        }
        return insertPosition;
    }
}
