/**
 *  Easy Array (268)
 * 448. Find All Numbers Disappeared in an Array
 * Given an array nums of n integers where nums[i] is in the range [1, n], 
 * return an array of all the integers in the range [1, n] that do not appear in nums
 */
public class FindAllMissingNums {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        //Method1: O(N) but with extra space
        //1. add the numbers into HashSet:hs
        //2. traverse numbers from 1 to n
        //3. if hs contains the number, continue
        //.  else add the number to res
        
        // HashSet<Integer> hs = new HashSet<>();
        // for(int i =0;i<n;i++){
        //     if(!hs.contains(nums[i])){
        //         hs.add(nums[i]);
        //     }
        // }
        // int j = 1;
        // while(j<=n){
        //     if(!hs.contains(j)){
        //         res.add(j);
        //     }
        //     j++;
        // }
        // return res;
        
        
        //Method 2: inplace sort the array: O(N) but no extra space
        // 1. traverse the array i = 0
        // 2. if nums[i]==i+1, i++
        // 2. or if (nums[nums[i]-1]==nums[i]) i++
        // 3. else: swap: nums[i] with nums[nums[i]-1]
        int i =0;
        while(i<n){
            int num = nums[i];
            if(num==i+1 || nums[num-1]==num){
                i=i+1;
            }else{
                //swap nums[i] and nums[num-1]
                int temp = nums[num-1];
                nums[i] = temp;
                nums[num-1]=num;
            }
        }
        //4. traverse the sorted array[actually in-place array, numbers at index of missing nums is not sorted]
        for(int x=0;x<n;x++){
            if(nums[x]!=x+1){
                res.add(x+1);
            }
        }
        return res;
        
    }
    
}
