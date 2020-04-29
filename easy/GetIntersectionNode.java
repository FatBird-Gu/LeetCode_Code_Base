package easy;


public class GetIntersectionNode {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur1 = headA;
        int lenA = 0;
        int lenB = 0;
        while (cur1.next != null) {
            lenA++;
            cur1 = cur1.next;
        }
        ListNode cur2 = headB;
        while (cur2.next != null) {
            lenB++;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur2 = headB;
        headB = lenA > lenB ? headB : headA;
        headA = lenA > lenB ? headA : cur2;
        int tmp = Math.abs(lenA - lenB);
        while (tmp > 0) {
            headA = headA.next;
            tmp--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
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
