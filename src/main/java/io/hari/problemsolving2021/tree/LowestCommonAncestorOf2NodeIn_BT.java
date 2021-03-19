package io.hari.problemsolving2021.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 18-03-2021
 */
public class LowestCommonAncestorOf2NodeIn_BT { // tree is sorted, its BST not BT
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
        lcaIn_BinaryTree(tree.root, n1, n2);
        lcaIn_BinaryTree(tree.root, 14, 8);
        lcaIn_BinaryTree(tree.root, 10, 22);
    }

    /**
     * 1 Approach : find path from root to leaf for both nodes
     * 2 then traverse both array till common value
     */
    public static void lcaIn_BinaryTree(Node root, int node1Val, int node2Val) {
        final List<Integer> path1 = findRootToLeafNodes(root, node1Val);
        final List<Integer> path2 = findRootToLeafNodes(root, node2Val);
        System.out.println("path1 = " + path1);
        System.out.println("path2 = " + path2);

        //traverse both path till common
        int p1 = 0, p2 = 0;
        while (p1 < path1.size() && p2 < path2.size()) {
            if (path1.get(p1) == path2.get(p2)) {
                p1++;
                p2++;
                continue;
            } else break;
        }
        //final ans
        System.out.println("path1 = " + path1.get(p1 - 1));
        System.out.println("path2 = " + path2.get(p2 - 1));
        System.out.println("---------------");
    }

    public static List<Integer> findRootToLeafNodes(Node root, Integer target) {
        List<List<Integer>> result = new ArrayList<>();
        rec(root, target, new ArrayList<Integer>(), result);
        return result.get(0);
    }

    private static void rec(Node root, Integer target, ArrayList<Integer> current, List<List<Integer>> result) {
        if (root == null) return;
        current.add(root.val);
        if (root.val == target) {
            result.add(current);
            return;
        }
        rec(root.left, target, new ArrayList<>(current), result);
        rec(root.right, target, new ArrayList<>(current), result);
    }
}
/**
 path1 = [20, 8, 12, 10]
 path2 = [20, 8, 12, 14]
 path1 = 12
 path2 = 12
 ---------------
 path1 = [20, 8, 12, 14]
 path2 = [20, 8]
 path1 = 8
 path2 = 8
 ---------------
 path1 = [20, 8, 12, 10]
 path2 = [20, 22]
 path1 = 20
 path2 = 20
 ---------------
 */

