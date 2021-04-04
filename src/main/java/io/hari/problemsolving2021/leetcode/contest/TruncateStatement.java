package io.hari.problemsolving2021.leetcode.contest;

import org.junit.Test;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 04-04-2021
 */
public class TruncateStatement {

    @Test
    public void test() {
        System.out.println("s = " + truncateSentence("Hello how are you Contestant", 4));
        System.out.println("s = " + truncateSentence("What is the solution to this problem", 4));
        System.out.println("s = " + truncateSentence("chopper is not a tanuki", 5));

        final int[] ans = findingUsersActiveMinutes(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5);
        print1DArray(ans);
        final int[] ans2 = findingUsersActiveMinutes(new int[][]{{1,1},{2,2},{2,3}}, 4);
        print1DArray(ans2);
    }

    private void print1DArray(int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    public String truncateSentence(String s, int k) {
        final String[] split = s.split(" ");
        System.out.println("split = " + Arrays.deepToString(split));
        if (split.length < k) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(split[i] + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Set<String> set = new HashSet<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int[] l : logs) {
            final String e = "" + l[0] +"#"+ l[1];
            if (set.add(e) == true)//add to set
                map.put(l[0], map.getOrDefault(l[0], 0) + 1);//after adding to set perform operation

        }
        System.out.println("set = " + set);
        System.out.println("map = " + map);

        int[] answer = new int[k];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {//todo : iterate through map.values
            final Integer key = e.getKey();
            final Integer value = e.getValue();

            final int index = value - 1;
            if (index >= 0) //null check oprional
                answer[index]++;
        }
        return answer;
    }


}

/**
 split = [Hello, how, are, you, Contestant]
 s = Hello how are you
 split = [What, is, the, solution, to, this, problem]
 s = What is the solution
 split = [chopper, is, not, a, tanuki]
 s = chopper is not a tanuki
 set = [1#2, 1#3, 0#5, 0#2]
 map = {0=2, 1=2}
 0 2 0 0 0
 set = [2#2, 2#3, 1#1]
 map = {1=1, 2=2}
 1 1 0 0
 */
