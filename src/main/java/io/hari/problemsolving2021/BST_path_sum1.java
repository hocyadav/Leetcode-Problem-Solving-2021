package io.hari.problemsolving2021;

class NodeBst {
    int data;
    NodeBst left;
    NodeBst right;

    public NodeBst(int data) {
        this.data = data;
    }
}

class BSTTree {
    NodeBst root;

    public boolean targetPathSum(int data) {
        return targetPathSumRec(root, data);
    }

    private boolean targetPathSumRec(NodeBst root, int targetData) {
        //small problem : actual logic with return type
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {// leaf node
            if (root.data == targetData) {
                return true;
            } else {
                return false;
            }
        }
        final boolean left = targetPathSumRec(root.left, targetData - root.data);
        final boolean right = targetPathSumRec(root.right, targetData - root.data);
        return left || right;
    }

    public void delete(int data) {
        root = delete(root, data);
        System.out.println();
    }

    private NodeBst delete(final NodeBst root, final int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            //case 1 : 0 child
            if (root.left == null && root.right == null) {
                return null;
            }
            //case 2: 1 child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //case 3 : 2 child
            //find min from right
            //update root
            //take root.right as parent and delete value from right that we added
            NodeBst node = findMinFromRight(root);
            root.data = node.data;
            root.right = delete(root.right, node.data);
        }
        return root;
    }

    private NodeBst findMinFromRight(final NodeBst root) {
        NodeBst node = root;
        while (node != null) {
            node = node.left;
        }
        return node;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(final NodeBst root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}


public class BST_path_sum1 {
    public static void main(String[] args) {
        BSTTree tree = new BSTTree();
        tree.root = new NodeBst(100);
        tree.root.left = new NodeBst(10);
        tree.root.right = new NodeBst(110);
        System.out.println(tree.targetPathSum(110));
        System.out.println(tree.targetPathSum(210));
        System.out.println(tree.targetPathSum(10));
        tree.inorder();
        tree.delete(10);
        tree.inorder();
    }
}
