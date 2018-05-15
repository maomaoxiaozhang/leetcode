package Study.LowestCommonAncestor;

import util.TreeNode;

import java.util.HashMap;

/**
 * Created by lenovo on 2017/10/23.
 *
 * Tarjan算法的基本思路：
 　    1.任选一个点为根节点，从根节点开始。
 　　　2.遍历该点u所有子节点v，并标记这些子节点v已被访问过（最后一步）。
 　　　3.若是v还有子节点，返回2，否则下一步。
 　　　4.合并v到u上。
 　　　5.寻找与当前点u有询问关系的点v。
 　　　6.若是v已经被访问过了，则可以确认u和v的最近公共祖先为v被合并到的父亲节点a。
 */
public class TarJan {
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
        int[] visit = new int[10];
        int[] parent = new int[10];
        for (int i = 1; i < 10; i++)
            parent[i] = i;
        HashMap<TreeNode, TreeNode> query = new HashMap<>();
        query.put(root.left.right.left.left, root.left.right.right);
        query.put(root.left.left, root.right.right);
        query.put(root.left.right.left, root.left.right);
        query.put(root.left.right, root.right);

        dfs(root, root, visit, parent, query);
    }

    public static void dfs(TreeNode root, TreeNode father, int[] visit, int[] parent, HashMap<TreeNode, TreeNode> query) {
        if (root == null)
            return;
        dfs(root.left, root, visit, parent, query);
        dfs(root.right, root, visit, parent, query);

        for (TreeNode node : query.keySet()) {
            if (node == root) {
                if (visit[query.get(node).val] == 1) {
                    int val = query.get(node).val;
                    while (val != parent[val])
                        val = parent[val];

                    System.out.println(node.val + "\t" + query.get(node).val + "\t公共祖先为：" + val);
                }
            } else if (query.get(node) == root) {
                if (visit[node.val] == 1) {
                    int val = node.val;
                    while (val != parent[val])
                        val = parent[val];
                    System.out.println(root.val + "\t" + node.val + "\t公共祖先为：" + val);
                }
            }
        }
        parent[root.val] = father.val;
        visit[root.val] = 1;
    }
}
