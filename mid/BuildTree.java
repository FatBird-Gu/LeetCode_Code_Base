package mid;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                index = i;
                break;
            }
        }
        int left = index;
        int right = inorder.length - index - 1;
        root.left = process(preorder, inorder, 1, left, 0, index - 1);
        root.right = process(preorder, inorder, left + 1, preorder.length - 1, index + 1, inorder.length - 1);
        return root;
    }

    public TreeNode process(int[] preorder, int[] inorder, int lp, int rp, int li, int ri) {
        if (lp > rp || li > ri)
            return null;
        if (lp == rp) {
            return new TreeNode(preorder[lp]);
        }
        if (ri == li) {
            return new TreeNode(preorder[li]);
        }
        TreeNode root = new TreeNode(preorder[lp]);
        int index = 0;
        for (int i = li; i <= ri; i++) {
            if (preorder[lp] == inorder[i]) {
                index = i;
                break;
            }
        }
        int left = index - li;
        int right = (ri - li + 1) - left - 1;
        root.left = process(preorder, inorder, lp + 1, lp + left, li, index - 1);
        root.right = process(preorder, inorder, lp + left + 1, rp, index + 1, ri);
        return root;
    }
}
