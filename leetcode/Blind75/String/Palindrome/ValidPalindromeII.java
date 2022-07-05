package Leetcodes.Blind75.String.Palindrome;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                return isValidPalindromeHelper(s,l+1,r) || isValidPalindromeHelper(s,l,r-1);
            }
            
        }
        return true;
    }
    public boolean isValidPalindromeHelper(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
