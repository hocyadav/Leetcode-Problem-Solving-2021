package io.hari.problemsolving2021.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    private TreeNode getTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        return root;
    }

    @Test
    public void pathSum1_test1() {
        TreeNode root = getTree();
        final boolean hasPathSum = hasPathSum(root, 22);
        System.out.println("hasPathSum = " + hasPathSum);//true
    }

    @Test
    public void pathSum1_test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        final boolean hasPathSum = hasPathSum(root, 5);
        System.out.println("hasPathSum = " + hasPathSum);//false
    }

    @Test
    public void pathSum2_test1() {
        final TreeNode root = getTree();
        final List<List<Integer>> pathSum = pathSum(root, 22);
        System.out.println("pathSum = " + pathSum);
        //pathSum = [[5, 4, 11, 2], [5, 8, 4, 5]]
    }

    /**
     * Approach : recursion tree traversal + pass extra 1 parameter in recursion
     * https://leetcode.com/problems/path-sum/
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

    /**
     * https://leetcode.com/problems/path-sum/
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        helperRecInorder(root, targetSum, new ArrayList<Integer>(), result);
        return result;
    }

    private void helperRecInorder(TreeNode root,
                                  int targetSum,
                                  ArrayList<Integer> current,
                                  List<List<Integer>> result) {
        if (root == null) return;

        current.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {//leaf node + target condition
            result.add(current);
            return;
        }
        helperRecInorder(root.left, targetSum - root.val, new ArrayList<>(current), result);
        helperRecInorder(root.right, targetSum - root.val, new ArrayList<>(current), result);
    }
}
