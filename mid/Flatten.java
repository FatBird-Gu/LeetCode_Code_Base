package mid;

import java.util.ArrayList;
import java.util.List;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode cur1 = null;
        while (cur != null) {
            if (cur.left != null) {
                cur1 = cur.left;
                while (cur1.right != null && cur1.right != cur) {
                    cur1 = cur1.right;
                }
                if (cur1.right == null) {
                    cur1.right = cur;
                    list.add(cur);
                    cur = cur.left;
                    continue;
                } else {
                    cur1.right = null;
                }
            } else {
                list.add(cur);
            }
            cur = cur.right;
        }
        int len = list.size();
        root.left = null;
        for (int i = 1; i < len; i++) {
            list.get(i).left = null;
            list.get(i - 1).right = list.get(i);
        }
        return;
    }
}
