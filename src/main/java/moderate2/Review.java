package moderate2;

import java.util.*;

public class Review {

    /*
    Palindrome
     */
    private static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        String lowerCase = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (alphaCheck(lowerCase.charAt(left)) && alphaCheck(lowerCase.charAt(right))) {
                if (lowerCase.charAt(left) != lowerCase.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            } else if (!alphaCheck(lowerCase.charAt(left))) {
                left++;
            } else if (!alphaCheck(lowerCase.charAt(right))) {
                right--;
            }
        }
        return true;
    }

    private static boolean alphaCheck(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }


    /*
    Longest not repeating chars
     */
    private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>();
        int longest = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (!characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right));
                longest = Math.max(longest, (right - left + 1));
            } else {
                while (characters.contains(s.charAt(right))) {
                    characters.remove(s.charAt(left));
                    left++;
                }
                characters.add(s.charAt(right));
            }
        }

        return longest;
    }


    /*
    contain Duplicate
     */

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> mapNumWithIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mapNumWithIndex.containsKey(nums[i])) {
                mapNumWithIndex.put(nums[i], i);
            } else {
                if (i - mapNumWithIndex.get(nums[i]) <= k) {
                    return true;
                } else {
                    mapNumWithIndex.put(nums[i], i);
                }
            }
        }
        return false;
    }

    /*
    Binary Search
     */

    private static int search(int[] nums, int target) {
        if (target > nums[nums.length - 1] || target < nums[0]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int searchRotated(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    /*
    Anagram
     */

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);

        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);

        String sString = new String(sArray);
        String tString = new String(tArray);

        if (sString.equals(tString)) {
            return true;
        }
        return false;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramLists = new HashMap<>();
        for (String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String sString = new String(sArray);

            if (!anagramLists.containsKey(sString)) {
                anagramLists.put(sString, new ArrayList<>());
            }
            anagramLists.get(sString).add(s);
        }

        return new ArrayList<>(anagramLists.values());

    }


    /*
    combination Sum
     */
     private static List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> ans = new ArrayList<>();
         Arrays.sort(candidates);
         backtrackingCombi(ans, new ArrayList<>(), candidates, 0, target);
         return ans;
     }

     private static void backtrackingCombi(List<List<Integer>> ans, List<Integer> list, int[] candidates, int start, int remaining) {
         if (remaining < 0) {
             return;
         }

         if (remaining == 0) {
             ans.add(new ArrayList<>(list));
         }

         else {
             for (int i = start; i < candidates.length; i++) {
                 list.add(candidates[i]);
                 backtrackingCombi(ans, list, candidates, i, remaining - candidates[i]);
                 list.remove(list.size() - 1);
             }
         }
     }



     private static List<List<Integer>> subsets(int[] nums) {
         Arrays.sort(nums);
         List<List<Integer>> ans = new ArrayList<>();
         backtrackingSubset(ans, new ArrayList<>(), nums, 0);
         return ans;
     }

     private static void backtrackingSubset(List<List<Integer>> ans, List<Integer> list, int[] nums, int start) {
         ans.add(new ArrayList<>(list));

         for (int i = start; i < nums.length; i++) {
             if (i > start && nums[i] == nums[i - 1]) {
                 continue;
             }
             list.add(nums[i]);
             backtrackingSubset(ans, list, nums, i + 1);
             list.remove(list.size() - 1);
         }
     }


}
















