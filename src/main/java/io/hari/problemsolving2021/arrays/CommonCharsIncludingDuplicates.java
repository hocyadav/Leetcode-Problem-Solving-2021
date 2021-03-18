package io.hari.problemsolving2021.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 18-03-2021
 */
public class CommonCharsIncludingDuplicates { //see intersection of 2 arrays
    public static void main(String[] args) {
        final String[] arr = {"bella", "label", "roller"};
        findCommonChar(arr);
        findCommonChar(new String[]{"cook", "lock", "cook"});
    }

    /**
     * approach : global count + update local count
     * 1. traverse from i = a to z
     * 2. for above each char, then traverse str array
     * 3. find min count for each character
     * 4. for loop for min count char + add to result list
     */
    private static void findCommonChar(String[] arr) {
        List<String> result = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            int char_i_GlobalMinCount = Integer.MAX_VALUE;

            for (String str : arr) {
                int char_i_localCharCount = 0;
                for (char c : str.toCharArray()) {
                    if (c == i) char_i_localCharCount++;
                }
                char_i_GlobalMinCount = Math.min(char_i_GlobalMinCount, char_i_localCharCount);
            }//traversal of all string array with single char 'a' done, now we have min count of 'a'
            for (int j = 0; j < char_i_GlobalMinCount; j++) result.add("" + i); //add char that many times in result
        }

        System.out.println("result = " + result);
    }
}
/**
 result = [e, l, l]
 result = [c, k, o]
 **/