package diffi;

public class ReverseKGroup25 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode
				list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);
		ReverseKGroup25 rb = new ReverseKGroup25();
		rb.reverseKGroup(list, 2);
		while (list != null) {
			System.out.println(list.val);
			list = list.next;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode check = head;

		for (int i = 1; i <= k; i++) {
			if (check == null) {
				return head;
			}
			check = check.next;
		}
		//head...check
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = head;
		while (cur != check) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		head.next = reverseKGroup(check, k);
		return pre;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
