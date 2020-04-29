package mid;

public class RotateRight {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int num = 1;
        while (tail.next != null) {
            tail = tail.next;
            num++;
        }
        k = k % num;
        if (k == 0) {
            return head;
        }
        tail.next = head;
        int move = num - k;
        while (move-- == 0) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
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
