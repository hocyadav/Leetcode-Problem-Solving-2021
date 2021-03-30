package io.hari.problemsolving2021.dynamic;

/**
 * @Author Hariom Yadav
 * @create 30-03-2021
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "bcde";
        final int lcsLength = recLCSAlgo(str1, str2, str1.length() - 1, str2.length() - 1);//start rec from last
        System.out.println("lcsLength = " + lcsLength);
    }

    /**
     * start from last
     * so only 2 case same or different
     * if same : 1 + call recursion and subtract that common char
     * if not same : 2 cases : take last char s1 and dont take last char s2,case 2: negation of case1
     */
    private static int recLCSAlgo(String str1, String str2, int lastIndexS1, int lastIndexS2) {
        if (lastIndexS1 == 0  || lastIndexS2 == 0) return 0;

        if (str1.charAt(lastIndexS1) == str2.charAt(lastIndexS2)) {//last char matched
            final int len = 1 + recLCSAlgo(str1, str2, lastIndexS1 - 1, lastIndexS2 - 1);
            return len;
        } else {
            final int case1 = recLCSAlgo(str1, str2, lastIndexS1 - 1, lastIndexS2);
            final int case2 = recLCSAlgo(str1, str2, lastIndexS1, lastIndexS2 - 1);
            return Math.max(case1, case2);
        }
    }
}
/**
 lcsLength = 3
 */
