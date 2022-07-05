package Leetcodes.Leetcode_V1.WarmUp;

import java.util.*;
//349
public class IntersectionOfTwoArrays {
    //Method1: HashSet
    //Time complexity: O(n), Memory: o(n)
    public int[] intersectionHashSet(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for(int n1: nums1){
            set1.add(n1);
        }
        for(int n2: nums2){
            if(set1.contains(n2)){
                res.add(n2);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    //Method2: sort both arrays, 2 pointers
    // Time: O(nlogN) memory 1
    //Time complexity: O(n), Memory: o(n)
    public int[] intersectionSortArray(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0;
        int j = 0;
        while(i<nums1.length && j <nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                res.add(nums1[i]);
                i++;
                j++;
            }
            
        }
        return res.stream().mapToInt(x ->x ).toArray();
    }

        //Method3: sort the shorter array: nlogn
        //Using Binary Search for each element of unsorted array  in the shorter sorted array
        // m* logn
        // if return true, adding the element
        //===> (n+m)logn time
        public int[] intersectionSortAndBinarySearch(int[] nums1, int[] nums2) {
            Set<Integer> res = new HashSet<>();
            if(nums1.length<nums2.length){
                Arrays.sort(nums1);
                for(int n2: nums2){
                    if(!res.contains(n2) && binarySearch(n2, nums1)){
                        res.add(n2);
                    }
                }
            }else{
                Arrays.sort(nums2);
                for(int n1: nums1){
                    if(!res.contains(n1) && binarySearch(n1, nums2)){
                        res.add(n1);
                    }
                }
            }
            return res.stream().mapToInt( k -> k).toArray();

        }

        private boolean binarySearch(int target, int[] nums) {
            int l = 0;
            int r = nums.length-1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(nums[mid]==target){
                    return true;
                }else if(nums[mid]<target){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            return false;
        }
}
