public class SinglyLinkedList {
	public Node head;

	public SinglyLinkedList() {
		// your code here
		head = null;
	}

	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}

	public void remove() {
		if (head == null) {
			// empty
			System.out.println("It is empty");
		} else if (head.next == null) {
			// one item
			int deleted = head.value;
			head = null;
			System.out.println("First item " + deleted + " deleted");
		} else {
			Node runner = head;
			while (runner.next.next != null) {
				runner = runner.next;
			}
			int deleted = runner.next.value;
			runner.next = null;
			System.out.println("Last item " + deleted + " deleted");
		}
	}

	public void reverse() {
		if (head == null) {
			// it is empty
		} else if (head.next == null) {
			// it is size 1
		} else {
			Node prevNode, currentNode, nextNode;
			prevNode = null;
			currentNode = head;
			nextNode = head.next;

			while (currentNode != null) {

				currentNode.next = prevNode;

				prevNode = currentNode;
				currentNode = nextNode;

				if (nextNode != null) {
					nextNode = nextNode.next;
				}
			}

			head = prevNode;
		}
	}

	public static SinglyLinkedList reverseSLL(SinglyLinkedList ssl) {
		SinglyLinkedList newSSL = new SinglyLinkedList();
		Node runner = ssl.head;
		while (runner != null) {
			newSSL.addBack(runner.value);
			runner = runner.next;
		}
		// Print rev
		// newSSL.printValues();
		return newSSL;
	}

	public void addBack(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void printValues() {
		if (head == null) {
			System.out.println("[ ]");
		} else {
			Node runner = head;
			String str = "[";
			while (runner != null) {
				str += runner.value;
				runner = runner.next;
				if (runner != null) {
					str += ", ";
				}
			}

			System.out.println(str + "]");
		}
	}

}