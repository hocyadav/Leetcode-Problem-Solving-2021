package io.hari.problemsolving2021.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 25-03-2021
 */
public class GenerateParentheses {
    static List<String> result = new LinkedList<>();
    public static void main(String[] args) {
        final int length = 3;
        generateParenthesesOfLen_usingRecursion(length);
        System.out.println("result = " + result);
        generateParenthesesOfLen_usingRecursion(1);
        System.out.println("result = " + result);
    }

    private static void generateParenthesesOfLen_usingRecursion(int len) {
        result.clear();
        int leftLen = len;
        int rightLen = len;
        rec("", leftLen, rightLen);
    }

    private static void rec(String current, int leftLen, int rightLen) {
        if (leftLen > rightLen) return;//null check, valid invalid check
        if (leftLen == 0 && rightLen == 0) { //small problem solution
            result.add(current);
            return;
        }
        if (leftLen > 0) rec(current + "(", leftLen - 1, rightLen);
        if (rightLen > 0) rec(current + ")", leftLen, rightLen - 1);
    }
}
/**
 result = [((())), (()()), (())(), ()(()), ()()()]
 result = [()]
 */
