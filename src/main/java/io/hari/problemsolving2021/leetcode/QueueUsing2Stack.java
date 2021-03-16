package io.hari.problemsolving2021.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 16-03-2021
 */
class MyQueue {
    private List<Integer> stack1;
    private List<Integer> stack2;

    public MyQueue() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }
    //1 implement imp stack methods (make private)
    //2 implement imp queue methods, internally call stack methods

    private void pushStack(List<Integer> stack, int data) {
        stack.add(data);
    }

    private int popStack(List<Integer> stack) {
        return stack.isEmpty() == true ? -1 : stack.remove(stack.size() - 1);
    }

    private boolean isEmpty(List<Integer> stack) {
        return stack.isEmpty();
    }

    private int topStack(List<Integer> stack) {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1);
    }

    //assume stack 1 is for adding and stack 2 is for removing
    public void enQueue(int data) {
        if (!stack2.isEmpty()) {
            while (!stack2.isEmpty()) {
                pushStack(stack1, popStack(stack2));//push all stack 2 data into stack 1
            }
        }
        pushStack(stack1, data);
    }

    public int deQueue() {
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                pushStack(stack2, popStack(stack1));
            }
        }
        final int t = popStack(stack2);
        return t;
    }

    public int peekQueue() {
        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                pushStack(stack2, popStack(stack1));
            }
        }
        final int top = topStack(stack2);
        return top;
    }

    public boolean emptyQueue() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
public class QueueUsing2Stack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println("queue.emptyQueue() = " + queue.emptyQueue());
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        System.out.println("queue.emptyQueue() = " + queue.emptyQueue());
        System.out.println("peekQueue = " + queue.peekQueue());
        queue.deQueue();
        System.out.println("peekQueue = " + queue.peekQueue());
    }
}
/**
 queue.emptyQueue() = true
 queue.emptyQueue() = false
 peekQueue = 10
 peekQueue = 20
 */
