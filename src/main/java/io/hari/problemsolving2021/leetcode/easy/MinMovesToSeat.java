package io.hari.problemsolving2021.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
 */
public class MinMovesToSeat {
    @Test
    public void foo() {
        System.out.println("minMovesToSeat = " + minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
        System.out.println("minMovesToSeat2 = " + minMovesToSeat2(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
    }

    public int minMovesToSeat(int[] seats, int[] students) {//using stream
        Arrays.sort(seats);
        Arrays.sort(students);
        return IntStream.range(0, seats.length)
                .map(i -> Math.abs(seats[i] - students[i]))
                .sum();
    }

    public int minMovesToSeat2(int[] seats, int[] students) {//simple approach
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for (int i = 0; i < seats.length; i++) {
            int n = Math.abs(seats[i] - students[i]);
            result += n;
        }
        return result;
    }
}
