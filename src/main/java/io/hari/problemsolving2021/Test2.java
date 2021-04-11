package io.hari.problemsolving2021;

/**
 * @Author Hariom Yadav
 * @create 31-03-2021
 */
public class Test2 {
    public static void main(String[] args) {
        fun("abcd", "abc");
        fun("abcabcd", "abcabcd");
        fun("abcabcd", "");
        final String substring = "hariom".substring(5, 6);
        System.out.println("substring = " + substring);
    }

    private static void fun(String str1, String str2) {
        int count = 0;
        int p1 = 0, p2 = 0;
        while (p1 < str1.length() && p2 < str2.length()) {
            if (str1.charAt(p1) != str2.charAt(p2)) {
                break;
            }
            count++;
            p1++;
            p2++;
        }
        System.out.println("count = " + count);
    }
}
