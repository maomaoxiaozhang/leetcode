package Study.binaryTree;

import javafx.geometry.Pos;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lenovo on 2017/10/19.
 */
public class Test {
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

//        preOrderWithRecursion(root);
//        preOrderWithoutRecursion(root);
//        inOrderWithRecursion(root);
//        inOrderWithoutRecursion(root);
//        postOrderWithRecursion(root);
//        postOrderWithoutRecursion(root);

//        List<List<Integer>> result = new ArrayList<>();
//        levelWithRecursion(root, result, 0);
//        System.out.println(result);

        levelWithoutRecursion(root);
    }

    /*
    =======================================================前序=========================================================
    输出为1-2-4-5-3-6-7
     */
    public static void preOrderWithRecursion(TreeNode root) {
        if (root == null)
            return;
        else {
            System.out.println(root.val);
            preOrderWithRecursion(root.left);
            preOrderWithRecursion(root.right);
        }
    }

    //输出存右进左
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
    =======================================================中序=========================================================
    4-2-5-1-6-3-7
     */
    public static void inOrderWithRecursion(TreeNode root) {
        if (root == null)
            return;
        inOrderWithRecursion(root.left);
        System.out.println(root.val);
        inOrderWithRecursion(root.right);
    }

    //存左进左，输出再议
    //一口气存、进左，左无，出栈；右无，再出栈
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
    =======================================================后序=========================================================
    4-5-2-6-7-3-1
     */
    public static void postOrderWithRecursion(TreeNode root) {
        if (root == null)
            return;
        else {
            postOrderWithRecursion(root.left);
            postOrderWithRecursion(root.right);
            System.out.println(root.val);
        }
    }

    //关键是看stack，还是左子节点
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
    =======================================================层序=========================================================
    1-2-3-4-5-6-7
     */
    //需用k表示深度
    public static void levelWithRecursion(TreeNode root, List<List<Integer>> result, int k) {
        if (root == null)
            return;
        else {
            if (result.size() == k)
                result.add(new ArrayList<>());
            result.get(k).add(root.val);
            levelWithRecursion(root.left, result, k+1);
            levelWithRecursion(root.right, result, k+1);
        }
    }

    public static void levelWithoutRecursion(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.val);
            if (root.left != null)
                queue.offer(root.left);
            if (root.right != null)
                queue.offerLast(root.right);
        }
    }

}
