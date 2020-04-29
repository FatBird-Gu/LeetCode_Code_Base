package diffi;

public class MaxPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root);
        return max;
    }

    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Integer left = Math.max(process(root.left), 0);
        Integer right = Math.max(process(root.right), 0);

        int tmp = left + right + root.val;
        max = Math.max(tmp, max);
        return root.val + Math.max(left, right);
    }

}
