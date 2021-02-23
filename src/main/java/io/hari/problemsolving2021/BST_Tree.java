package io.hari.problemsolving2021;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BST {
    Node root;

    public void insert(final int data) {
        System.out.println("Insert " + data);
        root = insertRec(root, data);//updating root in case of 1st node or root might update
    }

    private Node insertRec(final Node root, final int data) {
        if (Objects.isNull(root)) {
            return new Node(data);
        }
        //update root left and right
        if (data < root.data) {
            root.left = insertRec(root.left, data);//root might update when we are adding new data to tree
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    //traversal
    public void inorder() {
        System.out.print("Inorder : ");
        inorderRec(this.root);
        System.out.println();
    }

    private void inorderRec(final Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        inorderRec(root.left);
        System.out.print(root.data + " ");
        inorderRec(root.right);
    }

    public void preOrder() {
        System.out.print("Preorder : ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(final Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public void postOrder() {
        System.out.print("Postorder : ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(final Node root) {
        if (root == null) {
            return;
        }
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.data + " ");
    }

    // level order traversal
    public void levelOrderTraversal() {
        System.out.print("Level order traversal : ");
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    // delete node
    //1 root is null : update root with null
    //if key is less than root then call left recursion delete logic
    //if key is greater than root than call right recursion delete logic
    //2. target deleting node has no child
    //3. target deleting node has 1 child
    //4. target deleting node has 2 child : find min from its right side, update current root with that value, then delete that replace value in right side and update root right address

    public void delete(final int data) {
        System.out.println("delete " + data);
        root = deleteRec(root, data);
    }

    private Node deleteRec(final Node root, final int data) {
        if (root == null) {
            return null;
        }
        //update root left and right node , then return root
        if (data < root.data) {
            root.left = deleteRec(root.left, data);//delete from left side : call left side recursion
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null && root.right == null) {//case 1 : 0 child
                return null;
            }
            if (root.left == null) {//case 2 : 1 child
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //case 3 : 2 children
            final Node minFromRight = findMinFromRight(root);
            root.data = minFromRight.data;
            root.right = deleteRec(root.right, minFromRight.data);//this is same as: root = deleteRec(root, data);
        }
        return root;
    }

    private Node findMinFromRight(final Node root) {
        Node node = root;
        while (node != null) {
            node = root.left;
        }
        return node;
    }

    public void allTraversal() {
        inorder();
        preOrder();
        postOrder();
        levelOrderTraversal();
        System.out.println();
    }

    public void search(final int data) {
        final boolean result = searchRec(root, data);
        if (result) {
            System.err.println("Found "+data);
        } else {
            System.err.println("Not found "+data);
        }
    }

    private boolean searchRec(final Node root, final int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (data < root.data) { // data is less -> so go left side
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
}

public class BST_Tree {
    @Test
    public void mainMethod() {
        BST tree = new BST();
        tree.root = new Node(100);
        tree.inorder();
        tree.insert(10);
        tree.inorder();
        tree.insert(0);
        tree.inorder();
        tree.preOrder();
        tree.postOrder();
        tree.insert(101);
        tree.allTraversal();
        tree.insert(5);
        tree.allTraversal();
        tree.insert(11);
        tree.allTraversal();
        tree.delete(11);
        tree.allTraversal();
        tree.delete(5);
        tree.allTraversal();
        tree.search(10);
        tree.search(11110);
        tree.delete(0); tree.allTraversal();
        tree.delete(10); tree.allTraversal();
        tree.delete(100); tree.allTraversal();
        tree.delete(101); tree.allTraversal();
        tree.delete(101); tree.allTraversal();
        tree.search(10);
    }
}
