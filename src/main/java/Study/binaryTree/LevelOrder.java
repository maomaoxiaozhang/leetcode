package Study.binaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lenovo on 2017/10/19.
 * 层序是和队列打交道，每次root取值都从队列中取首元素
 */
public class LevelOrder {
    public static void levelOrder(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.get(0);
            System.out.println(root.val);
            queue.remove(0);
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
        }
    }

    public static void levelOrderWithRecursion(TreeNode root, int k, List<List<TreeNode>> list) {
        if (root != null) {
            if (list.size() < k)
                list.add(new ArrayList<>());
            list.get(k-1).add(root);
            levelOrderWithRecursion(root.left, k+1, list);
            levelOrderWithRecursion(root.right, k+1, list);
        }
    }

}
