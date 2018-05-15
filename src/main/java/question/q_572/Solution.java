package question.q_572;

import util.TreeNode;

/**
 * Created by lenovo on 2017/10/5.
 * 树的定义就是递归，但是递归只能判断一次；整体上存在两次递归
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t){
        if (s == null)
            return false;
        if (isSame(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t){
        if (s == null && t == null)
            return true;
        else if (s != null && t == null)
            return false;
        else if (s == null && t != null)
            return false;
        else {
            if (t.val == s.val)
                return isSame(s.left, t.left) && isSame(s.right, t.right);
            else
                return false;
        }
    }
}
