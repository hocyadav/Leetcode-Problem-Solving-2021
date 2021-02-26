package io.hari.problemsolving2021.linklist;

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
        final Node next = head.next;
        head = next;
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

        while (it != null) {
            temp = it.next;//4

            it.next = pre;//1
            pre = it;//2

            it = temp;//3
        }
        return pre;
    }

    public void traverseLL() {
        Node t = head;
        while (t != null) {
            System.out.print(t.val+" ");
            t = t.next;
        }
        System.out.println();
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
        ll.deleteLast();ll.traverseLL();
        ll.deleteLast();ll.traverseLL();
        ll.deleteLast();ll.traverseLL();
        ll.insertAtLast(999);ll.traverseLL();
        ll.reverseLL();ll.traverseLL();
    }
}
