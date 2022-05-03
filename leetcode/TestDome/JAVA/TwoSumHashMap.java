package TestDome.JAVA;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class TwoSumHashMap {
    
        
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> numPositions = new HashMap<Integer, Integer>();
        System.out.println("sum: " + sum);
        if (list == null || list.length <= 1)
            return null;
        
        for (int i = 0; i < list.length; i++) {
            int toRetrieve = sum - list[i]; 
            if (numPositions.containsKey(toRetrieve)) {
                //if (toRetrieve + list[i] == sum) 
                return new int[]{numPositions.get(toRetrieve), i};
            }
            numPositions.put(list[i], i);
            
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 3, 9}, 5);
        int[] indices2 = findTwoSum(new int[] { 1, 3, 5, 3, 9}, 6);
        int[] indices3 = findTwoSum(new int[] { 1, 2}, 5);
        if (indices != null) {
            System.out.println("indices: " + indices[0] + " " + indices[1]);
        }
        if (indices2 != null) {
            System.out.println("indices2: " + indices2[0] + " " + indices2[1]);
        }
        if (indices3 != null) {
            System.out.println("indices3: " + indices3[0] + " " + indices3[1]);
        }
    }
}
