package Blind75.array;

import java.util.HashMap;

// #3 https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Given a string s, find the length of the longest substring without repeating characters.
public class LongestSubStringWithNoRepeating {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1) return 0;
        //1. use HashMap, the unique char as the key --> value is the index of the char last appeared
        HashMap<Character,Integer> uniqueChars = new HashMap<>();

        //2. int result is the current longgest length of substring
        int res = 0;
        
        //3. two pointers that points to the sliding window contains unique chars
        for(int l=0, r = 0; r<s.length(); r++){
            //3.1 if the char r points to is already exist in the map

            //if the left pointer is already at the right of the index of the char last appeared, nothing to do 
            //else: move the left pointer to the rihgt of the index of the char last appeared
            char currentChar = s.charAt(r);
            if(uniqueChars.containsKey(currentChar)){
                if(l<uniqueChars.get(currentChar)+1){
                    l = uniqueChars.get(currentChar)+1;
                }    
            }
            //3.2. update the index of the char r points to 
            uniqueChars.put(s.charAt(r), r);
            //4. now update the length of the result if the length of sliding window > res
            res = Math.max(res, r-l+1);
        }
        return res;
    }
    
}
