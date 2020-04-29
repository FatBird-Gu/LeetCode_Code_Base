package easy;

public class HasCycle {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode f = head, s = head;
        int count = 0;
        while (s != null && f != null) {
            if (s.next == null || f.next == null || f.next.next == null) {
                break;
            }
            s = s.next;
            f = f.next.next;
            if (s == f) {
                if (count == 1) {
                    return true;
                }
                count++;
            }
        }
        return false;
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
