package Leetcodes.Blind75.DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
        //have bugs: when ["aaa", "aaaa"], s="aaaaaaa" will return false;
    //"aaa | aaa | a" so have to check all the words not only "aaa", "aaaa" but O(n^2) words
    // public boolean  wordBreak(String s, List<String> wordDict) {
    //     if(s=="") return true;
    //     for(int i=1;i<=s.length();i++){
    //         String sub = s.substring(0,i);
    //         // i =3
    //         // xxx remaining
    //         // 012 345.....
    //         if(checkInDict(sub, wordDict)){
    //             System.out.println(s.substring(i));
    //             return wordBreak(s.substring(i), wordDict);
    //         }
    //         //else i++;
    //     }
    //     return false;
        
    // }
    // private boolean  checkInDict(String sub, List<String> wordDict) {
    //     for(String s : wordDict){
    //         if(s.equals(sub)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public boolean  wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        int maxLen = 0;
        //find the longest length of the word array
        for(String word: wordDict){
            maxLen=Math.max(maxLen, word.length());
        }
        dp[0]=true;//"" -->true
        //i is right at the last position of the sub word
        for(int i=0;i<=len;i++){
            //j is the first position of the sub word
            //subword = s.substring(j,i) [j,i)
            for(int j=i-1;j>=0;j--){
                //if the subword's length larger than longest word in word dict,
                //jump this subword using continue;
                if(i-j>maxLen){
                    continue;
                }
                //dp[j]: the substring before position j can be word break
                if(dp[j]&& wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.print(wb.wordBreak(s,wordDict));
    }
}
