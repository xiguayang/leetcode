package Leetcodes.Blind75.Array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //Brute Force: o(N^2)
        //int max =0;
        // for (int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         max = Math.max(Math.min(height[i],height[j])*(j-i),max);
        //     }
        // }
        //return max;
        
        //Method 2: using 2 pointers; O(n)
        int l =0;
        int r = height.length-1;
        int max = 0;
        while(l<r){
            max =Math.max(Math.min(height[l],height[r])*(r-l),max);
            if(height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
    
}
