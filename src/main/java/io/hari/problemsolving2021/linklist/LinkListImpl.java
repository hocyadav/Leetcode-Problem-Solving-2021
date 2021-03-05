package io.hari.problemsolving2021.linklist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class SinglyLL {
    Node head;
    //*insert at 1st place
    //*insert at last place
    //*delete 1st
    //*delete last
    //*traverse - print
    //reverse
    //reverse in k grp

    public void insertAtFirstPlace(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    public void insertAtLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node it = head;
        while (it.next != null) {
            it = it.next;
        }
        it.next = node;
    }

    public void deleteFirst() {
        if (head == null) return;
        //m1
        final Node next = head.next;
        head = next;//jump to next step, thats all
        //m2
//        head = head.next;//jump to next node
    }

    public void deleteLast() {
        if (head == null) return;
        Node it = head;
        Node pre = null;
        while (it.next != null) {
            pre = it;
            it = it.next;
        }
        pre.next = null;//remove link to last node
    }

    public void reverseLL() {
        head = reverse();
    }

    private Node reverse() {
        Node it = head; // traversal pointer
        Node pre = null;//result pointer
        Node temp = null;//helper pointer

        while (it != null) {// traverse all not null values
            temp = it.next;//4

            it.next = pre;//1
            pre = it;//2

            it = temp;//3
        }
        return pre;
    }

    public void reverseInKGrp(int k) {
        head = reverseKGrpHelper(head, k);
    }

    private Node reverseKGrpHelper(Node head, int k) {
        if (head == null || k == 0) return head;
        Node it = head;
        Node pre = null;
        Node temp = null;
        int i = 0;
        while (i < k && it != null) {//go to Null node
            temp = it.next;//store for future use, its same as when we swapping 2 value
            it.next = pre;
            pre = it;
            it = temp;
            i++;
        }
        if (it != null) {
            head.next = reverseKGrpHelper(it, k);
        }
        return pre;
    }

    public void traverseLL() {
        Node t = head;
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();
    }

    public void midElement() {
        Node slow = head;//1 jump
        Node fast = head;//2 jump

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("mid element val = " + slow.val);
    }

    public boolean cycleChecking() {
        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;//1 jumps
            fast = fast.next.next;//2 jump
            if (slow == fast) {
                System.out.println("cycle found..");
                return true;
            }
        }
        System.out.println("cycle not found..");

        return false;
    }
}

public class LinkListImpl {
    public static void main(String[] args) {
        SinglyLL ll = new SinglyLL();
        ll.insertAtFirstPlace(3);
        ll.insertAtFirstPlace(4);
        ll.insertAtLast(12);
        ll.insertAtLast(122);

        ll.traverseLL();
        ll.deleteFirst();
        ll.deleteFirst();
        ll.traverseLL();

        ll.insertAtLast(20);
        ll.insertAtLast(30);
        ll.insertAtLast(40);
        ll.traverseLL();
        ll.deleteLast();
        ll.traverseLL();
        ll.deleteLast();
        ll.traverseLL();
        ll.deleteLast();
        ll.traverseLL();
        ll.midElement();
        ll.insertAtLast(999);
        ll.traverseLL();
        ll.reverseLL();
        ll.traverseLL();
        ll.insertAtLast(18);
        ll.insertAtLast(13);
        ll.insertAtLast(14);
        ll.traverseLL();
        ll.reverseInKGrp(3);
        ll.traverseLL();
        ll.reverseInKGrp(2);
        ll.traverseLL();
        ll.insertAtLast(12345);
        ll.traverseLL();
        ll.midElement();
        ll.cycleChecking();
        Map<Integer, Integer> map = new HashMap<>();
        final Integer put = map.put(1, 2);
    }
}
