package io.hari.problemsolving2021.tree;

/**
 * @Author Hariom Yadav
 * @create 18-03-2021
 */
public class LowestCommonAncestorOf2NodeIn_BST { // tree is sorted, its BST not BT
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.root = new Node(20);
        bst.root.left = new Node(8);
        bst.root.right = new Node(22);
        bst.root.left.left = new Node(4);
        bst.root.left.right = new Node(12);
        bst.root.left.right.left = new Node(10);
        bst.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        final Node lca = lcaIn_BinarySearchTree(bst.root, n1, n2);
        System.out.println("lca = " + lca.val);

        final Node lca2 = lcaIn_BinarySearchTree(bst.root, 14, 8);
        System.out.println("lca2 = " + lca2.val);

        final Node lca3 = lcaIn_BinarySearchTree(bst.root, 10, 22);
        System.out.println("lca3 = " + lca3.val);

    }

    /** https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
     * 1 Create a recursive function that takes a node and the two values n1 and n2.
     * 2 If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree. Call the recursive function for thr right subtree.
     * 3 If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree. Call the recursive function for thr left subtree.
     * 4 If both the above cases are false then return the current node as LCA.
     */
    public static Node lcaIn_BinarySearchTree(Node root, int node1Val, int node2Val) {
        if (root == null) return null;

        if (root.val > node1Val && root.val > node2Val) //both are present on left side
            return lcaIn_BinarySearchTree(root.left, node1Val, node2Val);
        else if (root.val < node1Val && root.val < node2Val) // both are present on right side
            return lcaIn_BinarySearchTree(root.right, node1Val, node2Val);

        return root; //between node1val and node2Val
    }
}

/**
 lca = 12
 lca2 = 8
 lca3 = 20
 */
