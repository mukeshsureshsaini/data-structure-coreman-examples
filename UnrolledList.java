
public class UnrolledList {

	static class Node {
		int noOfElements;
		char[] elements;
		Node next;

		public Node(int noOfElements, char[] elements, Node next) {
			this.noOfElements = noOfElements;
			this.elements = elements;
			this.next = next;
		}

	}

	public static void main(String[] args) {

		Node head = new Node(3, new char[] { 'a', 'b', 'c' },
				new Node(2, new char[] { 'd', 'e' }, new Node(1, new char[] { 'f' }, null)));
		System.out.println(findPos(head, 6));
		
		System.out.println(findPos(head, 0));
		System.out.println(findPos(head, 1));
		System.out.println(findPos(head, 2));
		
		
		System.out.println(findPos(head, 3));
		
		System.out.println(findPos(head, 4));
		System.out.println(findPos(head, 5));
		System.out.println(findPos(head, 9));

	}

	public static char findPos(Node head, int pos) {
		if (head == null || pos < 0)
			return '-';
		while (head != null) {
			int NOE = head.noOfElements;
			if (pos < NOE)
				return head.elements[pos];
			else {
				pos -= NOE;
				head = head.next;
			}
		}
		return '-';
	}

}
