package Leetcodes.Blind75.String.Palindrome;

public class PalindromeNum {
    public boolean isPalindromeNum(int x) {
        //negative false
        if(x<0) return false;
        // not 0 but single digit is 0 --> false
        if(x!=0 && x%10 ==0) return false;
        //get the reversed of the int
        int reversed = 0;
        int y = x;
        while(y>0){
            reversed = reversed*10 + y%10;
            y=y/10;
        }
        if(reversed ==x ){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(1/10);
    }
}
