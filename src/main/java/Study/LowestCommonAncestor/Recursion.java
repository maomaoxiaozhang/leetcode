package Study.LowestCommonAncestor;

import util.TreeNode;

/**
 * Created by lenovo on 2017/10/23.
 * 树的分布只有两种情况：在同一边或者分布在某一根节点的两边
 */
public class Recursion {
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

        TreeNode p = root.left.right.left.left;
        TreeNode q = root.left.right.right;
        TreeNode ancestor = recursion(root, p, q);
        System.out.println(p.val + "\t" + q.val + "\t公共祖先为：" + ancestor.val);
    }

    public static TreeNode recursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = recursion(root.left, p, q);
        TreeNode right = recursion(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }
}
