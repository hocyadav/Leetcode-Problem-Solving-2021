package io.hari.problemsolving2021;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Leetcode {

    @Getter
    @Setter
    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // use of data structure
    class BST {
        Node root;

        // left value right
        public void inorder() {
            System.out.print("Inorder : ");
            inorder(root);
            System.out.println();
        }

        private void inorder(Node root) {
            //null check
            if (Objects.isNull(root)) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        //pre order : node-value left right
        public void preOrder() {
            System.out.print("Preorder = ");
            preOrder(root);
            System.out.println();
        }

        private void preOrder(Node root) {
            if (Objects.isNull(root)) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void postOrder() {
            System.out.print("Postorder = ");
            postOrder(root);
            System.out.println();
        }

        private void postOrder(Node root) {
            if (Objects.isNull(root)) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }


        public void insert(int data) {
            root = insert(root, data);
        }

        private Node insert(Node root, int data) {
            //1st time insertion
            if (root == null) {
                return new Node(data);
            }
            //update root : left and right
            if (root.getData() < data) {
                root.right = insert(root.right, data);
            } else {
                root.left = insert(root.left, data);
            }
            return root;
        }

        public void levelOrderTraversal() {
            System.out.print("LevelOrderTraversal = ");
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node node = queue.poll();
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
    }

    @Test
    public void TreeDataStructure() {
        BST bst = new BST();
        bst.root = new Node(10);
        bst.inorder();
        bst.insert(5);
        bst.inorder();
        bst.insert(15);
        bst.insert(152);
        bst.insert(0);
        bst.inorder();
        bst.preOrder();
        bst.postOrder();
        bst.levelOrderTraversal();
        bst.insert(6);
        bst.levelOrderTraversal();
    }
}
