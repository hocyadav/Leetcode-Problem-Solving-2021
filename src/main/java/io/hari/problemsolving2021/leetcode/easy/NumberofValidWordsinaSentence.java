package io.hari.problemsolving2021.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class NumberofValidWordsinaSentence {
    //https://leetcode.com/contest/weekly-contest-264/problems/number-of-valid-words-in-a-sentence/

    @Test
    public void foo(){
        countValidWords("input");
    }

    public int countValidWords(String sentence) {
        String[] split = sentence.split(" ");
        Stream<String> stringStream = Arrays.stream(split);

        //matcher + regex = digit_matcher
        AtomicInteger atomicInteger = new AtomicInteger(0);
        //create pattern
        //create matcher
        //use matcher
        Pattern onlyDigit = Pattern.compile("[0-9]+");
        System.out.println("input1 = " + onlyDigit.matcher("hariom").matches());
        System.out.println("input1 = " + onlyDigit.matcher("12").matches());//only digit
        System.out.println("input1 = " + onlyDigit.matcher("1h2").matches());

        Pattern onlyOneHiphen = Pattern.compile("[\\-]{0,1}[a-z]+");
        //        int start = matcher.start();
//        int end = matcher.end();
//        boolean b = matcher.find();
        System.out.println("matches = " + onlyOneHiphen.matcher("-aa").matches());
        System.out.println("matches = " + onlyOneHiphen.matcher("-").matches());

        Pattern hipenInStartOrEnd = Pattern.compile("[\\-]{1}[a-z]*[\\-]{1}");
        System.out.println("hipenInStartOrEnd.. = " + hipenInStartOrEnd.matcher("-").matches());
        System.out.println("hipenInStartOrEnd.. = " + hipenInStartOrEnd.matcher("-a").matches());
        System.out.println("hipenInStartOrEnd.. = " + hipenInStartOrEnd.matcher("b-b").matches());


        Pattern oneHipen = Pattern.compile("[a-z]*[\\-][a-z]*");
        System.out.println("matches1 = " + oneHipen.matcher("-a").matches());
        System.out.println("matches1 = " + oneHipen.matcher("b-a").matches());

        Pattern onlyOnePunch = Pattern.compile("[a-z]*[\\?!\\.][a-z]*");
        System.out.println("matches1 = " + onlyOnePunch.matcher("sfd?an").matches());

        Pattern punchStartOrEnd = Pattern.compile("[\\?!\\.][a-z]*[\\?!\\.]");
        System.out.println("matches1 = " + punchStartOrEnd.matcher("ab?").matches());

//        stringStream
//                .filter(s -> onlyDigit.matcher(s).matches())
//                .filter(s -> oneHipen.matcher(s).matches() && !hipenInStartOrEnd.matcher(s).matches())

//                .filter(only one difit)
//                .filter(only one hipen)
//                .filter(only_one - && - not at starting position && - not in end)
//                .filter(only_one punctuation && in_in_end_only)
//                .forEach(s -> atomicInteger.getAndIncrement());

        return atomicInteger.get();

    }
}
