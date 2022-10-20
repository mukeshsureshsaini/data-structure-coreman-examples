
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class LinkedListSum {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode reversed1 = l1;
		ListNode reversed2 = l2;

		ListNode sum = new ListNode();
		ListNode current = sum;
		int carry = 0;

		while (reversed1 != null && reversed2 != null) {
			int dataSum = (reversed1.val + reversed2.val) + carry;
			int nodeSum = dataSum % 10;
			carry = dataSum / 10;
			ListNode newNode = new ListNode(nodeSum);
			current.next = newNode;
			current = newNode;
			reversed1 = reversed1.next;
			reversed2 = reversed2.next;
		}

		while (reversed1 != null) {
			int dataSum = reversed1.val + carry;
			int nodeSum = dataSum % 10;
			carry = dataSum / 10;
			ListNode newNode = new ListNode(nodeSum);
			current.next = newNode;
			current = newNode;
			reversed1 = reversed1.next;
		}
		while (reversed2 != null) {
			int dataSum = reversed2.val + carry;
			int nodeSum = dataSum % 10;
			carry = dataSum / 10;
			ListNode newNode = new ListNode(nodeSum);
			current.next = newNode;
			current = newNode;
			reversed2 = reversed2.next;
		}

		if (carry != 0) {
			ListNode newNode = new ListNode(carry);
			current.next = newNode;
		}

		return sum.next;
	}

	public static void main(String[] args) {

		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(9);
		ListNode current = l1;
		int i = 6;
		while (i > 0) {
			ListNode temp = new ListNode(9);
			current.next = temp;
			current = temp;
			i -= 1;
		}

		i = 3;
		current = l2;
		while (i > 0) {
			ListNode temp = new ListNode(9);
			current.next = temp;
			current = temp;
			i -= 1;
		}

		ListNode sum = addTwoNumbers(l1, l2);
		while (sum != null) {
			System.out.printf("%d\t",sum.val);
			sum = sum.next;
		}

	}
}
