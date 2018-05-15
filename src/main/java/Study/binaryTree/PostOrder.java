package Study.binaryTree;

import util.TreeNode;

import java.util.Stack;

/**
 * Created by lenovo on 2017/10/19.
 */
public class PostOrder {
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

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
}
