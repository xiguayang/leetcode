/**
 * 136. Single Number: array Bit Manipulate
 * has only one unique element in array, using XOR
 */
public class SingleNums {
    public int singleNumber(int[] nums) {
        //Method 1: O(N) with HashSet
        //1. using a hashset to store all unique nums
        //2. calculate the sum of nums in hashset, 
        //3. sumOfHashSet*2 - the sum of array
        HashSet<Integer> hs = new HashSet<>();
        int sum =0;
        int sumOfHs = 0;
        for(int n: nums){
            if(!hs.contains(n)){
                hs.add(n);
                sumOfHs = sumOfHs + n;
            }
            sum = sum+n;
        }
        return sumOfHs*2-sum;
    }

    public int singleNumberUsingXOR(int[] nums) {
        //Method 2: using Bit Manipulate: XOR a^b^a = b
        int xor=nums[0];
        for(int i=1;i<nums.length;i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}
