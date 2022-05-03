package Blind75.array;

import java.util.HashMap;
import java.util.Map;

//242. Valid Anagram
public class ValidAnagram {
        //method 1:  using arrays
        public boolean isAnagram(String s, String t) {
            //if s and t not same length, false
            if(s.length()!=t.length()) return false;
            //create an array with 26 chars
            int[] alphabet = new int[26];
            //for chars in s, if occurs the value at that index +1
            for(char c: s.toCharArray()){
                int pos = c - 'a';
                alphabet[pos]++;
                
            }
            //for chars in t, if occurs the value at that index -1
            for(int i = 0;i<t.length();i++){
                alphabet[t.charAt(i) - 'a']--;
            }
            //if anagram, all elements in alphabet array should be 0
            for(int x : alphabet){
                if(x!=0) return false;
            }
            return true;
        }
        //Method 2: using hashmap
        public boolean isAnagramHash(String s, String t) {
            if (s==null && t==null) return true;
            else if (s==null || t==null) return false;
            else if (s.length() != t.length()) return false;
            
            Map<Character, Integer> dict = new HashMap<>();
            for(char c : s.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            for(char c : t.toCharArray()) {
                int count = dict.getOrDefault(c, 0);
                if (count == 0) return false;
                else dict.put(c, count - 1);
            }
            
            return true;
        }

        /**
         * 
         * Follow up: What if the inputs contain Unicode characters? 
         * How would you adapt your solution to such a case?
         * In Java 8, we can use Charsequence.codepoints() to simplify our code.
         */
        public boolean isAnagramWithUnicode(String s, String t) {
            if (s==null && t==null) return true;
            else if (s==null || t==null) return false;
            else if (s.length() != t.length()) return false;
    
            Map<Integer, Integer> dict = new HashMap<>();
            s.codePoints().forEach(code -> dict.put(code, dict.getOrDefault(code, 0) + 1));
            t.codePoints().forEach(code -> dict.put(code, dict.getOrDefault(code, 0) - 1));
            
            for(int count : dict.values()) {
                if (count<0) return false;
            }
    
            return true;
        }
}
