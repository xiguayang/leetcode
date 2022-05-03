package TestDome.JAVA;

import java.util.Arrays;

// Implement function countNumbers that accepts a sorted array of unique integers and, 
//efficiently with respect to time used, counts the number of array elements that are less than the parameter lessThan.

// For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int lengthOfArray = sortedArray.length;
        if (lengthOfArray == 0) return 0;

        if (sortedArray[0] >= lessThan) return 0;

        if (sortedArray[lengthOfArray - 1] < lessThan) return lengthOfArray;

        // int index = Arrays.binarySearch(sortedArray, lessThan);
        // if (index < 0)
        //     return ~index;

        // return index;
        int l = 0, r = lengthOfArray-1;
        int mid =0;
        while(l<=r){
            mid =l+(r-l)/2;
            if(sortedArray[mid]<lessThan){
                //value of index at mid is less than lessthan but arr[mid+1]>=lessthan
                if(mid+1<=lengthOfArray-1 && sortedArray[mid+1]>=lessThan){
                    return mid+1;
                }else{
                    //search right part
                    l = mid+1;
                }
            }else{
                r = mid-1;
            }
        }
        return l;
    
    }
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}

