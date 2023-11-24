package moderate2;

import java.util.Arrays;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3],
[2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
then the next permutation of that array is the permutation that follows it in the sorted container.
If such arrangement is not possible, the array must be rearranged as the lowest possible order
(i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3]
because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        boolean found = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                found = true;
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        sort(nums, i + 1, nums.length - 1);
                        break;
                    }
                }
                break;
            }
        }

        if (!found) {
            sort(nums, 0, nums.length - 1);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }

    private static void sort(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
