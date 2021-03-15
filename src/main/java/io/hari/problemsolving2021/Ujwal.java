package io.hari.problemsolving2021;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Hariom Yadav
 * @create 14-03-2021
 */
class QNode {
    String key;
    Integer value = 0;

    public QNode(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}

class MyDS {
    Map<String, QNode> map = new HashMap<>();
    PriorityQueue<QNode> priorityQueue = new PriorityQueue<QNode>((a, b) -> {
        if (a.value == b.value) return a.key.compareTo(b.key);
        return b.value.compareTo(a.value);
    });

    public void assign(String key, int value) {
        final QNode oldNode = map.putIfAbsent(key, new QNode(key, value));
        oldNode.value += value;
        map.put(key, oldNode);
        if (!priorityQueue.contains(key)) {
            priorityQueue.add(oldNode);
        }
    }

    public void delete(String key) {
        final QNode remove = map.remove(key);
        priorityQueue.remove(remove);
    }

    public String maxScore() {
        final QNode peek = priorityQueue.peek();
        final String key1 = peek.key;
        final Integer value1 = peek.value;
        System.out.println("key1 = " + key1);
        System.out.println("value1 = " + value1);

        return key1 + " " + value1;

//        final Optional<Map.Entry<String, Integer>> first = map.entrySet().stream().sorted(((Comparator<Map.Entry<String, Integer>>) (o1, o2) -> {
//            return o1.getKey().compareTo(o2.getKey());
//        }).thenComparing((o1, o2) -> {
//            return o1.getValue().compareTo(o2.getValue());
//        })
//        ).findFirst();
//
//        AtomicReference<String> key = new AtomicReference<>("");
//        AtomicReference<Integer> value = new AtomicReference<>(0);
//        first.ifPresent(i -> {
//            key.set(i.getKey());
//            value.getAndSet(i.getValue());
//        });
//        return key.get() + " " + value.get();
    }

    public Integer getScore(String s) {
        if (map.containsKey(s)) {
            return map.get(s).value;
        }
        return 0;
    }
}

public class Ujwal {
    public static void main(String[] args) {
        MyDS myDS = new MyDS();
        Scanner scanner = new Scanner(System.in);
        int testCaseNum = scanner.nextInt();
        while (testCaseNum > 0) {
            final String type = scanner.next();
            if (type.equals("A")) {
                final String key = scanner.next();
                final int value = scanner.nextInt();
                myDS.assign(key, value);
            } else if (type.equals("M")) {
                final String s2 = myDS.maxScore();
                System.out.println(s2);
            } else if (type.equals("G")) {
                final String key = scanner.next();
                final Integer score = myDS.getScore(key);
                System.out.println(score);
            } else if (type.equals("D")) {
                final String key = scanner.next();
                myDS.delete(key);
            }
            testCaseNum--;
        }

    }
}
