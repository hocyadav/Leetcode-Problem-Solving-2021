package io.hari.problemsolving2021.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 22-03-2021
 */
class StackLL {
    List<Integer> list;
    int size;

    public StackLL(int size) {
        this.size = size;
        list = new LinkedList<>();
    }

    public void push(int data) {
        if (list.size() == size) {
            System.out.println("Overflow");
            return;
        }
        list.add(data);
    }

    public void pop() {
        if (list.size() == 0) {
            System.out.println("Underflow");
            return;
        }
        list.remove(list.size() - 1);
    }

    public void printStack() {
        System.out.print("Stack : ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

}
public class StackUsingLinkedList {
    public static void main(String[] args) {
        StackLL stackDS = new StackLL(3);
        stackDS.printStack();
        stackDS.pop();
        stackDS.push(10);stackDS.printStack();
        stackDS.push(20);stackDS.printStack();
        stackDS.push(30);stackDS.printStack();
        stackDS.pop();
        stackDS.push(40);stackDS.printStack();
        stackDS.push(50);stackDS.printStack();
        stackDS.printStack();
    }
}

/**
 Stack :
 Underflow
 Stack : 10
 Stack : 10 20
 Stack : 10 20 30
 Stack : 10 20 40
 Overflow
 Stack : 10 20 40
 Stack : 10 20 40
 */
