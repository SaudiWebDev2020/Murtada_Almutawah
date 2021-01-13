
public class DLL<T> {
  public DLLNode<T> head;
  public DLLNode<T> tail;

  public DLL() {
    this.head = null;
    this.tail = null;
  }

  public void push(T value) {
    DLLNode<T> newNode = new DLLNode<T>(value);
    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
      return;
    }

    newNode.previous = this.tail;
    this.tail.next = newNode;
    this.tail = this.tail.next;
  }

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