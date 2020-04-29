package mid;


  /*class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }*/

public class AddTwoNumbers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		System.out.println(l1.val);
		l2 = reverse(l2);
		int flag = 0;
		ListNode head = l1, pre1 = l1;
		while (l1 != null && l2 != null) {
			int tmp = (l1.val + l2.val + flag);
			l1.val = tmp % 10;
			flag = tmp / 10;
			pre1 = l1;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int tmp = (l1.val + flag);
			l1.val = tmp % 10;
			flag = tmp / 10;
			pre1 = l1;
			l1 = l1.next;
		}
		while (l2 != null) {
			int tmp = (l2.val + flag);
			pre1.next = new ListNode(tmp % 10);
			flag = tmp / 10;
			pre1 = pre1.next;
			l2 = l2.next;
		}

		if (flag != 0) {
			pre1.next = new ListNode(flag);
		}
		return reverse(head);
	}

	public int countNum(ListNode cur) {
		int count = 0;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}

	public ListNode reverse(ListNode cur) {
		ListNode head = null;
		ListNode next = cur.next;

		while (next != null) {
			cur.next = head;
			head = cur;
			cur = next;
			next = next.next;
		}
		cur.next = head;
		head = cur;
		return head == null ? cur : head;
	}

}
