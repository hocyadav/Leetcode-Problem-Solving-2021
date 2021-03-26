package io.hari.problemsolving2021.stack;

/**
 * @Author Hariom Yadav
 * @create 26-03-2021
 */
public class BalancedOrValidInvalidParentheses {
    public static void main(String[] args) {
        String str = "(([{}]))";
        balancedValidParentheses_usingStack(str);
    }

    private static void balancedValidParentheses_usingStack(String str) {
        //traverse char array
        //for all [({ push to stack
        //for all ]}) pop from stack
        //while traversing str if invalid case then return false[i.e. other than above cases]

        //in end if stack is empty then true else false
    }
}
