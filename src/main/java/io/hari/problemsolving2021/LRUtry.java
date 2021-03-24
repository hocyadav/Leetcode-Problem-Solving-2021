package io.hari.problemsolving2021;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 24-03-2021
 */

class LRUCache {
    Deque<Integer> dq = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    int size;

    public LRUCache(int size) {
        this.size = size;
    }

    public void offer(int data) {
        if (!set.contains(data)) {
            if (dq.size() == size) set.remove(dq.removeLast());
            dq.addFirst(data);
            set.add(data);
        } else {
            if (dq.getFirst() != data) {
                final Iterator<Integer> iterator = dq.iterator();
                while (iterator.hasNext()) {
                    final Integer next = iterator.next();
                    if (next == data) {
                        iterator.remove();
                        break;
                    }
                }
                dq.addFirst(data);
            }
        }
    }

    public void print() {
        System.out.print("LRU cache : ");
        final Iterator<Integer> it = dq.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}

public class LRUtry {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.print();
        lruCache.offer(10);
        lruCache.print();
        lruCache.offer(12);
        lruCache.print();
        lruCache.offer(14);
        lruCache.print();
        lruCache.offer(14);lruCache.print();
        lruCache.offer(12);lruCache.print();
        lruCache.offer(12);lruCache.print();
        lruCache.offer(10);lruCache.print();
    }
}
