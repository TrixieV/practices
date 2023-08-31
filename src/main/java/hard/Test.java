package hard;

public class Test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1052);
        minStack.push(-1052);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}













//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int pre[] = new int[n];
//        int suff[] = new int[n];
//        pre[0] = 1;
//        suff[n - 1] = 1;
//
//        for(int i = 1; i < n; i++) {
//            pre[i] = pre[i - 1] * nums[i - 1];
//        }
//        for(int i = n - 2; i >= 0; i--) {
//            suff[i] = suff[i + 1] * nums[i + 1];
//        }
//
//        int ans[] = new int[n];
//        for(int i = 0; i < n; i++) {
//            ans[i] = pre[i] * suff[i];
//        }
//        return ans;
//    }




//    private long minVal = Long.MIN_VALUE;
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        if (!isValidBST(root.left)) return false;
//
//        if (minVal >= root.val) return false;
//
//        minVal = root.val;
//
//        if (!isValidBST(root.right)) return false;
//
//        return true;
//    }



//public class Solution {
//
//    private int n;
//    private int m;
//
//    public int numIslands(char[][] grid) {
//        int count = 0;
//        n = grid.length;
//        if (n == 0) return 0;
//        m = grid[0].length;
//        for (int i = 0; i < n; i++){
//            for (int j = 0; j < m; j++)
//                if (grid[i][j] == '1') {
//                    DFSMarking(grid, i, j);
//                    ++count;
//                }
//        }
//        return count;
//    }
//
//    private void DFSMarking(char[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
//        grid[i][j] = '0';
//        DFSMarking(grid, i + 1, j);
//        DFSMarking(grid, i - 1, j);
//        DFSMarking(grid, i, j + 1);
//        DFSMarking(grid, i, j - 1);
//    }


//    public int orangesRotting(int[][] grid) {
//        if(grid == null || grid.length == 0) return -1;
//
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[0].length; j++) {
//                if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
//            }
//        }
//
//        int minutes = 2;
//        for(int[] row : grid) {
//            for(int cell : row) {
//                if(cell == 1) return -1;
//                minutes = Math.max(minutes, cell);
//            }
//        }
//
//        return minutes - 2;
//    }
//    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
//        if(i < 0 || i >= grid.length /* out of bounds */
//                || j < 0 || j >= grid[0].length /* out of bounds */
//                || grid[i][j] == 0 /* empty cell */
//                || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
//        ) return;
//        else {
//            grid[i][j] = minutes;
//            rotAdjacent(grid, i - 1, j, minutes + 1);
//            rotAdjacent(grid, i + 1, j, minutes + 1);
//            rotAdjacent(grid, i, j - 1, minutes + 1);
//            rotAdjacent(grid, i, j + 1, minutes + 1);
//        }
//    }



//    public int search(int[] nums, int target) {
//        int low = 0, high = nums.length - 1;
//
//        while (low <= high) {
//            int mid = (low + high) / 2;
//
//            if (nums[mid] == target) {
//                return mid;
//            }
//
//            if (nums[low] <= nums[mid]) {
//                if (nums[low] <= target && target < nums[mid]) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            } else {
//                if (nums[mid] < target && target <= nums[high]) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//        }
//
//        return -1;
//    }