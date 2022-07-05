package Leetcodes.Blind75.SlidingWindows;

public class LongestSubstringWithNoRepeating {
    public static int characterReplacement(String s, int k) {
        //424
        //using an array to represent frequency of each char
        // index            : 0 1 2 ......25
        // represent char:    A,B,C.......Z
        // val:           
        //AABABB
        //int l and int r represent the substring window
        //EVERY time, move r to right by 1; 
        //      if the count of chars need to be replaced > k, remove char l points to by 1 and move l pointer by 1
        
        int l =0;
        int r = 0;
        int[] frequency = new int[26];
        int maxf = 0;
        int res=0;
        while(r<s.length()){
            frequency[s.charAt(r)-'A']++;
            maxf=Math.max(maxf, frequency[s.charAt(r)-'A']);   
            if(r-l+1-maxf >k ){
                frequency[s.charAt(l)-'A']--;
                l=l+1;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(characterReplacement("ABAA",0));
    }
}
