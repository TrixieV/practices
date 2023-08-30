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


//    public int[][] kClosest(int[][] points, int k) {
//        //Create a priority queue that compares the second element(distance^2) from small to large
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
//        //Iterate through the array to calculate the distance^2 and add it to the pq
//        for(int i = 0; i < points.length; i++){
//            int sum = points[i][0] * points[i][0] + points[i][1] * points[i][1];
//            pq.add(new int[] {i,sum});
//        }
//        //Create a new response array and poll k elements from the queue into the array
//        //That will be the k-smallest distance^2, and we don't have to do the square root necessarily
//        int[][] res = new int[k][];
//        while(k > 0){
//            res[k-1] = points[pq.poll()[0]];
//            k--;
//        }
//        return res;
//    }

//    public Node cloneGraph(Node node) {
//        if(node == null) {
//            return null;
//        }
//        final var visited = new HashMap<Integer, Node>();
//        final var copy = new Node(node.val);
//        cloneGraph(node, copy, visited);
//        return copy;
//    }

//    /**
//     * Deep clones the graph
//     * @param og Original Node
//     * @param copy Copy Node
//     * @param visited Whether the copy has been already visited / created
//     */
//    private void cloneGraph(Node og, Node copy, Map<Integer, Node> visited) {
//        // Check whether the copy is already created / visited
//        if (!visited.containsKey(copy.val)) {
//            visited.put(copy.val, copy);
//            for (Node ogChild : og.neighbors) {
//
//                // Very important step, create new child if node with that value is not already created
//                final var copyChild = visited.getOrDefault(ogChild.val, new Node(ogChild.val));
//                copy.neighbors.add(copyChild);
//
//                // DFS repeat with all neighbours
//                cloneGraph(ogChild, copyChild, visited);
//            }
//        }
//    }

//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        for(int i = 0; i < tokens.length; i++){
//            if(tokens[i].equals("+")){
//                int b = stack.pop();
//                int a = stack.pop();
//                stack.push(a+b);
//            }
//            else if(tokens[i].equals("-")){
//                int b = stack.pop();
//                int a = stack.pop();
//                stack.push(a-b);
//            }
//            else if(tokens[i].equals("*")){
//                int b = stack.pop();
//                int a = stack.pop();
//                stack.push(a*b);
//            }
//            else if(tokens[i].equals("/")){
//                int b = stack.pop();
//                int a = stack.pop();
//                stack.push(a/b);
//            }
//            else
//                stack.push(Integer.parseInt(tokens[i]));
//        }
//        return stack.pop();
//    }

//    public boolean canFinish(int n, int[][] prerequisites) {
//        List<Integer>[] adj = new List[n];
//        int[] indegree = new int[n];
//        List<Integer> ans = new ArrayList<>();
//
//        for (int[] pair : prerequisites) {
//            int course = pair[0];
//            int prerequisite = pair[1];
//            if (adj[prerequisite] == null) {
//                adj[prerequisite] = new ArrayList<>();
//            }
//            adj[prerequisite].add(course);
//            indegree[course]++;
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if (indegree[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//            ans.add(current);
//
//            if (adj[current] != null) {
//                for (int next : adj[current]) {
//                    indegree[next]--;
//                    if (indegree[next] == 0) {
//                        queue.offer(next);
//                    }
//                }
//            }
//        }
//
//        return ans.size() == n;
//    }



//class Trie {
//    Node root;
//
//    public Trie() {
//        root = new Node();
//    }
//
//    public void insert(String word) {
//        root.insert(word, 0);
//    }
//
//    public boolean search(String word) {
//        return root.search(word, 0);
//    }
//
//    public boolean startsWith(String prefix) {
//        return root.startsWith(prefix, 0);
//    }
//
//    class Node {
//        Node[] nodes;
//        boolean isEnd;
//
//        Node() {
//            nodes = new Node[26];
//        }
//
//        private void insert(String word, int idx) {
//            if (idx >= word.length()) return;
//            int i = word.charAt(idx) - 'a';
//            if (nodes[i] == null) {
//                nodes[i] = new Node();
//            }
//
//            if (idx == word.length()-1) nodes[i].isEnd = true;
//            nodes[i].insert(word, idx+1);
//        }
//
//        private boolean search(String word, int idx) {
//            if (idx >= word.length()) return false;
//            Node node = nodes[word.charAt(idx) - 'a'];
//            if (node == null) return false;
//            if (idx == word.length() - 1 && node.isEnd) return true;
//
//            return node.search(word, idx+1);
//
//        }
//
//        private boolean startsWith(String prefix, int idx) {
//            if (idx >= prefix.length()) return false;
//            Node node = nodes[prefix.charAt(idx) - 'a'];
//            if (node == null) return false;
//            if (idx == prefix.length() - 1) return true;
//
//            return node.startsWith(prefix, idx+1);
//        }
//    }
//}



//    public static int solve(int[][] dp  , int[] arr , int len, int amount)
//    {
//        if(amount == 0)
//            return 0;
//        if(len == 0)
//            return 100000;
//        if(dp[len][amount] != -1)
//            return dp[len][amount];
//        int take = 100000;
//        if(arr[len-1] <= amount)
//            take = solve(dp , arr , len , amount-arr[len-1]);
//        int not_take = solve(dp , arr , len-1 , amount);
//        dp[len][amount] = Math.min(take+1 , not_take);
//        return dp[len][amount];
//    }
//
//    public int coinChange(int[] coins, int amount) {
//        int len = coins.length;
//        int dp[][] = new int[len+1][amount+1];
//        for(int[] x : dp)
//            Arrays.fill(x,-1);
//        int ans = solve(dp , coins , len , amount);
//        if(ans >= 100000)
//            return -1;
//        return ans;
//    }



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