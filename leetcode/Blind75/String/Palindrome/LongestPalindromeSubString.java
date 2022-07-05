package Leetcodes.Blind75.String.Palindrome;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromeSubString {
    public String longestPalindrome(String s) {
        String longest = "";
        int maxLength =0;
        for(int i =0;i<s.length();i++){
            //odd length of s, start from mid
            int l =i;
            int r =i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>maxLength){
                    maxLength = r-l+1;
                    longest=s.substring(l,r+1);
                }
                l=l-1;
                r=r+1;
            }
            //even 
            l =i;
            r =i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if((r-l+1)>maxLength){
                    maxLength = r-l+1;
                    longest=s.substring(l,r+1);
                }
                l=l-1;
                r=r+1;
            }

        }
        return longest;
    }

    public String longestPalindromeWithDetails(String s) {
        String longestSub ="";
        int longest = 0;
        //1. traverse the string, using 2 pointers, l and r
        for(int i =0;i<s.length();i++){
            //2. l, r starts from one char, and expand l-1, r+1 for palindrome string: xxxxaxxxx
            int l = i;
            int r = i;
            // expand l and r to find the longest palindrome
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 >longest){
                    longest = r-l+1;
                    //substring(begin, end) returns [begin, end-1] of the string
                    longestSub = s.substring(l, r+1);
                }
                l=l-1;
                r=r+1;
            }

            //3. l, r starts from 2 chars, and expand l-1, r+1 for palindrome string like: xxxaaxxx
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>longest){
                    longest = r-l+1;
                    longestSub = s.substring(l,r-1);
                }
                l=l-1;
                r=r+1;
            }
            
        }
        return longestSub;
    }

    /** Method 2: Recursion */
    List<String> result = new ArrayList<>();
    int res = 1;//only one element--> no for loop, return 1;
    public int countSubstrings(String s) {
        
        if(s.length()==0) return 0;
        if(s.length()==1) result.add(s);
        for(int i =0; i<s.length()-1;i++){
            checkPalindromicExtend(s, i, i);
            checkPalindromicExtend(s,i,i+1);
        }    
        result.add(s.substring(s.length()-1));
        //return result.size();
        return res;
    }
    public void checkPalindromicExtend(String s, int startIndexL, int startIndexR){
        while(startIndexL>=0 && startIndexR<s.length() && s.charAt(startIndexL)==s.charAt(startIndexR)){
            res++;
            result.add(s.substring(startIndexL, startIndexR+1));
            startIndexL--;
            startIndexR++;
        }
    }
    
    public static void main(String[] args) {
        //test case: "abacb"
        //test case: "bccd"
        String s = "abcde";
        System.out.println(s.substring(2,5));
    }
}
