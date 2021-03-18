package io.hari.problemsolving2021.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Hariom Yadav
 * @create 15-03-2021
 */
public class LongestSubString_onlyK_char {

    public static void main(String[] args) {
        longestSubStringWithKChar("aaacbcc");//map + 2 pointers
    }
    //can contain duplicates also

    /**
     * 1. always add
     * 2. remove if target length exceeds
     *
     * 3. update result
     */
    public static void longestSubStringWithKChar(String str) {// 2 pointers
        int result = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        int l = 0;

        for (int r = 0; r < str.length(); r++) {
            final char curr = str.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0) + 1);//1. always add
            System.out.println("map o= " + map);

            while (map.size() > 2) { //2. remove if target length exceeds
                final char left = str.charAt(l);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0)
                    map.remove(left);
                l++;
                System.out.println("map i= " + map);
            }
            result = Math.max(result, r - l + 1); //3. update result
            System.out.println("result = " + result);
        }

        System.out.println("result = " + result);
    }

}

/**
 map o= {a=1}
 result = 1
 map o= {a=2}
 result = 2
 map o= {a=3}
 result = 3
 map o= {a=3, c=1}
 result = 4
 map o= {a=3, c=1, b=1}
 map i= {a=2, c=1, b=1}
 map i= {a=1, c=1, b=1}
 map i= {c=1, b=1}
 result = 4
 map o= {c=2, b=1}
 result = 4
 map o= {c=3, b=1}
 result = 4
 result = 4
 */
