package mid;

public class SwapPairs {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        ListNode pre = head;
        while (head != null) {
            pre.next = head.next == null ? head : head.next;
            pre = head;
            ListNode cur = head.next;
            if (cur == null) {
                break;
            }
            head.next = cur.next;
            cur.next = head;
            head = head.next;

        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
