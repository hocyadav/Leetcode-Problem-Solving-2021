package io.hari.problemsolving2021.leetcode;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 20-03-2021
 */
class LRUCache {
    Deque<Integer> deque = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * if not present - addFirst + add to set && (check for max size)
     * If present - addFirst + add to set && (find where present remove from that place and move to 1st place)
     */
    public void offer(int data) {
        if (!set.contains(data)) {
            if (deque.size() == maxSize) {//if full - free space by removing last + then add to first place
                final Integer last = deque.removeLast();
                set.remove(last);
            }
            deque.addFirst(data);
            set.add(data);
        } else {
            if (deque.getFirst() != data) {//if data is not 1st place then find place and remove + add to 1st place
                final Iterator<Integer> it = deque.iterator();
                while (it.hasNext()) {
                    if (it.next() == data) {
                        it.remove();
                        break;
                    }
                }
//                set.add(data);//not required since already present in set
                deque.addFirst(data);//add to 1st place
            }
        }
    }
//
//    public void offer2(int data) {
//        if (!set.contains(data)) {
//            if (deque.size() == maxSize) {
//                final Integer last = deque.removeLast();
//                set.remove(last);
//            }
//            deque.addFirst(data);
//            set.add(data);
//        } else {
//            if (deque.getFirst() != data) deque.remove(data);
//            deque.addFirst(data);
//            set.add(data);
//        }
//    }

    public void printAll() {
        System.out.print("LRU cache data : ");
        final Iterator<Integer> it = deque.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }


}

public class LRU_CacheImpl {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.printAll();
        lruCache.offer(10);lruCache.printAll();
        lruCache.offer(10);lruCache.printAll();
        lruCache.offer(10);lruCache.printAll();
        lruCache.offer(20);lruCache.printAll();
        lruCache.offer(30);lruCache.printAll();
        lruCache.offer(10);lruCache.printAll();
        lruCache.offer(40);lruCache.printAll();
        lruCache.offer(40);lruCache.printAll();
        lruCache.offer(20);lruCache.printAll();
        lruCache.offer(20);lruCache.printAll();

        System.out.println("---------------------");

//        LRUCache lruCache1 = new LRUCache(3);
//        lruCache1.offer2(10);lruCache1.printAll();
//        lruCache1.offer2(10);lruCache1.printAll();
//        lruCache1.offer2(10);lruCache1.printAll();
//        lruCache1.offer2(20);lruCache1.printAll();
//        lruCache1.offer2(30);lruCache1.printAll();
//        lruCache1.offer2(10);lruCache1.printAll();
//        lruCache1.offer2(40);lruCache1.printAll();
//        lruCache1.offer2(40);lruCache1.printAll();
//        lruCache1.offer2(20);lruCache1.printAll();
//        lruCache1.offer2(20);lruCache1.printAll();
    }
}

/**
 * LRU cache data :
 * LRU cache data : 10
 * LRU cache data : 10
 * LRU cache data : 10
 * LRU cache data : 20 10
 * LRU cache data : 30 20 10
 * LRU cache data : 10 20 10
 * LRU cache data : 40 10 20
 * LRU cache data : 40 10 20
 * LRU cache data : 20 10 20
 */
