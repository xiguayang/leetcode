package Patterns.TwoPointers;

import java.util.*;
public class backspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return backspaceStringBuilder(s).equals(backspaceStringBuilder(t));
        
    }
    //Method1: a helper method using StringBuilder to get the string with backspace
    private String backspaceStringBuilder(String s){
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)=='#'){
                if(res.length()>0){
                    //delete the last char
                    res.deleteCharAt(res.length()-1);
                }
            }else{
                res.append(s.charAt(i));
            }
            i++;
        }
        return res.toString();
    }


    //Method2: 2 pointers compare
    //Iterate through the string in reverse. 
    //If we see a backspace character, 
    //the next non-backspace character is skipped. 
    //If a character isn't skipped, it is part of the final answer.
    public boolean backspaceCompareWithTwoPointers(String s, String t) {
        //initialize pointers to the last element of both strings
        int i = s.length()-1;
        int j = t.length()-1;

        while(i>=0 || j>=0){
            //find the position of valid char in s
            // while(i>=0){
            //     if(s.charAt(i)=='#'){//遇到#，记录要往前跳过的非#字符数，并往前一格
            //         skipS++;
            //         i--;
            //     }else if(skipS>0){//遇到非#字符，如果要跳过的字符数>0,则跳过此字符向前一格，要跳过的字符数-1
            //         skipS--;
            //         i--;
            //     }else{//遇到非#字符，无要跳过的字符数，此处为一个有效字符
            //         break;
            //     }
            // }
            //  对t同理s
           //find the position of valid char in s
           //提取成一个helper 方法
           i=getValidPosition(s, i);
           j=getValidPosition(t, j);
           // if the valid char of s and t is different, s and t is different
           if(i>=0 && j>=0 && s.charAt(i) != t.charAt(j)){
               return false;
           }
           // if s or t is null, cannot campare
           // one of them has been empty
           if((i>=0) !=(j>=0)){
                return false;
           }
           // the valid char is same, go forward to get next valid char to compare
           i--;
           j--;
        }
        return true;
        
    }
    private int getValidPosition(String s, int i){
        int skipCount =0;
        while(i>=0){
            if(s.charAt(i)=='#'){//遇到#，记录要往前跳过的非#字符数，并往前一格
                skipCount++;
                i--;
            }else if(skipCount>0){//遇到非#字符，如果要跳过的字符数>0,则跳过此字符向前一格，要跳过的字符数-1
                skipCount--;
                i--;
            }else{//遇到非#字符，无要跳过的字符数，此处为一个有效字符
                break;
            }
        }
        return i;
    }
}
