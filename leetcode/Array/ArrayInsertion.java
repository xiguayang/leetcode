package Array;
/**ADD items into array consider from the end to the left*/
public class ArrayInsertion {

        public static int[] sortedSquares(int[] nums) {
            //traverse the array use left and right two pointers
            int l = 0;
            int r = nums.length-1;
            int[] result = new int[nums.length];
            for(int i = result.length-1;i>=0;i--){
                //all numbers >= 0
                if(nums[0]>=0){
                    result[i] = nums[i]*nums[i];
                    //all numbers <= 0
                }else if(nums[nums.length-1]<=0){
                    result[i] = nums[result.length-1-i]*nums[result.length-1-i];
                    //0 is in the array
                }else{
                    if(nums[l]*nums[l]>nums[r]*nums[r]){
                        result[i]=nums[l]*nums[l];
                        l = l+1;
                    }else{
                        result[i]=nums[r]*nums[r];
                        r = r-1;
                    }
                }
            }
            return result;
        }
/**Given a fixed length array arr of integers,
 * duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place,
 * do not return anything from your function.
 * Example 1:
 *      Input: [1,0,2,3,0,4,5,0]
 *      Output: null
 *      Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]*/
    public static void duplicateZeros(int[] arr) {
        /*duplicate a 0 and move elements behind to the right
        /*From right to the left*/
        for(int i = 0; i<arr.length; i++){
            if(arr[i]==0){
                for(int j = arr.length-1;j>i;j--){
                    arr[j] = arr[j-1];
                }
                i=i+1;
            }
        }
    }
    /**Given two sorted integer arrays nums1 and nums2,
     * merge nums2 into nums1 as one sorted array.
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has a size equal to m + n
     * such that it has enough space to hold additional elements from nums2.*/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //from end right to the left
        //the most right number in nums1
        int j = m -1;
        //the most right number in nums2
        int k = n -1;
        //index of the most right position of the array
        int index = m+n-1;
        while (j >= 0 && k >= 0) {
            if(nums1[j]>nums2[k]){
                nums1[index] = nums1[j];
                j = j-1;
            }else{
                nums1[index] = nums2[k];
                k= k-1;
            }
            index--;
        }
        //nums2 has more to combine
        while(k>=0){
            nums1[index] = nums2[k];
            k--;
            index--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] nums2 = {1,0,2,3,0,4,5,0};
        ArrayInsertion.duplicateZeros(nums2);
        int[] nums3 = new int[]{1, 2, 3, 0, 0, 0};
        ArrayInsertion.merge(nums3,3,new int[]{2,5,6},3);
        //int[] result = sortedSquares(nums);

        for(int x : nums3){
            System.out.print(x + " ");
        }
    }


}
