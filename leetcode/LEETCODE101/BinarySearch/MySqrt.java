package BinarySearch;

/**
 * 69. Sqrt(x) (Easy) 题目描述 给定一个非负整数，求它的开方，向下取整。
 */
public class MySqrt {
    public static int mySqrt(int a) {
        // find x, x^2-a =0, x should in [0,a]
        // binary search in [0,a]
        // in case we can't /0, consider a ==0 individually
        if (a == 0)
            return a;
        int l = 1;
        int r = a;
        int mid, sqrt;
        while (l <= r) {
            mid = l + (r - l) / 2;
            sqrt = a / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid > sqrt) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

}

// public static int mySqrt(int x) {
// if (x == 0)
// return 0;
// int start = 1, end = x;
// while (start < end) {
// int mid = start + (end - start) / 2;
// if (mid * mid <= x && (mid + 1) * (mid + 1) > x)// Found the result
// return mid;
// else if (mid > x / mid)// Keep checking the left part
// end = mid;
// else
// start = mid + 1;// Keep checking the right part
// }
// return start;
// }