package io.hari.problemsolving2021.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author Hariom Yadav
 * @create 23-03-2021
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class PhoneNumCombination {
    private static List<String> result = new LinkedList<>();
    private static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mnop");
        map.put(7, "qrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        String digitArray = "23";
        rec(digitArray, 0, "");
        System.out.println("result = " + result);
    }

    private static void rec(String digitArray, int index, String current) {
        //1 null, valid , invalid check
        if (index > digitArray.length()) return;
        if (current.length() == digitArray.length()) {
            result.add(current);
            return;
        }
        //2 get digit value from map
        final int i = digitArray.charAt(index) - '0';
        final String mapVal = map.get(i);

        //3 for each char call recursion
        for (char c : mapVal.toCharArray()) {
            String curr = current + c;
            rec(digitArray, index + 1, curr);
        }
    }
}
/**
 result = [ad, ae, af, bd, be, bf, cd, ce, cf]
 */
