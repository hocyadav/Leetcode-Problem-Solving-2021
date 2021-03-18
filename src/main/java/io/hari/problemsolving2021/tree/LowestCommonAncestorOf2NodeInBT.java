package io.hari.problemsolving2021.tree;

/**
 * @Author Hariom Yadav
 * @create 18-03-2021
 */
public class LowestCommonAncestorOf2NodeInBT {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        final Node lca = lcaInBinaryTree(tree.root, n1, n2);
        System.out.println("lca = " + lca.val);

        final Node lca2 = lcaInBinaryTree(tree.root, 14, 8);
        System.out.println("lca2 = " + lca2.val);

        final Node lca3 = lcaInBinaryTree(tree.root, 10, 22);
        System.out.println("lca3 = " + lca3.val);

    }

    /**
     * 1 Create a recursive function that takes a node and the two values n1 and n2.
     * 2 If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree. Call the recursive function for thr right subtree.
     * 3 If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree. Call the recursive function for thr left subtree.
     * 4 If both the above cases are false then return the current node as LCA.
     */
    public static Node lcaInBinaryTree(Node root, int node1Val, int node2Val) {
        if (root == null) return null;

        if (root.val > node1Val && root.val > node2Val)
            return lcaInBinaryTree(root.left, node1Val, node2Val);
        else if (root.val < node1Val && root.val < node2Val)
            return lcaInBinaryTree(root.right, node1Val, node2Val);

        return root; // equal to node1Val
    }
}

/**
 lca = 12
 lca2 = 8
 lca3 = 20
 */
