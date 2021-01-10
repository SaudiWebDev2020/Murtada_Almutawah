public class d01 {
  public static void main(String[] args) {
    SinglyLinkedList sllTest = new SinglyLinkedList();
    sllTest.add(4);
    sllTest.add(5);
    sllTest.add(6);
    sllTest.add(7);

    sllTest.printValues();
    sllTest.reverse();
    sllTest.printValues();

    sllTest = SinglyLinkedList.reverseSLL(sllTest);
    sllTest.printValues();

  }
}
