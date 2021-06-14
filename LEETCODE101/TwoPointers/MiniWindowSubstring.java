package TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window substring of s such that every character in t (including duplicates)
 * is included in the window. If there is no such substring, return the empty
 * string “". The test-cases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 */
public class MiniWindowSubstring {
    // Solution : Use sliding window approach. Two pointers l and r are both moving
    // from left to right and l is always to the left of r or == r.
    // Similar to GreedyProblem 763. Partition Labels[M]
    // 1. 先统计 T 中含有的字母==》 使用一个hashmap来记录t中字符出现的次数
    // 2. 窗口左边l 在第一个字母，移动右指针r扩展窗口直到包含T中所有字母
    // 3. 将窗口左侧l右移，仍满足包含T中所有字母,得到一个min窗口，记录其长度
    // 4. 继续向右移动r一步,重复step3，如有更小窗口，记录其长度
    // 5. 重复3直到r到达s最后
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length() || s == null)
            return "";
        // Step 1: use dictionary to recoard the count of all the chars in t
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            // getOrDefault(key,value) get the default value 0 or the count of each char
            int count = dictT.getOrDefault(t.charAt(i), 0);
            // add 1 to the count
            // the duplicates in t also need to be include in substring
            dictT.put(t.charAt(i), count + 1);
        }
        // for(char c : t.toCharArray()){
        // if(dictT.containsKey(c)){
        // dictT.put(c, dictT.get(c)+1);
        // }else{
        // dictT.put(c, 1);
        // }
        // }
        boolean flag = false;
        int l = 0;
        int r = 0;
        int minLen = s.length();
        int minLeft = 0;
        // use count to record chars in s which is also in t
        // when count is eaqual to the number of chars in t,
        int count = 0;
        // move the right pointer, traverse s
        while (r < s.length()) {
            // if char in s is also in dictT
            char c = s.charAt(r);
            if (dictT.containsKey(c)) {
                dictT.put(c, dictT.get(c) - 1);
                if (dictT.get(c) >= 0) {
                    count = count + 1;
                }
            }
            // find one substring satisfies
            while (count == t.length() && l <= r) {
                flag = true;
                int currLen = r - l + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    minLeft = l;
                }

                // Step3: move l to shrink the substring
                char leftC = s.charAt(l);
                if (dictT.containsKey(leftC)) {
                    dictT.put(leftC, dictT.get(leftC) + 1);
                    // if count -1 , not satisfy the requirement
                    // l +1 and end the inside while loop
                    if (dictT.get(leftC) > 0) {
                        count = count - 1;
                    }
                }
                l++;
            }
            r++;
        }
        if (flag) {
            return s.substring(minLeft, minLeft + minLen);
        } else {
            return "";
        }

    }

    public static void main(String[] args) {

        System.out.println(minWindow("bba", "ab"));
    }
}
