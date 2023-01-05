package LeetCode.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_145二叉树的后序遍历 {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        accessTree(root,res);
//        return res;
//    }
//
//    private void accessTree(TreeNode root, List<Integer> res) {
//        if (root == null){
//            return;
//        }
//        accessTree(root.left,res);
//        accessTree(root.right,res);
//        res.add(root.val);
//    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode preAccess = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == preAccess) {
                res.add(root.val);
                preAccess = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
