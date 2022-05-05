package TwoPointers;

/**
 * 633. Sum of Square Numbers[M] Given a non-negative integer c, decide whether
 * there're two integers a and b such that a2 + b2 = c. //similar with 2 sum
 * using 2 pointers
 */
public class SumOfSquare {
    public boolean judgeSquareSum(int c) {
        int root = (int) Math.sqrt(c);
        int l = 0;
        int r = root;
        while (l <= r) {
            if ((l * l + r * r) == c)
                return true;
            else if ((l * l + r * r) < c) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }
        return false;
    }
}
