package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

/**
 * https://leetcode.com/contest/weekly-contest-258/problems/reverse-prefix-of-word/
 */
public class Contest12thSep {
    @Test
    public void easyTest(){
        System.out.println("reversePrefix = " + reversePrefix("abcdefd", 'd'));
        System.out.println("reversePrefix = " + reversePrefix("xyxzxe", 'z'));
        System.out.println("reversePrefix = " + reversePrefix("abcd", 'z'));
    }
    public String reversePrefix(String word, char ch) {
        char[] charArray = word.toCharArray();
        int lastIndex = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ch) {
                lastIndex = i;
                break;
            }
        }
        char[] chars = reverseArray(charArray, 0, lastIndex);
        return new String(chars);
    }

    private char[] reverseArray(char[] charArray, int startIndex, int lastIndex) {
        while (startIndex <= lastIndex) {
            //reverse
            char temp = charArray[startIndex];
            charArray[startIndex] = charArray[lastIndex];
            charArray[lastIndex] = temp;
            //move pointer
            startIndex++;
            lastIndex--;
        }
        return charArray;
    }
}
