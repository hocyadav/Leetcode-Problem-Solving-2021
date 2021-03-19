package io.hari.problemsolving2021.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Hariom Yadav
 * @create 19-03-2021
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */

/**
 * data structure for n array tree
 */
class NArrayNode{
    int val;
    List<NArrayNode> children = new LinkedList<>();

    public NArrayNode(int val) {
        this.val = val;
    }
}

class NArrayImpl {
    NArrayNode root;
    
    public void nArrayLevelOrder_BFS() {
        List<List<Integer>> result = new LinkedList<>();
        bfsUtil(root, result);
        System.out.println("result = " + result);
    }

    private void bfsUtil(NArrayNode root, List<List<Integer>> result) {
        if (root == null) return;
        Queue<NArrayNode> qq = new LinkedList<>();
        qq.add(root);
        while (!qq.isEmpty()) {
            final int size = qq.size();
            List<Integer> singleLevelNodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                final NArrayNode curr = qq.poll();
                singleLevelNodes.add(curr.val);
                for (NArrayNode c : curr.children) {
                    qq.add(c);
                }
            }
            System.out.println("singleLevelNodes = " + singleLevelNodes);
            result.add(singleLevelNodes);
        }
    }

}
public class NArrayLevelOrderTraversal {
    public static void main(String[] args) {
        NArrayImpl nArray = new NArrayImpl();
        nArray.root = new NArrayNode(1);

        nArray.root.children.add(new NArrayNode(3));
        nArray.root.children.add(new NArrayNode(2));
        nArray.root.children.add(new NArrayNode(4));

        nArray.root.children.get(0).children.add(new NArrayNode(5));
        nArray.root.children.get(0).children.add(new NArrayNode(6));

        nArray.nArrayLevelOrder_BFS();
    }
}
/**
 singleLevelNodes = [1]
 singleLevelNodes = [3, 2, 4]
 singleLevelNodes = [5, 6]
 result = [[1], [3, 2, 4], [5, 6]]
 */
