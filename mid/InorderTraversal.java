package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (node != null || !st.isEmpty()) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                node = st.pop();
                res.add(node.val);
                node = node.right;
            }
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
