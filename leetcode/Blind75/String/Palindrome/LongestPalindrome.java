package Leetcodes.Blind75.String.Palindrome;
import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s==null) return 0;
        HashSet<Character> records = new HashSet<>();
        int count =0;
        //count is used to count the pairs of same chars in string
        for(int i=0;i<s.length();i++){
            if(records.contains(s.charAt(i))){
                count++;
                records.remove(s.charAt(i));
            }else{
                records.add(s.charAt(i));
            }
        }
        if(!records.isEmpty()) return count*2+1;
        return count*2;
    }
}
