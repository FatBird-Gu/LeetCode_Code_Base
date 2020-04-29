package mid;

public class ReverseBetween {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = new ListNode(0), head2;
        head1.next = head;
        int t = m - 1;
        while (t > 0) {
            head1 = head1.next;
            t--;
        }
        ListNode node1 = head1.next, node2 = head1;
        int tmp = n - m + 1;
        while (tmp > 0) {
            node2 = node2.next;
            tmp--;
        }
        head2 = node2.next;
        head1.next = node2;
        //reverse
        ListNode pre = null, cur = node1, next = node1.next;
        while (next != head2) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        node1.next = head2;
        return m == 1 ? node2 : head;
    }

}
