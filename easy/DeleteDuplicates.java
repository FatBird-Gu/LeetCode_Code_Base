package easy;


public class DeleteDuplicates {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head, next = head;
        while (next != null) {
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
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
