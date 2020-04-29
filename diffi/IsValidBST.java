package diffi;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class IsValidBST {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        double inOrder = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (inOrder >= root.val) {
                    return false;
                }
                inOrder = root.val;
                root = root.right;
            }
        }
        return true;
    }

}
