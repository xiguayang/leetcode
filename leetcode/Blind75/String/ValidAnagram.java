package Leetcodes.Blind75.String;



import java.util.HashMap;

public class ValidAnagram {
        //method using arrays
        public boolean isValidAnagramAllLowerCase(String s, String t){
            if(s.length()!= t.length()) return false;
            //traverse s, adding frequency to array: a--> index 0, x--> index:x-a
            int[] arr = new int[26];
            //char[] sChar = s.toCharArray();
            for(int i =0;i<s.length();i++){
                arr[s.charAt(i)-'a']++;
                arr[t.charAt(i)-'a']--;
            }
            for(int index = 0; index<arr.length;index++){
                if(arr[index]!=0){
                    return false;
                }
            }
            return true;
        }
        //precondition: are all lowercase alphabets
        //followup: no require lowercase
        // using HashMap
        public boolean isAnagram(String s, String t) {
            if(s.length()!=t.length()) return false;
            HashMap<Character, Integer> records = new HashMap<>();
            for(int i=0;i<s.length();i++){
                records.put(s.charAt(i), records.getOrDefault(s.charAt(i), 0)+1);
                records.put(t.charAt(i), records.getOrDefault(t.charAt(i), 0)-1);
            }
            for(char c: records.keySet()){
                if(records.get(c)!=0) return false;
            }
            return true;

        }
    
}
