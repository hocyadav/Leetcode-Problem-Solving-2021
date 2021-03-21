package io.hari.problemsolving2021.leetcode;

/**
 * @Author Hariom Yadav
 * @create 21-03-2021
 */
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;
    public DLLNode(int data) {
        this.data = data;
    }
}
class DLLImpl {
    DLLNode head;

    /**
     * Create a new node.
     * same as LL , update next node, 1 and 2 steps
     * extra step is update pre step in between , 3 and 4
     */
    public void insertAtFirstPosition(int data) {
        DLLNode nn = new DLLNode(data);
        nn.next = head;//1
        nn.prev = null;//3
        if (head != null)
            head.prev = nn;//4
        head = nn;//2
    }

    /**
     * 1, 2 steps are singly LL
     * 3, 4 adding pre node
     */
    public void insertAfterGivenNode(DLLNode preNode, int data) {
        if (preNode == null) return; //null check
        DLLNode nn = new DLLNode(data);
        // 1 -> 2 -> nn -> 3 -> 4 //1st add single path from preNode to new to next of preNode
        nn.next = preNode.next;//1
        preNode.next = nn;//2

        //then add remaining nodes
        nn.prev = preNode;//3
        if (nn.next != null) nn.next.prev = nn;//4
    }

    public void insertAtLastPosition(int data) {
        DLLNode nn = new DLLNode(data);
        //if DLL is empty
        if (head == null) {//1st time insertion
            nn.prev = null;
            head = nn;
            return;
        }

        DLLNode last = head;
        while (last.next != null) { //traverse and go to last node
            last = last.next;
        }
        nn.prev = last;
        last.next = nn;
    }

    public void print() {
        DLLNode t = head;
        while (t != null) {
            System.out.print(t.data+" ");
            t = t.next;
        }
        System.out.println();
    }

}
public class DoublyLinkedList_DLL_ALlMethodsImpl {
    public static void main(String[] args) {
        DLLImpl dll = new DLLImpl();
        dll.print();
        dll.insertAtFirstPosition(10);dll.print();
        dll.insertAtFirstPosition(10);dll.print();
        dll.insertAtFirstPosition(20);dll.print();
        dll.insertAtLastPosition(30);dll.print();
        dll.insertAfterGivenNode(dll.head, 55);dll.print();
        dll.insertAfterGivenNode(dll.head.next, 66);dll.print();
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
