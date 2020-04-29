package easy;

public class ReverseList {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = head;
        head = null;
        while (cur != null) {
            cur = cur.next;
            pre.next = head;
            head = pre;
            pre = cur;
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
