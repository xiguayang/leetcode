package Leetcodes.Leetcode_V1.BinarySearch;
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
//374. Guess Number Higher or Lower
public class GuessNumHighLow extends GuessGame{
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while(lo<=hi){
            int mid = lo+ (hi-lo)/2;
            if(guess(mid)==1){//mid <picked
                lo = mid+1;
            }else if(guess(mid)==-1){//mid > picked
                hi = mid-1;
            }else if(guess(mid)==0){
                return mid;
            }
        }
        return -1;
    }
}
