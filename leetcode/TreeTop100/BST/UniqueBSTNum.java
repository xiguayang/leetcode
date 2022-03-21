// #96
// given an integer n, return the number of unique BSTs: nodes of unique value 1 to n
// 所有1-n 组成的 BST 数量： if choose i between [1,n] as root, then [1,i-1] 构建的BST 数量* 【i+1,n] 构建的BST 数量
// attention: base case : 对于 lo > hi 对应的是null , but is also 1 BST
public class UniqueBSTNum {
    public int numBSTs(int n) {
        // count [1,n] 组成的BST
        // using a helper method
        return count(1, n);
    }

    // count all the BST numbers of [1,n]
    private int count(int lo, int hi) {
        // base case: if lo>hi, the tree is null, but is BST
        if (lo > hi) {
            return 1;
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // use i as the root
            // count all BSTs in left [lo, i-1]
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            res += left * right;
        }
        return res;
    }

    // ******Time Complexity is high O(n^2) *************/
    // using memo to reduce the reduant compute

    /**
     * 1. given n, has n numbers, each of them could be root, so we have n different
     * roots (每个数都可能成为根节点)
     * 2. if we use x < = n as the root, the left sub tree is the unique BSTs that
     * made of {1,2,..x-1}, if the number of them is I
     * the right sub tree is the unique BSTs that made of {x+1, ....n}, if the
     * number of them is J
     * The total number of unique BSTs when x is the root is I*J
     * 3. for each number as the root, count the total number of unique BSTs that
     * generated.
     */
    /**
     * The method above has may duplicated situations, so the complexity of time is
     * very high, we need to delete those situations
     * 动态规划相关的问题中有消除重叠子问题的方法，就是加一个备忘录
     **/
    // using a memo to record problems solved already
    private int[][] memo;

    public int numTrees(int n) {
        // set the memo as 0
        memo = new int[n + 1][n + 1];
        return countHelper(1, n);
    }

    public int countHelper(int lo, int hi) {
        int result = 0;
        // base case，显然当 lo > hi 闭区间 [lo, hi] 肯定是个空区间，
        // 也就对应着空节点 null，虽然是空节点，但是也是一种情况，所以要返回 1 而不能返回 0
        if (lo > hi) {
            return 1;
        }
        // if [lo,hi] not been counted, memo[ho][hi] should be 0;
        // or if it has been counted, just use memo[lo][hi] as the result
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }
        for (int i = lo; i <= hi; i++) {
            // when i is the root
            int leftTrees = countHelper(lo, i - 1);
            int rightTrees = countHelper(i + 1, hi);
            result = result + leftTrees * rightTrees;
        }
        // 将结果存入备忘录
        memo[lo][hi] = result;
        return result;
    }

}
