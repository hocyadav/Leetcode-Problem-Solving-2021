package io.hari.problemsolving2021.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author Hariom Yadav
 * @create 15-03-2021
 */
public class LongestSubString_AllUnique { // 2 pointer
    public static void main(String[] args) {
        longestSubAllUnique("hariomho");//set + 2 pointer
    }

    //all unique -> means use set to store unique,

    /**
     * 2. remove if present
     * 1. always add
     *
     * 3. update result
     */
    public static void longestSubAllUnique(String str) {
        int result = 0;
        Set<Character> set = new LinkedHashSet<>();
        int l = 0;

        for (int r = 0; r < str.length(); r++) {
            System.out.println("entry set = " + set);
            final char curr = str.charAt(r);
            while (set.contains(curr)) { //2. remove if present
                set.remove(str.charAt(l));
                System.out.println("w set = " + set);
                l++;
            }
            set.add(curr);//1. always add
            System.out.println("added set = " + set);
            final int currLength = r - l + 1;
            System.out.println("curr str difference Length = " + currLength);
            System.out.println("set = " + set.size());
            result = Math.max(currLength, result); //3. update result
            System.out.println("result = " + result);
            System.out.println();
        }
        System.out.println("result = " + result);
    }
}
/**
 entry set = []
 added set = [h]
 curr str difference Length = 1
 set = 1
 result = 1

 entry set = [h]
 added set = [h, a]
 curr str difference Length = 2
 set = 2
 result = 2

 entry set = [h, a]
 added set = [h, a, r]
 curr str difference Length = 3
 set = 3
 result = 3

 entry set = [h, a, r]
 added set = [h, a, r, i]
 curr str difference Length = 4
 set = 4
 result = 4

 entry set = [h, a, r, i]
 added set = [h, a, r, i, o]
 curr str difference Length = 5
 set = 5
 result = 5

 entry set = [h, a, r, i, o]
 added set = [h, a, r, i, o, m]
 curr str difference Length = 6
 set = 6
 result = 6

 entry set = [h, a, r, i, o, m]
 w set = [a, r, i, o, m]
 added set = [a, r, i, o, m, h]
 curr str difference Length = 6
 set = 6
 result = 6

 entry set = [a, r, i, o, m, h]
 w set = [r, i, o, m, h]
 w set = [i, o, m, h]
 w set = [o, m, h]
 w set = [m, h]
 added set = [m, h, o]
 curr str difference Length = 3
 set = 3
 result = 6

 result = 6

 *
 */
