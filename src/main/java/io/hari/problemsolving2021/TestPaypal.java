package io.hari.problemsolving2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Hariom Yadav
 * @create 27-03-2021
 */
public class TestPaypal {// op

    static int[] pre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        pre = preCompute();
        for (int t_i = 0; t_i < T; t_i++) {
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);

            long out_ = solve(l, r);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    static long solve(int l, int r) {
        // Your code goes here
        return pre[r] - pre[l];

    }

    static int[] preCompute() {
        int t = 1000000;
        Map<Integer, Boolean> map = new HashMap<>();//storing both beautiful + non beautiful

        int[] pre = new int[t + 1];
        int countFoundTillThisIndex = 0;
        for (int i = 1; i <= t; i++) {

            boolean isBeautifulNumber = dfs(i, map, new HashSet<Integer>());
            if (isBeautifulNumber == true) countFoundTillThisIndex += i;//previous + current inedx ??
            pre[i] = countFoundTillThisIndex;
        }
        return pre;

    }

    static boolean dfs(int n, Map<Integer, Boolean> map, Set<Integer> set) {
        if (map.get(n) != null && map.get(n)) return true;//present in map, whatever it is return
        if (set.contains(n)) return false;//already visited. cycle

        set.add(n);

        int sum = 0;
        int t = n;

        while (t > 0) {//digit sum
            sum += (t / 10) * (t / 10);
            t /= 10;
        }

        if (sum == 1) {
            map.put(n, true);
            return true;
        } else {
            boolean f = dfs(sum, map, set);
            map.put(n, f);
            return f;
        }
    }
}

