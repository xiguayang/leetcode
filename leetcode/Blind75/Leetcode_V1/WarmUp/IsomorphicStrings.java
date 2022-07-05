package Leetcodes.Leetcode_V1.WarmUp;

import java.util.HashMap;
import java.util.Map;
//205
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        // using HashMap to store char in s as key, corresponding char in t as value
        if(s.length()!=t.length()) return false;
        Map<Character, Character> hm = new HashMap<>();
        for(int i =0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(hm.containsKey(c1)){
                if(hm.get(c1)!=c2) return false;
            }else{
                 //"badc","baba"-->false
                // so need to check if char in t appears as value in map already
                if(hm.containsValue(c2)){
                    return false;
                }
                hm.put(c1,c2);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc","baba"));
    }
}
