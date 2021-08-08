package io.hari.problemsolving2021.easy;

import java.util.*;
import java.util.stream.Collectors;

public class MostCommonWord {
    public static void main(String[] args) {
        String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] bannedArray = new String[]{"hit"};
        List<String> list = Arrays.stream(bannedArray).collect(Collectors.toList());

        HashMap<String, Integer> map = new HashMap<>();

        List<String> collect = Arrays.stream(para.replace(",","")
                .replace(".","")
                .toLowerCase()
                .split(" ")).collect(Collectors.toList());
        collect.stream()
                .filter(s -> !list.contains(s))
                .peek(s -> System.out.println("s = " + s))
                .forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));

        System.out.println("map = " + map);

        Set<Map.Entry<String, Integer>> collection = map.entrySet();
        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();

        //return max element from input collection i.e. collection type
        //here collection type is Map.Entry
        //we can create comparator from Map.Entry type using its key or value
        Map.Entry<String, Integer> max = Collections.max(collection, comparator);

        System.out.println("max = " + max);
        System.out.println("max = " + max.getKey());
    }

    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            List<String> inputPara = Arrays.stream(banned).collect(Collectors.toList());
            HashMap<String, Integer> map = new HashMap<>();

            String regex = "[ !?',;.]+";//[]+ means one or more
            Arrays.stream(paragraph.toLowerCase().split(regex))
                    .filter(s -> !inputPara.contains(s))
                    .forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));

            Set<Map.Entry<String, Integer>> collection = map.entrySet();
            Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();
            //return max element from input collection i.e. collection type
            //here collection type is Map.Entry
            //we can create comparator from Map.Entry type using its key or value
            Map.Entry<String, Integer> max = Collections.max(collection, comparator);
            return max.getKey();
        }
    }
}
