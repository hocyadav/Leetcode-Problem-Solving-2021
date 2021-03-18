package io.hari.problemsolving2021.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Hariom Yadav
 * @create 10-03-2021
 */
public class MeetingRoom {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(0, 100), new Interval(29, 100), new Interval(39, 42), new Interval(41, 50)};
        Interval[] intervals2 = new Interval[]{
                new Interval(0, 100), new Interval(100, 200), new Interval(200, 300), new Interval(300, 400)};
        meetingRoom1_(intervals);
        meetingRoom1(intervals);
        meetingRoom2(intervals);//this will work for meeting room 1 also, if count is 1 then one person cal attend all meetings
    }

    public static void meetingRoom1(Interval[] intervals) {//array is not sorted
        Arrays.sort(intervals, (a, b) -> a.start - b.start);//sort based on start

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                System.out.println("meeting not possible by 1 person");
                return;
            }
        }
        System.out.println("meeting possible by 1 person");
    }

    public static void meetingRoom1_(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[i - 1].end) {
                continue;
            }
            if (intervals[i].start < intervals[i - 1].end) {
                System.out.println("not possible");
                return;
            }
        }
        System.out.println("meeting possible");
    }

    public static void meetingRoom2(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> a.end - b.end);//min heap
        for (Interval curr : intervals) {
            if (!heap.isEmpty() && curr.start >= heap.peek().end) {//2 remove old meeting and new meeting will take place this one
                heap.remove();
            }
            heap.add(curr);//1 always add,
        }
        System.out.println("heap.size() = " + heap.size());
    }

    public static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}


