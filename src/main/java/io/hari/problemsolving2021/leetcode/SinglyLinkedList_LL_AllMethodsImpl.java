package io.hari.problemsolving2021.leetcode;

/**
 * @Author Hariom Yadav
 * @create 21-03-2021
 */
class LLNode {
    int data;
    LLNode next;
    public LLNode(int data) {
        this.data = data;
    }
}

class LLImpl {
    LLNode head;

    public void insertAtFirstPosition(int data) {
        LLNode nn = new LLNode(data);
        if (head == null) {//not required
            head = nn;
            return;
        }
        nn.next = head;
        head = nn;
    }

    public void insertAtLastPosition(int data) {
        LLNode nn = new LLNode(data);
        if (head == null) {
            head = nn;
            return;
        }
        LLNode last = head;
        while (last.next != null) // traverse and go to last position
            last = last.next;
        last.next = nn;
    }

    public void insertAfterGivenNode(LLNode prevNode, int data) {
        if (prevNode == null) return; //null check
        LLNode nn = new LLNode(data);
        nn.next = prevNode.next;
        prevNode.next = nn;
    }

    public void print() {
        LLNode t = head;
        while (t != null) {
            System.out.print(t.data+" ");
            t = t.next;
        }
        System.out.println();
    }

}


public class SinglyLinkedList_LL_AllMethodsImpl {
    public static void main(String[] args) {
        LLImpl singlyLL = new LLImpl();
        singlyLL.print();
        singlyLL.insertAtFirstPosition(10);singlyLL.print();
        singlyLL.insertAtFirstPosition(10);singlyLL.print();
        singlyLL.insertAtFirstPosition(20);singlyLL.print();
        singlyLL.insertAtLastPosition(30);singlyLL.print();
        singlyLL.insertAfterGivenNode(singlyLL.head, 55);singlyLL.print();//add just after head
        singlyLL.insertAfterGivenNode(singlyLL.head.next, 66);singlyLL.print();
    }
}
/**
 10
 10 10
 20 10 10
 20 10 10 30
 20 55 10 10 30
 20 55 66 10 10 30
 */
