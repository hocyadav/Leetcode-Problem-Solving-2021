package io.hari.problemsolving2021.tree;

/**
 * @Author Hariom Yadav
 * @create 25-03-2021
 */
public class BinaryTreeSymmetricCheck {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

        checkBTSymmetric(tree.root);

        tree.root.left.left = new Node(100);
        checkBTSymmetric(tree.root);
    }

    private static void checkBTSymmetric(Node root) {
        final boolean b = rec(root.left, root.right);
        if (b == true) System.out.println("Symmetric BT ");
        else System.out.println("Not Symmetric BT");
    }

    /**
     * Approach
     * 1. both null,
     * 2. single node null,
     * 3. check node values and call recursion
     */
    private static boolean rec(Node leftNode, Node rightNode) {
        if (leftNode == null && rightNode == null) return true;
        //any one is null
        if (leftNode == null && rightNode != null) return false;
        if (rightNode == null && leftNode != null) return false;
        //compare current both node value and call recursion
        if (leftNode.val == rightNode.val) {// current both root value matches
            final boolean call1Result = rec(leftNode.left, rightNode.right);
            final boolean call2Result = rec(leftNode.right, rightNode.left);
            return call1Result && call2Result;
        } else // current both values dont match
            return false;
    }
}
/**
 Symmetric BT
 Not Symmetric BT
 */
