package diffi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal145 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.add(root);
            if (root.left != null) {
                s1.add(root.left);

            }
            if (root.right != null) {
                s1.add(root.right);
            }
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
