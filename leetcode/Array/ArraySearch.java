package Array;
/**linear Search
 * Binary Search
 * */

public class ArraySearch {
    /**Check If N and Its Double Exist
     * Given an array arr of integers,
     * check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
     *More formally check if there exists two indices i and j such that :
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     *
     * Example 1:
     * Input: arr = [10,2,5,3]
     * Output: true
     * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

     * Example 3:
     * Input: arr = [3,1,7,11]
     * Output: false
     * Explanation: In this case does not exist N and M, such that N = 2 * M.
     *
     * Constraints:
     * 2 <= arr.length <= 500
     * -10^3 <= arr[i] <= 10^3*/
    public static boolean checkIfExist(int[] arr) {
        for(int i = 0; i<arr.length-1;i++){

            for(int j =i+1;j<arr.length;j++){
                if(arr[i]*2==arr[j]||arr[j]*2==arr[i]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Valid Mountain Array
     *
     * Given an array of integers arr, return true if and only if it is a valid mountain array.
     *
     * Recall that arr is a mountain array if and only if:
     *
     * arr.length >= 3
     * There exists some i with 0 < i < arr.length - 1 such that:
     * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     * Example 2:
     * Input: arr = [3,5,5]
     * Output: false
     * Example 3:
     * Input: arr = [0,3,2,1]
     * Output: true
     *
     * Constraints:
     * 1 <= arr.length <= 104
     * 0 <= arr[i] <= 104*/
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        //walk through to find the peek
        while(i<n-1 && arr[i]<arr[i+1]){
            i++;
        }
        //peak cannot be at the first or last
        if(i==0 || i==n-1){
            return false;
        }

        //walk down
        while(i<n-1 && arr[i]>arr[i+1]){
            i++;
        }
        //if i arrives end, it's a mountain
        if(i==n-1){
            return true;
        }else
            return false;

    }
    public static void main(String[] args) {
        int[] arr = new int[]{0,3,4};
        checkIfExist(arr);
        System.out.println(validMountainArray(arr));

    }
}
