package TwoPointers;

/**
 * 680. Valid Palindrome II[E] Given a string s, return true if the s can be
 * palindrome after deleting at most one character from it.
 */
public class ValidPalindromeII {
    public boolean isPalindromeII(String s) {
        int l = 0;
        int r = s.length();
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
