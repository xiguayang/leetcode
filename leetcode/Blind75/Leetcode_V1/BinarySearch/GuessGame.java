package Leetcodes.Leetcode_V1.BinarySearch;
//374. Guess Number Higher or Lower
public class GuessGame {
    private int picked;
    public int guess(int n) {
        if(n==picked){
            return 0;
        }else if(n<picked){
            return 1;
        }else{
            return -1;
        }
    }
}
