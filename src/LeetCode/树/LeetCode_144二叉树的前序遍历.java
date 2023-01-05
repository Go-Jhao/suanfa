package LeetCode.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_144二叉树的前序遍历 {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        accessTree(root,res);
//        return res;
//    }
//
//    private void accessTree(TreeNode root, List<Integer> res) {
//        if (root == null){
//            return;
//        }
//        res.add(root.val);
//        accessTree(root.left,res);
//        accessTree(root.right,res);
//    }
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()){
        while (root != null){
            res.add(root.val);
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        root = root.right;

    }
    return res;
}
}

