
public class DLLNode<T> {
  public T value;
  public DLLNode<T> previous;
  public DLLNode<T> next;

  public DLLNode(T value) {
    this.value = value;
    this.previous = null;
    this.next = null;
  }

}
