package question.q_104;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/9/18.
 * Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 求二叉树的最大深度
 *
 * 思路：二叉树本身是递归定义的，因此求解二叉树相关问题时优先考虑递归求解
 */
public class q_104 {
    public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);
        return ld > rd ? (ld+1) : (rd+1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashMap<Integer, TreeNode> binTree = new HashMap<>();
        System.out.println("请输入根节点: ");
        int root = in.nextInt();
        System.out.println("请输入所有节点：");
        int line = in.nextInt();
        while (line != -1){
            TreeNode node = new TreeNode(line);
            node.left = null;
            node.right = null;
            binTree.put(line, node);
            line = in.nextInt();
        }
        System.out.println("请输入所有节点关系：");
        line = in.nextInt();
        while (line != -1){
            TreeNode node = binTree.get(line);
            line = in.nextInt();
            TreeNode leftNode = null;
            if (line != 0)
                leftNode = binTree.get(line);
            line = in.nextInt();
            TreeNode rightNode = null;
            if (line != 0)
                rightNode = binTree.get(line);
            node.left = leftNode;
            node.right = rightNode;
            line = in.nextInt();
        }

        q_104 q = new q_104();
        int depth = q.maxDepth(binTree.get(root));
        System.out.println(depth);

    }
}
