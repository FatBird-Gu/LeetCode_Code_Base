package mid;

public class Partition86 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode head1 = null;
        ListNode tail1 = head1;
        ListNode head2 = null, tail2 = head2;
        while (head != null) {
            if (head.val < x) {
                if (head1 == null) {
                    head1 = new ListNode(head.val);
                    tail1 = head1;
                } else {
                    tail1.next = new ListNode(head.val);
                    tail1 = tail1.next;
                }
            } else {
                if (head2 == null) {
                    head2 = new ListNode(head.val);
                    tail2 = head2;
                } else {
                    tail2.next = new ListNode(head.val);
                    tail2 = tail2.next;
                }
            }
            head = head.next;
        }
        if (head1 == null) {
            return head2;
        } else {
            tail1.next = head2;
        }
        return head1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
