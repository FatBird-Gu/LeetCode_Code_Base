package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal144 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        process(root, res);
        return res;
    }
    public void process(TreeNode root, List<Integer> ls) {
        if (root == null) {
            return ;
        }
        ls.add(root.val);
        process(root.left, ls);
        process(root.right, ls);
    }*/
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            root = st.pop();
            res.add(root.val);
            if (root.right != null) {
                st.add(root.right);
            }
            if (root.left != null) {
                st.add(root.left);
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
