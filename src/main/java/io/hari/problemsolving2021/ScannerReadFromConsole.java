package io.hari.problemsolving2021;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @Author Hariom Yadav
 * @create 11-03-2021
 */
public class ScannerReadFromConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();//send str input like : hariom yadav 9887700499
        System.out.println("nextLine = " + nextLine);
        //split by spaces and read each str
        final String[] split = nextLine.split(" ");
        Arrays.stream(split).forEach(i -> System.out.println("i = " + i));

        final String next = scanner.next();//read only 1st string , if input is hariomm yadav then it will read only hariom
        System.out.println("next = " + next);

        final int nextInt = scanner.nextInt();//this is continuous of above scanner.next, if we put "hari om" then error "hari 123" is correct
        System.out.println("nextInt = " + nextInt);

        int[][] task = new int[][]{};
        Arrays.stream(task);
    }
}
