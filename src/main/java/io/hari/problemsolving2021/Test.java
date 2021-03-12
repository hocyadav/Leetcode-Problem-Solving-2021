package io.hari.problemsolving2021;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        final String hariom = "hariom yafav";
        final String[] split = hariom.split("\\s");
        System.out.println("split.length = " + split.length);

        List<Integer> list1 = Arrays.asList(1, 2, 3,45);
        List<Integer> list2 = Arrays.asList(22, 4, 3);
        final Set<Integer> collect = list1.stream().collect(Collectors.toSet());
        final Set<Integer> collect1 = list2.stream().collect(Collectors.toSet());


//        final Collection<Integer> disjunction = CollectionUtils.union(list1, list2);
        final Collection<Integer> disjunction = CollectionUtils.union(collect, collect1);
        System.out.println("disjunction = " + disjunction);

    }

}
