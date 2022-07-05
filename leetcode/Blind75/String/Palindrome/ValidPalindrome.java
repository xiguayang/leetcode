package Leetcodes.Blind75.String.Palindrome;

public class ValidPalindrome {
    public boolean isPalidrome(String s){
        int l=0;
        int r = s.length()-1;
        while(l<r){
            //skip non letter or number
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(l<r && Character.toLowerCase(s.charAt(l++))!= Character.toLowerCase(s.charAt(r--))){
                return false;
            }

        }
        return true;
    }
    
}
