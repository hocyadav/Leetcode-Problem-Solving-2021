package io.hari.problemsolving2021.sharechat;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author Hariom Yadav
 * @create 20-03-2021
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long n = sc.nextLong();
            long r = solve(n);
            System.out.println(r);
            t--;
        }
    }

    static long solve(long N) {
        N = 2 * N + 1;
        long modVal = 1000000000 + 7;
        long m = (N / 2) % modVal;
        long t = (N - m - 1) % modVal;
        long result = (m * t) % modVal;
        result = result % modVal;
        return result;
    }
}

