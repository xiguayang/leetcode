package Patterns.Arrays.Easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
        //Method1 Sort: O(NLogN) O(1)Space
        public int majorityElement(int[] nums) {
            //no matter n is even or odd number, since majority is over n/2
            //the element at n/2 index must be the majority
            //1 2 3 3 3
            //    -----
            //0 1 2 3 4  
            
            //1 3 3 3 3 5
            //  -------
            //1 1 1 1 3 5
            //-------
            //0 1 2 3 4 5
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
        //Method2: Using HashMap to record the times of each num
        //Time: O(n), Space: O(n)
        public int majorityElementHashMap(int[] nums) {
            //Using HashMap to count the times of each element
            //<num, times>
            HashMap<Integer, Integer> counts = new HashMap<>();
            for(int num : nums){
                if(!counts.containsKey(num)){
                    counts.put(num, 1);
                }else{
                    counts.put(num,counts.get(num)+1);
                }
            }
            Map.Entry<Integer, Integer> majorEntry = null;
            for(Map.Entry<Integer,Integer> entry: counts.entrySet()){
                if(majorEntry==null || entry.getValue()>majorEntry.getValue()){
                    majorEntry=entry;
                }
            }
            return majorEntry.getKey();
        }

        //Method 3: Boyer-Moore Voting Algorithm
        //Time: O(n), Space: O(1)
        //
        public int majorityElementBoyerMoore(int[] nums) {
            //仅遍历一遍数组，因为保证有元素出现大于n/2次
            //step1: 初始count =0；
            //step2: 如果 count==0， candidate 选择此元素，并将count设为1
            //step3: 如果count !=0， 此元素于candidate相同，count++；于candidate不同，count--；
            int candidate = -1;
            int count = 0;
            for(int num: nums){
                if(count == 0){
                    candidate = num;
                    count = 1;
                    
                }else if(num == candidate){
                    count++;
                }else{
                    count --;
                }
            }
                return candidate;
        }
}
