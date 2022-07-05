package Leetcodes.Blind75.SlidingWindows;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {
   //76.  Minimum Window Substring
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        //using a hashMap to record the chars in t, key is char, value is frequency of char
        Map<Character, Integer> hm = new HashMap<>();
        for(int i =0;i<t.length(); i++){
            char c = t.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)+1);
            }else{
                hm.put(c,1);
            }
        }
        //using a sliding window to traverse s
        int l =0;
        int r =0;
        String minString = s;
        //must have a boolean to record if find one satisfied substring
        boolean flag = false;
        int count = 0;//using count to check if all chars in t already in s
        while(r<s.length()){
            char rchar = s.charAt(r);
            if(hm.containsKey(rchar)){
                hm.put(rchar, hm.get(rchar)-1);
                //the times of the rchar in the sub window appears more than times in t 
                //only count times shown in t
                if(hm.get(rchar)>=0){
                    count++;
                }
            }
            while(count== t.length() && l<=r){
                flag = true;
                //find one satisfied substring
                if(minString.length()>r-l+1){
                    minString = s.substring(l,r+1);
                }
                //shrink the substring window
                char lchar = s.charAt(l);
                if(hm.containsKey(lchar)){
                    hm.put(lchar, hm.get(lchar)+1);
                    //only when hm.get(lchar)>0, means the times appearance of char in t
                    //break the while loop of shrink window
                    if(hm.get(lchar)>0){
                        count--;
                    }
                }
                l = l+1;
            }
            
            r++;
        }
        if(flag){
            return minString;
        }else{
            return "";
        }
    }
}
