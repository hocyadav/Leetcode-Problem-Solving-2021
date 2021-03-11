package io.hari.problemsolving2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Hariom Yadav
 * @create 11-03-2021
 */
public class ScannerReadFromConsole2 {
    /**
     * Input: copy paste or type both will work
     *
2
3
sak 5 varun 7 vijay 3
sak
4
csdb 4 dsh 5 askj 8 adfs 9
dptu

     */
    public static void main(String[] args) {
        final Map<String, Integer> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int testCaseNum = scanner.nextInt();
        while (testCaseNum > 0) {
            final int values = scanner.nextInt();
            for (int i = 0; i < values; i++) {
                final String key = scanner.next();
                final int value = scanner.nextInt();
                map.put(key, value);
            }

            final String find = scanner.next();
            if (map.containsKey(find)) {
                System.out.println("find = " + map.get(find));
            } else {
                System.out.println("Not found ");
            }

            testCaseNum--;
        }

    }
}
