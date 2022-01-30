package io.hari.problemsolving2021.leetcode.easy;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        // 1. no digit 0-9 + lowercase a-z + 2 + 3
        // 2. 0-1 : - , location : surrownded by az (i.e. not in end or start)
        // 3. 0-1 : puch mark (! . , space) , localtion : at end


        String noDigit = "[^0-9]*";
        Pattern pattern = Pattern.compile(noDigit);//* === {0,}
        System.out.println("pattern.matcher(\"1234\").matches() = " + pattern.matcher("1234").matches());
        System.out.println("pattern.matcher(\"abc\").matches() = " + pattern.matcher("abc").matches());


        String lower = "[a-z]+";
        String hiphen01 = "[\\-]+";
        String reg = lower + hiphen01 + lower;
        Pattern pattern2 = Pattern.compile(reg);
        System.out.println("matches = " + pattern2.matcher("a-b").matches());
        System.out.println("matches = " + pattern2.matcher("a-b.").matches());
        System.out.println("matches = " + pattern2.matcher("a-").matches());
        System.out.println("matches = " + pattern2.matcher("-bn").matches());

        String punch = "[\\!\\.\\, ]{1}";
        Pattern compile = Pattern.compile(punch);
        System.out.println("compile.matcher(\"!.\").matches() = " + compile.matcher("!.").matches());//more than 1
        System.out.println("compile.matcher(\"!\").matches() = " + compile.matcher("!").matches());//only one
        System.out.println("compile.matcher(\" \").matches() = " + compile.matcher(" ").matches());


        String final1 = reg + punch;
        System.out.println("Pattern.compile(final1).matcher(\"a-b.\").matches() = " + Pattern.compile(final1).matcher("a-b.").matches());
        System.out.println("Pattern.compile(final1).matcher(\"pencil-sharpener.\").matches() = " + Pattern.compile(final1).matcher("pencil-sharpener.").matches());


        String end = lower + punch;
        Pattern pattern1 = Pattern.compile(end);
        System.out.println("pattern1.matcher(\"abc?\").matches() = " + pattern1.matcher("abc!").matches());
        System.out.println("pattern1.matcher(\"!abc\").matches() = " + pattern1.matcher("!abc").matches());
        System.out.println("pattern1.matcher(\"abc.\").matches() = " + pattern1.matcher("abc.").matches());
        System.out.println("pattern1.matcher(\"abc,\").matches() = " + pattern1.matcher("abc,").matches());
        System.out.println("pattern1.matcher(\"abc \").matches() = " + pattern1.matcher("abc ").matches());


//        System.out.println("countValidWords(\"\") = " + countValidWords("cat and  dog 123"));
        System.out.println("countValidWords(\"\") = " + countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

    public static int countValidWords(String sentence) {
        String noDigit = "[^0-9]*";

        String lower = "[a-z]+";
        String hiphen01 = "[\\-]?";
        String regHiphen = lower + hiphen01 + lower;

        String punch = "[\\!\\.\\,\\ ]{1}";
        String end = "[a-z]*" + punch;
        System.out.println("Pattern.compile(end).matcher(s).matches() = " + Pattern.compile(end).matcher("pencils,").matches());
        System.out.println("Pattern.compile(end).matcher(s).matches() = " + Pattern.compile(end).matcher("pencils!").matches());
        System.out.println("Pattern.compile(end).matcher(s).matches() = " + Pattern.compile(end).matcher("!").matches());


        String final1 = regHiphen + punch;
        String final2 = "([a-z]+)|"+ "(" + end+ ")" + final1;

        Stream<String> stringStream = Arrays.stream(sentence.split(" "));
        int count = stringStream
//                .peek(s -> System.out.println(s))
                .filter(s -> Pattern.compile(noDigit).matcher(s).matches())
//                .peek(s -> System.out.println(s))
//                .filter(s -> Pattern.compile(regHiphen).matcher(s).matches())
//                .filter(s -> Pattern.compile(end).matcher(s).matches())
//                .filter(s -> Pattern.compile(final1).matcher(s).matches())
                .filter(s -> Pattern.compile(final2).matcher(s).matches())
                .peek(s -> System.out.println(s))
                .collect(Collectors.counting()).intValue();

//                .forEach(s -> System.out.println("p = " + s));
        return count;
    }

}
