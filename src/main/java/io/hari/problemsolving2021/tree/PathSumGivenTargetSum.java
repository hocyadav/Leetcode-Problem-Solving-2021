package io.hari.problemsolving2021.tree;

import org.junit.Test;

/**
 * @Author Hariom Yadav
 * @create 13-04-2021
 */

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PathSumGivenTargetSum {

    @Test
    public void testPathSum1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        final boolean hasPathSum = hasPathSum(root, 22);
        System.out.println("hasPathSum = " + hasPathSum);//true
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        final boolean hasPathSum = hasPathSum(root, 5);
        System.out.println("hasPathSum = " + hasPathSum);//false
    }

    /**
     * Approach : recursion tree traversal + pass extra 1 parameter in recursion
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; //null , valid invalid check
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) return true;
            return false;
        }
        final boolean left = hasPathSum(root.left, targetSum - root.val);
        final boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }
}
