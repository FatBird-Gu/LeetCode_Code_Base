package mid;

public class BuildTreeInPos {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (postorder[postorder.length - 1] == inorder[i]) {
                index = i;
                break;
            }
        }
        int left = index - 0;
        root.left = buildTree(inorder, postorder, 0, index - 1, 0, left - 1);
        root.right = buildTree(inorder, postorder, index + 1, inorder.length - 1, left, postorder.length - 2);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int li, int ri, int lp, int rp) {
        if (li > ri || lp > rp) {
            return null;
        }
        if (li == ri) {
            return new TreeNode(inorder[li]);
        }
        if (lp == rp) {
            return new TreeNode(inorder[lp]);
        }
        TreeNode node = new TreeNode(postorder[rp]);
        int index = 0;
        for (int i = li; i <= ri; i++) {
            if (postorder[rp] == inorder[i]) {
                index = i;
                break;
            }
        }
        int left = index - li;
        node.left = buildTree(inorder, postorder, li, index - 1, lp, lp + left - 1);
        node.right = buildTree(inorder, postorder, index + 1, ri, lp + left, rp - 1);
        return node;
    }
}
