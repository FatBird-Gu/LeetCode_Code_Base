package easy;

public class HasPathSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return process(root, sum, 0);
    }

    public boolean process(TreeNode root, int sum, int record) {
        if (root.right == null && root.left == null) {
            return (record + root.val) == sum;
        }
        record += root.val;
        if (root.left == null) {
            return process(root.right, sum, record);
        }
        if (root.right == null) {
            return process(root.left, sum, record);
        }
        return process(root.left, sum, record) || process(root.right, sum, record);
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
