package diffi;

import java.util.PriorityQueue;

public class MergeKLists {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode fNode = null;
        ListNode curNode = null;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            while (head != null) {
                heap.add(head.val);
                head = head.next;
            }
        }
        while (!heap.isEmpty()) {
            if (fNode == null) {
                curNode = new ListNode(heap.poll());
                fNode = curNode;
                continue;
            }
            curNode.next = new ListNode(heap.poll());
            curNode = curNode.next;
        }
        return fNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
