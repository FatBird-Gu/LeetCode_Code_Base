package mid;

import java.util.HashMap;

public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        RemoveNthFromEnd19 t = new RemoveNthFromEnd19();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        HashMap<Integer, ListNode> hm = new HashMap<>();
        int index = 0;
        while (node != null) {
            hm.put(++index, node);
            node = node.next;
        }
        index = index - n + 1;

        if (!hm.containsKey(index - 1)) {
            head = head.next;
        } else {
            ListNode pre = hm.get(index - 1);
            pre.next = hm.get(index).next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
