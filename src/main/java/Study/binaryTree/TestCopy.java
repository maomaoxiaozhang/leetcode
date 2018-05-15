package Study.binaryTree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class TestCopy {
    static int max;
    public static void main(String[] args) {
        //建立一个3层的满二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode node = root.left;
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node = root.right;
        node.left = new TreeNode(6);
        node.right = new TreeNode(7);

//        preOrderWithoutRecursion(root);
//        inOrderWithoutRecursion(root);
//        postOrderWithoutRecursion(root);
//        levelOrderWithoutRecursion(root);
//        System.out.println(depth(root));
//        System.out.println(number(root));
//        fareaway(root);
//        System.out.println(max);
//        System.out.println(balence(root, new int[1]));
//        System.out.println(lca(root, root.left, root.left.right).val);

    }

    /*
    ===================================================前序=============================================================
    1-2-4-5-3-6-7
     */
    public static void preOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            System.out.println(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                root = root.left;
            else
                root = stack.pop();
        }
    }

    /*
    ===================================================中序=============================================================
    4-2-5-1-6-3-7
     */
    public static void inOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    /*
    ===================================================后序=============================================================
    4-5-2-6-7-3-1
     */
    public static void postOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode last = root;
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.right == null || root.right == last) {
                System.out.println(root.val);
                last = root;
            }else {
                stack.push(root);
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
    }

    /*
    ===================================================层序=============================================================
     */
    public static void levelOrderWithoutRecursion(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.println(current.val);
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);
        }
    }

    /*
    ===================================================求树的高度=======================================================
     */
    public static int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return 1 + Math.max(left, right);
    }

    /*
    ===================================================求节点个数=======================================================
     */
    public static int number(TreeNode root) {
        if (root == null)
            return 0;
        int left = number(root.left);
        int right = number(root.right);
        return 1+left+right;
    }

    /*
    ===================================================求距离最远节点===================================================
     */
    public static int fareaway(TreeNode root) {
        if (root == null)
            return 0;
        int left = fareaway(root.left);
        int right = fareaway(root.right);
        max = Math.max(max, left+right+1);
        return 1 + Math.max(left, right);
    }

    /*
    ===================================================判断是否平衡=====================================================
     */
    public static boolean balence(TreeNode root, int[] depth) {
        if (root == null)
            return true;
        int[] left = new int[1];
        int[] right = new int[1];
        if (balence(root.left, left) && balence(root.right, right)) {
            depth[0] = 1+Math.max(left[0], right[0]);
            if (Math.abs(left[0]-right[0]) <= 1 )
                return true;
        }
        return false;
    }

    /*
    ===================================================lca==============================================================
    1.left != null && right != null
        找到了lca，直接返回root
    2.未找到时，反悔的是p或者q
      找到时，返回的是root
     */
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }
}
