package io.hari.problemsolving2021.segmentTree;

/**
 * @Author Hariom Yadav
 * @create 17-03-2021
 */
class Node {
    int startIndex, endIndex;
    int sum;
    Node left, right;

    public Node(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}

class SegmentImlp {
    Node root;

    public void buildSegmentTree(int[] arr, int l, int r) {
        root = rec(arr, l, r);
    }

    private Node rec(int[] arr, int start, int end) {
        if (start > end) return null;

        Node root = new Node(start, end);//step1 : create new node, step2 : now find out where to store
        //where to store logic
        if (start == end) {//leaf
//            root.left = null; optional
//            root.right = null;
            root.sum = arr[start];
        } else {
            int mid = start + (end - start) / 2;//or (start + end) /2
            root.left = rec(arr, start, mid);
            root.right = rec(arr, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }

    private Node recSimpleWay(int[] arr, int start, int end) {
        if (start > end) return null;

        Node nn = new Node(start, end);
        if (start == end) {//leaf
            nn.sum = arr[start]; // get sum from array
            return nn;
        }
        int mid = start + (end - start) / 2;
        nn.left = rec(arr, start, mid);
        nn.right = rec(arr, mid + 1, end);//2. calling left and right

        nn.sum = nn.left.sum + nn.right.sum;//1 get sum from left and right, and left right not available so call rec
        return nn;
    }

    public void traverseSegmentTree() {//segment tree is BT so we can use inorder traversal
        inorder(root);
    }

    private void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.println(root.startIndex + " " + root.endIndex + " : " + root.sum);
        inorder(root.right);
    }

    public void sumRange(int startIndex, int endIndex) {
        System.out.print(startIndex + " " + endIndex + " : ");
        final int sum = recSum(root, startIndex, endIndex);
        System.out.println("sum = " + sum);
    }

    /**
     * 1. if matching node then return : matching means input range matches with current root range, [valid for both leaf node and non leaf node]
     * 2. find mid of segment tree
     * 3. 3 cases : our request present in left, right or partial [call recursion]
     */
    private int recSum(Node root, int startIndex, int endIndex) {
        if (root == null) return 0;
        if (root.startIndex == startIndex && root.endIndex == endIndex)//any matching node start index n end index or leaf node
            return root.sum;

        //if root node is [1,5] -> [1,2,3,4,5] -> mid = 3, this is mid of current root range not the array request index
        //then we have 3 case our request lies on left of this mid, or right or left+right both side(i.e. partial)
        int mid = root.startIndex + (root.endIndex - root.startIndex) / 2;//or (start + end )/2
        if (endIndex <= mid) { //case1: whole request is present in left side
            return recSum(root.left, startIndex, endIndex);
        } else if (startIndex >= mid + 1) {// case 2: whole request is present in right side
            return recSum(root.right, startIndex, endIndex);
        } else { //case 3: whole request is present in left + right
            return recSum(root.left, startIndex, mid)
                    + recSum(root.right, mid + 1, endIndex);
        }
    }

    public void updateOldValueInSegmentTree(int index, int newValue) {
        updateRec(root, index, newValue);
    }

    /**
     * leaf node = simply update the value (recursion coming from left rec call or right rec call)
     * find mid : call left if target index is left side , else right [internally recursion will update sum value]
     * finally add left sum + right sum [2 cases - its updated, or its not updated ]
     */
    private void updateRec(Node root, int index, int newValue) {
//        if (root == null) return;//null check
        if (root.startIndex == root.endIndex)
            root.sum = newValue;
        else { // else required else null point exception
            int mid = (root.startIndex + root.endIndex) / 2; //IMP :current node [1, 5] -> [1, 2, 3, 4, 5] -> mid = 3 -> then it will compare with index and go left or right
            //left and right rec will update sum value of left and right node
            if (index <= mid) updateRec(root.left, index, newValue);
            else updateRec(root.right, index, newValue);
            //now we have updated value of left and right nodes, so for current node i.e. root we just add left , right sum values
            root.sum = root.left.sum + root.right.sum;
        }
    }
}

public class SegmentTreeImpl {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 5, 3};
        SegmentImlp segmentTree = new SegmentImlp();
        segmentTree.buildSegmentTree(arr, 0, arr.length - 1);
        segmentTree.traverseSegmentTree();
        segmentTree.sumRange(1, 4);
        segmentTree.sumRange(0, 2);
        segmentTree.sumRange(1, 2);
        segmentTree.sumRange(3, 4);
        segmentTree.sumRange(0, 1);
        segmentTree.updateOldValueInSegmentTree(0, 10);
        segmentTree.sumRange(0, 1);
    }
}
/**
 0 0 : 1
 0 1 : 1
 1 1 : 0
 0 2 : 3
 2 2 : 2
 0 4 : 11
 3 3 : 5
 3 4 : 8
 4 4 : 3
 1 4 : sum = 10
 0 2 : sum = 3
 1 2 : sum = 2
 3 4 : sum = 8
 0 1 : sum = 1
 0 1 : sum = 10
 */
