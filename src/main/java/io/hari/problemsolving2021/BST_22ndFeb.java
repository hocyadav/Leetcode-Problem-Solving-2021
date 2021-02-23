package io.hari.problemsolving2021;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BST_22ndFeb {
    TreeNode root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode root, final int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data <= root.val) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void inorder() {
        System.out.println("Inorder = ");
        inorder(root);
        System.out.println();
    }

    private void inorder(final TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        inorder(root.left);
        inorder(root.right);
    }

    public void targetSum(int target) {
        if (helper(root, target)) {
            System.out.println("Target sum found");
        } else {
            System.out.println("Target Sum Not found");
        }
    }

    private boolean helper(final TreeNode root, final int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return true;
            } else {
                return false;
            }
        }
        boolean l = helper(root.left, target - root.val);
        boolean r = helper(root.right, target - root.val);
        return l || r;
    }

    public List<List<Integer>> targetSumInList(int target) {
        List<List<Integer>> list = new ArrayList<>();
        halper(root, target, new ArrayList<Integer>(), list);
        return list;
    }

    private void halper(final TreeNode root, final int target,
                        final ArrayList<Integer> current, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                list.add(current);
                return;
            } else {
                return;
            }
        }
        halper(root.left, target - root.val, new ArrayList<Integer>(current), list);
        halper(root.right, target - root.val, new ArrayList<Integer>(current), list);
    }

    public List<String> targetSumInStringList(int target) {
        List<String> list = new ArrayList<>();
        helper_str(root, target, "", list);
        return list;
    }

    private void helper_str(final TreeNode root, final int target, String current, List<String> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                current += String.valueOf(root.val);
                list.add(current);
                return;
            }
        }
        current += root.val + "->";
        helper_str(root.left, target - root.val, current, list);
        helper_str(root.right, target - root.val, current, list);
    }


    int count = 0;

    public int countToLeafTarget(int target) {
        traverse(root, target);
        int temp = count;
        count = 0;
        return temp;
    }

    private void traverse(final TreeNode root, int target) {
        if (root == null) {
            return;
        }
        traverse(root.left, target);
        count += helperCount(root, target);
        traverse(root.right, target);
    }

    private int helperCount(final TreeNode root, final int target) {
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            int l = helperCount(root.left, target - root.val);
            int m = helperCount(root.right, target - root.val);
            return 1 + l + m;
        } else {
            int l = helperCount(root.left, target - root.val);
            int m = helperCount(root.right, target - root.val);
            return l + m;
        }
    }

    int countResult = 0;

    public void longestCount() {
        longest(root);
        System.out.println("countResult = " + countResult);
    }

    private void longest(final TreeNode root) {
        if (root == null) {
            return;
        }
        int count = count_helper(root);
        countResult = Math.max(countResult, count);
        longest(root.left);
        longest(root.right);
    }

    private int count_helper(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null && root.val == root.left.val) {
            left = 1 + count_helper(root.left);
        }
        int right = 0;
        if (root.right != null && root.val == root.right.val) {
            right = 1 + count_helper(root.right);
        }
        return Math.max(left , right);
    }

    public static void main(String[] args) {
        BST_22ndFeb tree = new BST_22ndFeb();
        tree.root = new TreeNode(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(15);
        tree.inorder();
        tree.targetSum(25);
        System.out.println("lists = " + tree.targetSumInList(25));
        System.out.println("lists = " + tree.targetSumInList(15));
        System.out.println("strings = " + tree.targetSumInStringList(15));
        System.out.println("strings = " + tree.targetSumInStringList(25));
        tree.insert(100);
        System.out.println("lists = " + tree.targetSumInList(125));
        System.out.println("strings = " + tree.targetSumInStringList(15));
        System.out.println("strings = " + tree.targetSumInStringList(125));

        tree.inorder();
        System.out.println("countToLeafTarget = " + tree.countToLeafTarget(100));
        System.out.println("countToLeafTarget = " + tree.countToLeafTarget(25));
        System.out.println("countToLeafTarget = " + tree.countToLeafTarget(15));

//        tree.root = new TreeNode(10);
//        tree.insert(10);
//        tree.insert(10);
        tree.insert(100);
        tree.insert(100);
        tree.inorder();
        tree.longestCount();
    }
}
