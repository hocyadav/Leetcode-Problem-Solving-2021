package io.hari.problemsolving2021.stack;

/**
 * @Author Hariom Yadav
 * @create 22-03-2021
 */
class StackDS {
    int[] arr;
    int size;
    int top;
    public StackDS(int size) {
        this.size = size;
        this.top = -1;
        arr = new int[size];
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Overflow");
            return;
        }
//        top++;
        arr[++top] = data;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Underflow");
            return;
        }
        top--;
    }

    public void printStack() {
        System.out.print("Stack : ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class StackImplUsingArray {
    public static void main(String[] args) {
        StackDS stackDS = new StackDS(3);
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
