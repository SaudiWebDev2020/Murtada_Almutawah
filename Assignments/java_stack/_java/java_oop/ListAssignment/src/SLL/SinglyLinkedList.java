package SLL;

public class SinglyLinkedList {
    public Node head;  
    public SinglyLinkedList() {
        // your code here
    	head = null;
    }
    
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
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
			System.out.println("First item "+deleted+" deleted");
		} else { 
			Node runner = head;
			while(runner.next.next != null) {
				runner = runner.next;
	        }
			int deleted = runner.next.value;
			runner.next = null;
			System.out.println("Last item "+deleted+" deleted");
		}
	}
	public void printValues() {
		if(head == null ) {
			System.out.println("[ ]");
		} else {
			Node runner = head;
			String str = "[";
			while(runner != null) {
				str += runner.value;
	            runner = runner.next;
	            if (runner != null) {
	            	str += ", ";
	            }
	        }
			
			System.out.println(str+"]");
			}
		}

    // Optional Challenges:
    // TODO ● Implement a find(int) method that will return the first node with the value in the parameter
    // TODO ● Implement a removeAt(int) method that will remove the node after n nodes, where n is the parameter. For example, if n is 0, remove the first node. If n is 1, remove the second node. Similar to Arrays.
}