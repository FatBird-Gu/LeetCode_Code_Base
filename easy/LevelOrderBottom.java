package easy;

import java.util.*;


public class LevelOrderBottom {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("asb".compareTo("bsa"));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Stack<List<Integer>> st = new Stack<>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode tmp = queue1.poll();
                list.add(tmp.val);
                if (tmp.left != null) {
                    queue2.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue2.add(tmp.right);
                }
            }
            st.add(list);

            queue1 = queue2;
            queue2 = new LinkedList<>();
        }
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
        return res;
    }

}
