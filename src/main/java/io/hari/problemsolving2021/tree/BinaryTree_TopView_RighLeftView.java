package io.hari.problemsolving2021.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author Hariom Yadav
 * @create 05-03-2021
 */
class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

class BinaryTree {
    Node root;

    /**
     * top view / vertical view , and store in list with key as distance from root
     * logic :
     * 1. take map k : distance , v = list of nodes
     * 2. for each distance add node to value of map (i.e. list) [update map]
     * Time Complexity = n (traversing BT)
     * Space Complexity = n (storing all nodes)
     */
    public void topViewVerticalViewBinaryTree() {
        System.out.println("\nTop view / vertical view BT");
        final Map<Integer, List<Node>> map = new HashMap<>();
        topViewUtil(root, map, 0);//start 0, as distance from root

        map.forEach((k, v) -> {
            final List<Integer> values = v.stream().mapToInt(i -> i.val).boxed().collect(Collectors.toList());
            System.out.println(k+" "+values);
        });
    }

    private void topViewUtil(final Node root, final Map<Integer, List<Node>> map, final int distance) {
        if (root == null) return;

        final List<Node> currentLevelNodes = map.getOrDefault(distance, new ArrayList<>());
        currentLevelNodes.add(root);
        map.put(distance, currentLevelNodes);
        topViewUtil(root.left, map, distance - 1);
        topViewUtil(root.right, map, distance + 1);
    }

    /**
     * Approach :
     * 1. level order traversal using Queue [at any point queue store all level data]
     * 2. fetch 1st node and store in result
     * Time Complexity = n (traversing BT)
     * Space Complexity = n (using queue)
     */
    public void rightOrLeftViewBinaryTree() {
        List<Node> viewList = new ArrayList<>();
        rightLeftUtil(root, viewList);

        final List<Integer> values = viewList.stream().map(node -> node.val).collect(Collectors.toList());
        System.out.println("right view  = " + values);
    }

    private void rightLeftUtil(final Node root, List<Node> viewList) {
        if (root == null) return;
        Queue<Node> qq = new LinkedList<>();
        qq.add(root);

        while (!qq.isEmpty()) {
            final int size = qq.size();
            final Node element = qq.element();//view 1st element
            viewList.add(element);// add 1st element
            IntStream.range(0, size).forEach(i -> { // remove all element from current level queue and add its children
                final Node curr = qq.poll();
                if (curr.right != null) qq.add(curr.right);//add left to see left BT view, move this statement down
                if (curr.left != null) qq.add(curr.left);
            });
            // or also we can use below for loop, IntStream range is simple for loop from 0 to size - 1
//            for (int i = 0; i < size; i++) {// remove all element from current level queue and add its children
//            }
        }
    }

    /**
     * level order using recursion
     * Approach:
     * same as top view BT, here we are incrementing level by 1 and in top view we are -1 for left and +1 for right recursion
     * Time Complexity = n (traversing BT)
     * Space Complexity = n (storing all nodes)
     */
    public void levelOrderInLists_UsingRecursion() {//level order using recursion
        final HashMap<Integer, List<Node>> map = new HashMap<>();//int is level, and list is all nodes that are peresent in that list
        levelOrderListUtil(root, map, 0);//start from 0 level
        for (Map.Entry<Integer, List<Node>> entry : map.entrySet()) {
            final List<Integer> values = entry.getValue().stream().map(i -> i.val).collect(Collectors.toList());
            System.out.println(entry.getKey() + " " + values);
        }
    }

    private void levelOrderListUtil(final Node root, final HashMap<Integer, List<Node>> map, final int level) {
        if (root == null) return;

        final List<Node> currentLevelNodes = map.getOrDefault(level, new ArrayList<>());
        currentLevelNodes.add(root);
        map.put(level, currentLevelNodes);

        levelOrderListUtil(root.left, map, level + 1);
        levelOrderListUtil(root.right, map, level + 1);
    }

    /**
     * level order using queue
     * Time Complexity : n (traversing BT)
     * Space Complexity : n (Queue)
     */
    public void traversalLevelOrder_UsingQueue() {// level order using Queue
        System.out.print("Level order BFS : ");
        levelOrderUtil(root);
        System.out.println();
    }

    private void levelOrderUtil(final Node root) {
        Queue<Node> qq = new LinkedList<>();
        qq.add(root);
        while (!qq.isEmpty()) {
            final Node current = qq.poll();
            System.out.print(current.val+" ");
            if (current.left != null) qq.add(current.left);
            if (current.right != null) qq.add(current.right);
        }
    }

    /**
     * Approach : recursion , Left, Node, Right
     * Time Complexity : n (traversing BT)
     * Space Complexity : 1
     */
    public void traversalDFS() {
        System.out.print("DFS traversal.. : ");
        helperDFS(root);
        System.out.println();
    }

    private void helperDFS(final Node root) {
        if (root == null) return;
        helperDFS(root.left);
        System.out.print(root.val+" ");
        helperDFS(root.right);
    }

    /**
     * Approach : search where to add using recursion
     * @param value
     * Time complexity : n (traversing BT)
     * Space complexity : 1
     */
    public void insert(int value) {
        root = insertUtil(root, value);
        traversalDFS();
    }

    private Node insertUtil(Node root, final int value) {
        final Node nn = new Node(value);
        if (root == null) {
            return nn;
        }
        if (value <= root.val) root.left = insertUtil(root.left, value);
        else root.right = insertUtil(root.right, value);
        return root;
    }

    public void mirrorViewDFS() {
        System.out.println("mirror view done");
        mirrorUtilDFS(root);
    }

    private Node mirrorUtilDFS(final Node root) {
        if (root == null) return null;
        Node left = mirrorUtilDFS(root.left);
        Node right = mirrorUtilDFS(root.right);
        //swap
        root.left = right;
        root.right = left;
        return root;
    }

    public void mirrorViewBFS() {
        mirrorUtilBFS(root);
    }

    private Node mirrorUtilBFS(final Node root) {
        if (root == null) return null;
        Queue<Node> qq = new LinkedList<>();
        qq.add(root);

        while (!qq.isEmpty()) {
            final Node curr = qq.poll();
            //swap left right
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) qq.add(curr.left);
            if (curr.right != null) qq.add(curr.right);
        }
        return root;
    }

}
public class BinaryTree_TopView_RighLeftView {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.traversalDFS();
        tree.insert(12);
        tree.insert(10);
        tree.insert(20);
        tree.insert(11);
        tree.insert(13);
        tree.insert(9);
        tree.traversalLevelOrder_UsingQueue();
        tree.levelOrderInLists_UsingRecursion();
        tree.rightOrLeftViewBinaryTree();
        tree.topViewVerticalViewBinaryTree();
        tree.traversalLevelOrder_UsingQueue();
        tree.traversalDFS();
        //mirror view of tree
        tree.mirrorViewDFS(); tree.traversalLevelOrder_UsingQueue();tree.traversalDFS();
        //mirror view of tree - back to original
        tree.mirrorViewDFS(); tree.traversalLevelOrder_UsingQueue();tree.traversalDFS();
    }
}
/**
 *
 12
 10 12
 10 12 20
 10 11 12 20
 10 11 12 13 20
 9 10 11 12 13 20
 12 10 20 9 11 13
 0 [12]
 1 [10, 20]
 2 [9, 11, 13]
 right view  = [12, 20, 13]

 Top view / vertical view BT
 0 [12, 11, 13]
 -1 [10]
 -2 [9]
 1 [20]
 *
 */
