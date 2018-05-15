package Study.LowestCommonAncestor;

import util.TreeNode;

import java.util.List;

/**
 * Created by lenovo on 2017/10/23.
 * 先序遍历得到路径，求两条链表的交接处
 */
public class TwoLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = root;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node = node .right;
        node.right = new TreeNode(6);
        node = root.left;
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node = node.right;
        node.left = new TreeNode(7);
        node.right = new TreeNode(8);
        node = node.left;
        node.left = new TreeNode(9);

        List<TreeNode> p = new java.util.LinkedList<>();
        preOrder(root, root.left.right.left.left, p);
        List<TreeNode> q = new java.util.LinkedList<>();
        preOrder(root, root.left.right.right, q);
        help(p, q);
    }

    public static boolean preOrder(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null)
            return false;
        list.add(root);
        if (root == target)
            return true;
        boolean r1 = preOrder(root.left, target, list);
        boolean r2 = preOrder(root.right, target, list);
        if (r1 || r2)
            return true;
        list.remove(list.size()-1);
        return false;
    }

    public static void help(List<TreeNode> p, List<TreeNode> q) {
        System.out.print(p.get(p.size()-1).val + "\t" + q.get(q.size()-1).val);
        while (p.size() < q.size())
            q.remove(q.size()-1);
        while (p.size() > q.size())
            p.remove(p.size()-1);
        for (int i = p.size()-1; i >= 0; i--) {
            if (p.get(i) == q.get(i)) {
                System.out.print("\t公共祖先为：" + p.get(i).val);
                return;
            }
        }
    }
}
