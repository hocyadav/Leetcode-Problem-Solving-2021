package io.hari.problemsolving2021;

import java.util.Stack;

/**
 * @Author Hariom Yadav
 * @create 24-03-2021
 */
public class ReverseStackUsingRec {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack = " + stack);
        reverseStackUsingRecursion(stack);
        System.out.println("stack = " + stack);
    }

    private static void reverseStackUsingRecursion(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        final Integer temp = stack.pop();
        reverseStackUsingRecursion(stack);
        insertAtBottom(stack, temp);
    }

    private static void insertAtBottom(Stack<Integer> stack, Integer data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        final Integer temp = stack.pop();
        insertAtBottom(stack, data);
        stack.push(temp);
    }
}
/**
 stack = [1, 2, 3, 4]
 stack = [4, 3, 2, 1]
 */
