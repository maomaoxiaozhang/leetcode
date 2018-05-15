package Study.binaryTree;

import util.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * Created by lenovo on 2017/10/19.
 * 既根且左
 */
public class InOrder {
    public static boolean inOrder(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == target) {
            list.add(root);
            return true;
        } else if (root != null) {
            boolean r1 = inOrder(root.left, target, list);
            list.add(root);
            boolean r2 = inOrder(root.right, target, list);
            if (r1 || r2)
                return true;
            list.remove(list.size()-1);
        }
        return false;
    }

    //栈存储所有非空左子树的根节点
    public static void inOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

}
