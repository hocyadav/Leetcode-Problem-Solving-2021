package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

/**
 * @Author hayadav
 * @create 4/26/2021
 */
public class Contest25thApril {

    @Test
    public void test() {
        System.out.println("sum = " + sumBaseConvertOneBaseToAnother_EASY(4, 2));
        System.out.println("sum = " + sumBaseConvertOneBaseToAnother_EASY(5, 2));
        System.out.println("sum = " + sumBaseConvertOneBaseToAnother_EASY(34, 6));
        System.out.println("sum = " + sumBaseConvertOneBaseToAnother_EASY(10, 10));
    }
    /** output:
     * sum = 1
     * sum = 2
     * sum = 9
     * sum = 1
     */

    /**
     * Approach:
     * 1. convert base 10 to another any base
     * 2. simple helper to find sum of all digits
     * https://leetcode.com/problems/sum-of-digits-in-base-k/
     */
    public int sumBaseConvertOneBaseToAnother_EASY(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            final int lastDigit = n % k;//take last digit
            sb.append(lastDigit);
            n = n / k;//reminder , next input will be reminder, remove last digit
        }
        final int digitSum = findDigitSum(Integer.valueOf(sb.reverse().toString()));
        return digitSum;
    }

    public int findDigitSum(int input) {
        int sum = 0;
        while (input > 0 ) {
            sum += input % 10;//take last digit
            input = input / 10;//remove last digit
        }
        return sum;
    }
}
