package easy;

import java.util.ArrayList;
import java.util.List;

public class IsSameTree {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<String> sp = new ArrayList<String>();
        List<String> sq = new ArrayList<>();
        processInOrder(p, sp);
        processInOrder(q, sq);
        return sp.equals(sq);
    }

    public void processInOrder(TreeNode root, List<String> l) {
        if (root == null) {
            l.add("#");
            return;
        }
        l.add(String.valueOf(root.val));
        processInOrder(root.left, l);
        processInOrder(root.right, l);
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
