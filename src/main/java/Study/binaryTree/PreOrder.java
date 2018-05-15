package Study.binaryTree;

import util.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * Created by lenovo on 2017/10/19.
 * 所有根节点也可以视为上一层的左节点
 * 前序输出是按斜行来的，stack负负得正；左子树向斜下，沿途输出当前节点且压栈右节点，若有左节点继续否则出栈转向下一行
 * root指向下一节点
 * 前序和树打交道，root一直取左子树，stack保存右子树，当左子树为空时root取栈顶元素
 * 既左且根
 *
 * 堆栈和队列保存的都是即将要处理的子树（树是递归定义的）
 */
public class PreOrder {
    public static boolean preOrder(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == target) {
            list.add(root);
            return true;
        } else {
            if (root != null) {
                list.add(root);
                boolean r1 = preOrder(root.left, target, list);
                boolean r2 = preOrder(root.right, target, list);
                if (r1 || r2)
                    return true;
                list.remove(list.size()-1);
                return false;
            } else {
                return false;
            }
        }
    }

    //栈内存储所有右子树的根节点，压root入栈保护栈底，最后pop得到的仍是root
    public static void preOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            System.out.println(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                root = root.left;
            else
                root = stack.pop();
        }
    }
}
