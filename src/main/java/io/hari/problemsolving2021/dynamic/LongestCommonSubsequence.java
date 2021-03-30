package io.hari.problemsolving2021.dynamic;

import static io.hari.problemsolving2021.leetcode.WallsAndGate_GraphProblem_n_01Matrix.print2DArray;

/**
 * @Author Hariom Yadav
 * @create 30-03-2021
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "bcde";
        //start rec from last
        final int lcsLength = recLCSAlgo(str1, str2, str1.length(), str2.length());
        System.out.println("lcsLength = " + lcsLength);

        recLCSAlgo_withMemoization(str1, str2, str1.length(), str2.length());//same as above just added dp array

        System.out.println("lcsLength2 = " + recLCSAlgo("hariom", "", "hariom".length(), "".length()));
        System.out.println("lcsLength3 = " + recLCSAlgo("hariom", "ha", "hariom".length(), "ha".length()));
        System.out.println("lcsLength3 = " + recLCSAlgo("hariom", "xyzha123", "hariom".length(), "xyzha123".length()));

    }

    private static void recLCSAlgo_withMemoization(String str1, String str2, int s1len, int s2len) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        recUtil(str1, str2, s1len, s2len, dp);
        print2DArray(dp);
        System.out.println("dp[s1len][s2len] = " + dp[s1len][s2len]);
    }

    private static int recUtil(String str1, String str2, int s1len, int s2len, int[][] dp) {
        if (s1len == 0 || s2len == 0) {
            dp[s1len][s2len] = 0;
            return dp[s1len][s2len];
        }
        ;
        if (str1.charAt(s1len - 1) == str2.charAt(s2len - 1)) {
            final int oneStepBack = 1 + recUtil(str1, str2, s1len - 1, s2len - 1, dp);
            dp[s1len][s2len] = oneStepBack;
            return dp[s1len][s2len];
        } else {
            final int case1 = recUtil(str1, str2, s1len - 1, s2len, dp);
            final int case2 = recUtil(str1, str2, s1len, s2len - 1, dp);
            dp[s1len][s2len] = Math.max(case1, case2);
            return dp[s1len][s2len];
        }
    }

    /**
     * start from last
     * so only 2 case same or different
     * if same : 1 + call recursion and subtract that common char
     * if not same : 2 cases : take last char s1 and dont take last char s2,case 2: negation of case1
     */
    private static int recLCSAlgo(String str1, String str2, int s1len, int s2len) {
        if (s1len == 0 || s2len == 0) return 0;

        if (str1.charAt(s1len - 1) == str2.charAt(s2len - 1)) {//last char matched
            final int oneStepBack = 1 + recLCSAlgo(str1, str2, s1len - 1, s2len - 1);
            return oneStepBack;
        } else {
            final int case1 = recLCSAlgo(str1, str2, s1len - 1, s2len);
            final int case2 = recLCSAlgo(str1, str2, s1len, s2len - 1);
            return Math.max(case1, case2);
        }
    }
}
/**
 lcsLength = 4
 0 0 0 0 0
 0 0 0 0 0
 0 1 0 0 0
 0 0 2 0 0
 0 0 0 3 0
 0 0 0 0 4
 --------------
 dp[s1len][s2len] = 4
 lcsLength2 = 0
 lcsLength3 = 2
 lcsLength3 = 2

 */
