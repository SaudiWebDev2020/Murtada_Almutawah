
public class DLL<T> {
  public DLLNode<T> head;
  public DLLNode<T> tail;

  public DLL() {
    this.head = null;
    this.tail = null;
  }

  // the push method will add a new node to the end of the list
  public void push(T value) {

    // Create a node to be used.
    DLLNode<T> newNode = new DLLNode<T>(value);

    // if there is no head in the list, aka, an empty list, we set the newNode to be
    // the head and tail of the list
    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
      return;
    }

    // Otherwise
    // first find the lastNode in the list (tail)
    // then, set the lastNode's next to be the newNode;
    // then, we have to set the previous of the lastNode to the lastNode that we
    // found previously.
    // finally, set the list's tail to be the node that we have added
    newNode.previous = this.tail;
    this.tail.next = newNode;
    this.tail = this.tail.next;
  }

  public void printValuesForward() {
    // find the first node, aka head.
    DLLNode<T> current = this.head;

    // while the current node exists...
    while (current != null) {
      // print it's value
      System.out.println(current.value);
      // and move on to it's next node.
      current = current.next;
    }
  }
  // In this assignment, you will implement common methods for Doubly Linked Lists

  // DONE void printValuesBackward(): This method prints the values of the nodes
  // from the tail to the head.
  public void printValuesBackward() {
    // find the first node, aka head.
    DLLNode<T> current = this.tail;

    // while the current node exists...
    while (current != null) {
      // print it's value
      System.out.println(current.value);
      // and move on to it's next node.
      current = current.previous;
    }
  }

  // DONE Node pop(): This method removes the last node of our DLL and returns it.
  public T pop() {
    if (this.head == null) {
      return null;
    }

    T lasNodeValue = this.tail.value;
    this.tail = this.tail.previous;
    this.tail.next.previous = null;
    this.tail.next = null;

    return lasNodeValue;
  }

  // DONE boolean contains(Integer value): This method returns a boolean whether
  // the value in the argument is in the list or not. Return true if the value
  // exists, else, return false.
  public boolean contains(T value) {
    boolean found = false;

    DLLNode<T> current = this.head;

    if (current != null) {

      while (current != null) {
        if (current.value.equals(value)) {
          return true;
        }

        current = current.next;
      }

    }

    return found;
  }

  // DONE int size(): Returns the number of nodes in the list.
  public int size() {
    int counter = 0;
    DLLNode<T> runner = this.head;

    while (runner != null) {
      counter++;
      runner = runner.next;
    }

    return counter;
  }

  // If you completed all the methods above, challenge yourself and try the
  // following:

  // DONE void insertAt(Node newNode, int index): Inserts a node at a specific
  // index. For example, let's say that we have 3 nodes in our list. If we call
  // insertAt(newNode, 1), the newNode should be inserted right after the head.
  // (head is index 0)
  public void insertAt(T value, int index) {
    // Check index
    if (index < 0) {
      return;
    }
    // if at the start
    if (index == 0) {
      this.addFront(value);
      return;
    }

    // index more than size
    if (index >= this.size()) {
      this.push(value);
      return;
    }

    // Start traversing
    int count = 0;
    DLLNode<T> current = this.head;

    while (count < index && current != null) {
      current = current.next;
      count++;
    }

    DLLNode<T> newNode = new DLLNode<T>(value);

    current.previous.next = newNode;
    newNode.previous = current.previous;
    current.previous = newNode;
    newNode.next = current;
  }

  // DONE void removeAt(int index): This method removes a node at an index. For
  // example, let's say that we have 3 nodes in our list. If we call removeAt(1),
  // the middle node is removed. (head is index 0)
  public void removeAt(int index) {

    // Check index
    if (index < 0) {
      return;
    }

    if (index >= this.size()) {
      return;
    }

    // Check empty
    if (this.head == null) {
      return;
    }

    // Start traversing
    int count = 0;
    DLLNode<T> current = this.head;

    while (count < index && current != null) {
      current = current.next;
      count++;
    }

    // if end;
    if (current == tail) {
      this.pop();
      return;
    }

    // if start;
    if (current == head) {
      this.removeFront();
      return;
    }

    // if middle;
    current.previous.next = current.next;
    current.next.previous = current.previous;
  }

  // DONE boolean isPalindrome(): This method returns a boolean whether the node
  // is a palindrome or not. Return true if it is a palindrome, else, return
  // false.

  public boolean isPalindrome() {
    boolean palindrome = true;

    if (head != null) {
      DLLNode<T> runner = this.head;
      DLLNode<T> backer = this.tail;

      while (runner != backer) {
        if (!runner.value.equals(backer.value)) {
          return false;
        }

        runner = runner.next;
        backer = backer.previous;
      }

    }

    return palindrome;
  }

  public void addFront(T value) {
    DLLNode<T> newNode = new DLLNode<T>(value);
    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
      return;
    }

    newNode.next = this.head;
    this.head.previous = newNode;
    this.head = this.head.previous;
  }

  public T removeFront() {
    if (this.head == null) {
      return null;
    }

    T firstNodeValue = this.head.value;

    this.head = this.head.next;
    this.head.previous.next = null;
    this.head.previous = null;

    return firstNodeValue;

  }

  public String toString() {
    String str = "[";
    DLLNode<T> current = this.head;

    while (current != null) {
      str += current.value;
      if (current.next != null) {
        str += ", ";
      }
      current = current.next;
    }

    return str + "]";
  }
}