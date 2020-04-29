package mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> tmpqueue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                tmpqueue.offer(cur.left);
            }
            if (cur.right != null) {
                tmpqueue.offer(cur.right);
            }
            if (queue.isEmpty()) {
                res.add(cur.val);
                queue = tmpqueue;
                tmpqueue = new LinkedList<>();
                queue = null;
            }
        }
        return res;
    }

}
