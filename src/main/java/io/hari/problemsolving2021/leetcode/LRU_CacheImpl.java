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
                        deque.remove();
                        break;
                    }
                }
                deque.addFirst(data);//add to 1st place
//                set.add(data);//not required since already present in set
            }
        }
    }
    
    public void printAll() {
        System.out.print("LRU cache data : ");
        final Iterator<Integer> it = deque.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
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
    }
}
