package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz[E] Given an integer n, return a string array answer
 * (1-indexed) where:
 * 
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5. answer[i] == "Fizz" if
 * i is divisible by 3. answer[i] == "Buzz" if i is divisible by 5. answer[i] ==
 * i if non of the above conditions are true.
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: ["1","2","Fizz"] Example 2:
 * 
 * Input: n = 5 Output: ["1","2","Fizz","4","Buzz"]
 */
public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList();
        int i = 1;
        while (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                result.add("Fizz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        fizzBuzz(5);
    }
}
