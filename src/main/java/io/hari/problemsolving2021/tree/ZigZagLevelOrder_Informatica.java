package io.hari.problemsolving2021.tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Hariom Yadav
 * @create 25-03-2021
 */
public class ZigZagLevelOrder_Informatica {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);

        printZigZag_usingBFSLevelOrder(tree.root);
        printZigZag_usingStack(tree.root);
    }

    // TODO: 25-03-2021
    private static void printZigZag_usingStack(Node root) {

    }

    private static void printZigZag_usingBFSLevelOrder(Node root) {
        Queue<Node> qq = new LinkedList<>();
        qq.add(root);

        boolean printOrder = true;
        while (!qq.isEmpty()) {
            final int size = qq.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                final Node curr = qq.poll();

                //extra logic to add to list, based on flag, alternate flag value will change
                if (printOrder) list.add(curr.val);
                else list.add(0, curr.val);

                if (curr.left != null) qq.add(curr.left);
                if (curr.right != null) qq.add(curr.right);
            }
            System.out.println("list = " + list);
            list.clear();
            printOrder = printOrder == true ? false : true;//change flag value
        }
    }
}
/**
 list = [3]
 list = [20, 9]
 list = [15, 7]
 */
