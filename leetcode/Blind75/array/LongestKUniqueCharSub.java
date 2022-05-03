package Blind75.array;

import java.util.HashSet;
import java.util.Set;

// Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/
public class LongestKUniqueCharSub {
    public String longestkSubstr(String s, int k) {
        int CHAR_RANGE = 128;
        //use a set to store unique k characters
        //use 2 index to represent the boundray of the slide window
        Set<Character> uniqueChars = new HashSet<>();
        int[] frequency = new int[CHAR_RANGE];
        // stores the longest substring boundaries
        int end = 0, begin = 0;
        for(int left =0, right = 0;right<s.length();right++){
            //add the char into the window
            uniqueChars.add(s.charAt(right));
            frequency[s.charAt(right)]++;
            //if the window of unique chars number >k, remove from the leftmost
            // until the frequency of the leftmost element is 0
            while(uniqueChars.size()>k){
                
                if(--frequency[s.charAt(left)]==0){
                    uniqueChars.remove(s.charAt(left));
                }
                //reduce the window by moving the left boundary
                left++;
            }
            //[left, right] is the sliding window that changes when moving to the right with k number of unique chars 
            //[begin, end] is the current longest substring with unique k number of chars
            //when sliding window 
            if(end-begin < right-left){
                end = right;
                begin = left;
            }

        }
        return s.substring(begin,end+1);
        
        
    }
}
