package mid;

public class DeleteDuplicates {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode latter = dummy;
        ListNode pre = head;
        while (pre != null) {
            if (pre.next != null && pre.val == pre.next.val) {
                do {
                    pre = pre.next;
                } while (pre.next != null && pre.val == pre.next.val);
                latter.next = pre.next;
                pre = pre.next;
            } else {
                pre = pre.next;
                latter = latter.next;
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
