package io.hari.problemsolving2021.dynamic;

import static io.hari.problemsolving2021.leetcode.WallsAndGate_GraphProblem_n_01Matrix.print2DArray;

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

        recLCSAlgo_withMemoization(str1, str2, str1.length() - 1, str2.length() - 1);//same as above just added dp array
    }

    private static void recLCSAlgo_withMemoization(String str1, String str2, int lastIndexS1, int lastIndexS2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        recUtil(str1, str2, lastIndexS1, lastIndexS2, dp);
        print2DArray(dp);
        System.out.println("dp[lastIndexS1][lastIndexS2] = " + dp[lastIndexS1][lastIndexS2]);
    }

    private static int recUtil(String str1, String str2, int lastIndexS1, int lastIndexS2, int[][] dp) {
        if (lastIndexS1 == 0 || lastIndexS2 == 0) {
            dp[lastIndexS1][lastIndexS2] = 0;
            return dp[lastIndexS1][lastIndexS2];
        }
        ;
        if (str1.charAt(lastIndexS1) == str2.charAt(lastIndexS2)) {
            final int oneStepBack = 1 + recUtil(str1, str2, lastIndexS1 - 1, lastIndexS2 - 1, dp);
            dp[lastIndexS1][lastIndexS2] = oneStepBack;
            return dp[lastIndexS1][lastIndexS2];
        } else {
            final int case1 = recUtil(str1, str2, lastIndexS1 - 1, lastIndexS2, dp);
            final int case2 = recUtil(str1, str2, lastIndexS1, lastIndexS2 - 1, dp);
            dp[lastIndexS1][lastIndexS2] = Math.max(case1, case2);
            return dp[lastIndexS1][lastIndexS2];
        }
    }

    /**
     * start from last
     * so only 2 case same or different
     * if same : 1 + call recursion and subtract that common char
     * if not same : 2 cases : take last char s1 and dont take last char s2,case 2: negation of case1
     */
    private static int recLCSAlgo(String str1, String str2, int lastIndexS1, int lastIndexS2) {
        if (lastIndexS1 == 0 || lastIndexS2 == 0) return 0;

        if (str1.charAt(lastIndexS1) == str2.charAt(lastIndexS2)) {//last char matched
            final int oneStepBack = 1 + recLCSAlgo(str1, str2, lastIndexS1 - 1, lastIndexS2 - 1);
            return oneStepBack;
        } else {
            final int case1 = recLCSAlgo(str1, str2, lastIndexS1 - 1, lastIndexS2);
            final int case2 = recLCSAlgo(str1, str2, lastIndexS1, lastIndexS2 - 1);
            return Math.max(case1, case2);
        }
    }
}
/**
 lcsLength = 3
 0 0 0 0 0
 0 0 0 0 0
 0 1 0 0 0
 0 0 2 0 0
 0 0 0 3 0
 0 0 0 0 0
 --------------
 dp[lastIndexS1][lastIndexS2] = 3

 */
