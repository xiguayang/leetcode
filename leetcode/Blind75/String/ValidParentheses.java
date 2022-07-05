package Leetcodes.Blind75.String;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Using the HashMap to record the all the matching bracets
public class ValidParentheses {
    public static boolean isValidParentheses(String s){
        Map<Character, Character> matchBrackets = new HashMap<>();
        //closing bracket as key, opening as value
        matchBrackets.put('}', '{');
        matchBrackets.put(']', '[');
        matchBrackets.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++ ){
            Character c = s.charAt(i);
            if(stack.isEmpty() && matchBrackets.containsKey(c)){
                    return false;             
            }
            if(matchBrackets.containsKey(c)){
                if(matchBrackets.get(c).equals(stack.peek())) {
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public  boolean isValidParenthesesII(String s){
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            //traverse the string
            //if c is left parenthese, push corresponding right parenthese into stack
            if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='('){
                stack.push(')');
            }else{//if c is right parenthese
                if(stack.isEmpty()) return false;
                if(stack.pop()!=c) return false;
            }

        }
        //after traverse if stack is empty: valid 
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses("{[[[[]]]]}()()()[]]]"));
        //"[}]"
    }
    
}
