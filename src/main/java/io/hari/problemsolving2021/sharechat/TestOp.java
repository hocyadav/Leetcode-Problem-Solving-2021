package io.hari.problemsolving2021.sharechat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Hariom Yadav
 * @create 20-03-2021
 */
public class TestOp {
    public static void main(String[] args) {

    }
    
    static long solve(int N, int[] Arr) {
        List<Integer> list = Arrays.stream(Arr).boxed().collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();

        while (list.size() > 0) {
            getMaxGCD(list, ans);
        }
        int answ = 0;
        for (int i = N; i >= 1; i--) {
            answ += ans.get(N - i) * i;
        }
        return answ;
    }

    static List<Integer> getMaxGCD(List<Integer> list, List<Integer> ans) {
        int n = list.size();
        int maxgcd = -1;
        int ii = -1;
        int jj = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int gcd = gcd(list.get(i), list.get(j));
                if (gcd > maxgcd) {
                    ii = i;
                    jj = j;
                    maxgcd = gcd;
                }
            }
        }
        list.remove(ii);
        ans.add(maxgcd);
        if (jj < ii) {
            list.remove(jj);
        } else list.remove(jj - 1);
        return list;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}