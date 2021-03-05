package io.hari.problemsolving2021.linklist;
class GenericNode<T> {
    T val;
    GenericNode<T> next;

    public GenericNode(T val) {
        this.val = val;
    }
}

class GenericLL<T> {
    GenericNode<T> head;

    public void insertAtFirst(T val) {
        GenericNode<T> nn = new GenericNode<>(val);
        if (head == null) {
            head = nn;
            return;
        }
        nn.next = head;
        head = nn;
    }

    public void insertAtLast(T val) {
        GenericNode<T> nn = new GenericNode<>(val);
        if (head == null) {
            head = nn;
            return;
        }
        GenericNode<T> it = head;
        while (it.next != null) {//traverse all
            it = it.next;
        }
        it.next = nn;
    }

    public void deleteFirst() {
        if (head == null) return;
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) return;
        GenericNode<T> it = head;
        GenericNode<T> pre = null;
        while (it.next != null) {//traverse all + store previous
            pre = it;
            it = it.next;
        }
        pre.next = null;
    }

    public void reverse() {
        head = reverseHelper(head);
    }

    private GenericNode<T> reverseHelper(final GenericNode<T> head) {
        if (head == null) return null;

        GenericNode<T> it = head;
        GenericNode<T> pre = null;
        GenericNode<T> temp = null;

        while (it != null) {
            temp = it.next;//for future use
            it.next = pre;//1
            pre = it;//2
            it = temp;//3
        }
        return pre;
    }

    public void reverseInKGroup(final int k) {
        head = reverseInKGrpHelper(head, k);
    }

    private GenericNode<T> reverseInKGrpHelper(GenericNode<T> head, final int k) {
        if (head == null || k == 0) return head;

        GenericNode<T> it = head;
        GenericNode<T> pre = null;
        GenericNode<T> temp = null;
        int i = 0;
        while (i < k && it != null) {
            temp = it.next;
            it.next = pre;//1
            pre = it;//2
            it = temp;
            i++;
        }
        if (it != null) {
            head.next = reverseInKGrpHelper(it, k);
        }
        return pre;
    }

    public void traverseLL() {
        if (head == null) return;
        GenericNode<T> it = head;
        while (it != null) {//out when it reaches null, i.e. cover all non null value from 1st to last node
            System.out.print(it.val+" ");
            it = it.next;
        }
        System.out.println();
    }
}

public class LinkListGenericImpl {
    public static void main(String[] args) {
        GenericLL<Integer> ll = new GenericLL<>();
        ll.insertAtFirst(7);ll.traverseLL();
        ll.insertAtFirst(8);ll.traverseLL();
        ll.insertAtFirst(9);ll.traverseLL();
        ll.insertAtLast(10);ll.traverseLL();
        ll.insertAtLast(11);ll.traverseLL();
        ll.deleteFirst();ll.traverseLL();
        ll.deleteLast();ll.traverseLL();
        ll.reverse();ll.traverseLL();

        ll.insertAtLast(11);ll.traverseLL();
        ll.insertAtLast(12);ll.traverseLL();
        ll.insertAtLast(13);ll.traverseLL();
        ll.reverseInKGroup(2);ll.traverseLL();
        ll.reverseInKGroup(3);ll.traverseLL();

        GenericLL<String> ll1 = new GenericLL<>();
        ll1.insertAtFirst("1st");ll1.traverseLL();
        ll1.insertAtFirst("2nd");ll1.traverseLL();
        ll1.insertAtFirst("3rd");ll1.traverseLL();
        ll1.reverse();ll1.traverseLL();
        ll1.reverseInKGroup(2);ll1.traverseLL();

    }
}
