/**
 * #268 Easy Array Bit Manipulation
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array
 */

public class MissingNum {
    // Method 1, sort: slow O(NlogN)
    public int missingNumberSort(int[] nums) {
        //Array, Bit Manipulation
        //1. get the length of nums.length:n, the largest num should be n
        //2. sort the array, traverse the array
        //3. at index i should be i, else the element at index i is missing, return it
        //4. Otherwise the last one, num n is missing
        int n = nums.length;
        Arrays.sort(nums);//O(NlogN)

        // for(int i =0;i<nums.length;i++){
        //     if(nums[i]!=i){
        //         return i;
        //     }
        // }
        // return n;
        //+++++++++++++++++++++++++//
        //One common follow up in Amazon : 
        //the input array is sorted and find the missing number.
        // The idea is to find the first number such that index != nums[index]
        //Since Array is sorted, better using Binary Search than traverse O(LogN)
        int left =0;
        int right = n-1;
        
        while(left <=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>mid){
                rihgt = mid-1;
            }else{
                left = mid+1;
            }
            return left;
        }

    }
        // Method 2, Math Trick: O(N)
        // 1.  get the sum of all numbers if no missing: sum = (1+n)*n/2
        // 2. using the sum to minus all elements in array to get the missing one
    public int missingNumberMath(int[] nums) {
        int n = nums.length;
        int sum = (1+n)*n/2;
        for(int i =0;i<nums.length;i++){
            sum = sum - nums[i];
        }
        return sum;
    }
         // Method 2.1, sum avoid overflow 
        public int missingNumberSumNoOverflow(int[] nums) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += i;
                sum -= nums[i];
            }
            sum += nums.length;
            return sum;
        }

    // Method 3: Bit Manipulate: XOR operation
    // XOR: a^b^b = a: 2 XOR operations with the same numer will eliminate the number and reveal the original number
    // for N numbers, n-1 of numbers must be same with the index of the array
    public int missingNumByXOR(int[] nums){
        int xor = 0;
        for(int i =0;i<nums.length;i++){
            xor = xor ^ i ^ nums[i];
        }
        //DO NOT forget the number n
        return xor ^ nums.length;
    }

    
}
