package GreedyAlgrithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels[M] A string s of lowercase English letters is given. We
 * want to partition this string into as many parts as possible so that each
 * letter appears in at most one part, and return a list of integers
 * representing the size of these parts.
 * 
 */
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
// splits s into less parts
public class PartitionLabels {
    // Solution: 1. get the all the last positions of each char, assgin them to an
    // int array
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        // 1. get all last positions of each char
        int[] lastPositions = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // get the position of the current char
            char x = s.charAt(i);
            lastPositions[x - 'a'] = i;
        }
        // 2. traverse the string by check the last position of each char
        int subStringstart = 0;
        int subStringlast = 0;
        for (int i = 0; i < s.length(); i++) {
            // get the current char
            char curr = s.charAt(i);
            // get the last position of curr from the position array
            int last = lastPositions[curr - 'a'];
            // if the last position of curr is behind the subStringlast, expand the
            // substring
            if (last > subStringlast) {
                subStringlast = last;
            }
            // if current position is the last position, get one sub string
            if (subStringlast == i) {
                // add the length of the substring to result
                result.add(subStringlast - subStringstart + 1);
                subStringstart = subStringlast + 1;
            }
        }
        return result;
    }
}
