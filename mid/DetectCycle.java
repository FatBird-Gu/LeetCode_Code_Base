package mid;


public class DetectCycle {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode f = head, s = head;
        int count = 0;
        while (s != null && f != null) {
            if (s.next == null || f.next == null || f.next.next == null) {
                return null;
            }
            s = s.next;
            f = f.next.next;
            if (s == f) {
                break;
            }
        }
        f = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        return s;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
