package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

/**96. Unique Binary Search Trees[M]
 * Given an integer n,
 * return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 * Example: n = 3, output is 5
 *    1           1             2           3       3
 *     \           \           / \         /       /
 *      3           2         1   3       2       1
 *     /             \                   /        \
 *    2               3                 1          2
 *
 *===>
 * 1. given n, has n numbers, each of them could be root, so we have n different roots (每个数都可能成为根节点)
 * 2. if we use x < = n as the root, the left sub tree is the unique BSTs that made of {1,2,..x-1}, if the number of them is I
 *    the right sub tree is the unique BSTs that made of {x+1, ....n}, if the number of them is J
 *    The total number of unique BSTs when x is the root is I*J
 * 3. for each number as the root, count the total number of unique BSTs that generated.
 *    */



public class UniqueBST {

    public int numOfUniqueBST(int n) {
        return  count(1,n);
    }
    public int count(int lo, int hi){
        int result = 0;
        //base case，显然当 lo > hi 闭区间 [lo, hi] 肯定是个空区间，
        // 也就对应着空节点 null，虽然是空节点，但是也是一种情况，所以要返回 1 而不能返回 0
        if(lo > hi){
            return 1;
        }
        for(int i = lo; i<=hi; i++){
            //when i is the root
            int leftTrees = count(lo,i-1);
            int rightTrees =count (i+1,hi);
            result = result+leftTrees*rightTrees;
        }
        return result;
    }
    /**The method above has may duplicated situations, so the complexity of time is very high, we need to delete those situations
     * 动态规划相关的问题中有消除重叠子问题的方法，就是加一个备忘录**/
    // using a memo to record problems solved already
    private int[][] memo;
    public int numOfUniqueBSTBetter(int n) {
        // set the memo as 0
        memo = new int[n + 1][n + 1];
        return  countBetter(1,n);
    }
    public int countBetter(int lo, int hi){
        int result = 0;
        //base case，显然当 lo > hi 闭区间 [lo, hi] 肯定是个空区间，
        // 也就对应着空节点 null，虽然是空节点，但是也是一种情况，所以要返回 1 而不能返回 0
        if(lo > hi){
            return 1;
        }
        //if [lo,hi] not been counted, memo[ho][hi] should be 0;
        //or if it has been counted, just use memo[lo][hi] as the result
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }
        for(int i = lo; i<=hi; i++){
            //when i is the root
            int leftTrees = countBetter(lo,i-1);
            int rightTrees =countBetter (i+1,hi);
            result = result+leftTrees*rightTrees;
        }
        // 将结果存入备忘录
        memo[lo][hi] = result;
        return result;
    }

    /** Approach 2==> another quick method :
     * First note that dp[k] represents the number of BST trees built from 1....k;
     * Then assume we have the number of the first 4 trees: dp[1] = 1 ,dp[2] =2 ,dp[3] = 5, dp[4] =14 ,
     * how do we get dp[5] based on these four numbers is the core problem here.
     * The essential process is: to build a tree, we need to pick a root node,
     *                          then we need to know how many possible left sub trees and right sub trees can be held under that node,
     *                          finally multiply them.
     * To build a tree contains {1,2,3,4,5}. First we pick 1 as root, for the left sub tree, there are none;
     * for the right sub tree, we need count how many possible trees are there constructed from {2,3,4,5},
     * apparently it's the same number as {1,2,3,4}.
     * So the total number of trees under "1" picked as root is dp[0] * dp[4] = 14.(assume dp[0] =1).
     * Similarly, root 2 has dp[1]*dp[3] = 5 trees.
     * root 3 has dp[2]*dp[2] = 4,
     * root 4 has dp[3]*dp[1]= 5
     * and root 5 has dp[0]*dp[4] = 14. Finally sum the up and it's done.
     * Now, we may have a better understanding of the dp[k],
     * which essentially represents the number of BST trees with k consecutive nodes.
     * It is used as database when we need to know how many left sub trees are possible for k nodes when picking (k+1) as root.
     */
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                dp[level] += dp[level-root]*dp[root-1];
        return dp[n];
    }
    /**#95. Unique Binary Search Trees II【M】
     * Given an integer n, return all the structurally unique BST's (binary search trees),
     * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
     * 1、穷举 root 节点的所有可能。
     * 2、递归构造出左右子树的所有合法 BST。
     * 3、给 root 节点穷举所有左右子树的组合。*/
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        return buildUniqueTrees(1,n);
    }
    public List<TreeNode> buildUniqueTrees(int lo, int hi){
        LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        //base case
        if(lo > hi){
            result.add(null);
            return result;
        }
        // 1、穷举 root 节点的所有可能。
        for(int mid = lo; mid<=hi; mid++){
            //2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = buildUniqueTrees(lo,mid-1);
            List<TreeNode> rightTree = buildUniqueTrees(mid+1,hi);

            //3、给 root 节点穷举所有左右子树的组合。
            for(TreeNode leftSubTree: leftTree){
                for(TreeNode rightSubTree : rightTree){
                    TreeNode root = new TreeNode(mid);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
