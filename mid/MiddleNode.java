package mid;

public class MiddleNode {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return f.next == null ? s : s.next;
    }

}
