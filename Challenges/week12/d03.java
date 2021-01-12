public class d03 {
  public static void main(String[] args) {
    SinglyLinkedList sllTest = new SinglyLinkedList();
    sllTest.add(4);
    sllTest.add(5);
    sllTest.add(6);
    sllTest.add(7);
    sllTest.add(3);
    System.out.println(sllTest.hasLoop());
    sllTest.printValues();
    sllTest.createLoop(4);
    System.out.println(sllTest.hasLoop());

    sllTest.breakLoop();
    System.out.println(sllTest.hasLoop());
    sllTest.printValues();

  }
}