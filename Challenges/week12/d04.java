public class d04 {
  public static void main(String[] args) {
    DLL<Integer> dllInt = new DLL<Integer>();
    dllInt.push(10);
    dllInt.push(20);
    dllInt.push(30);
    System.out.println(dllInt);

    dllInt.pop();
    dllInt.pop();
    System.out.println(dllInt);

    dllInt.addFront(9);
    dllInt.addFront(8);
    dllInt.addFront(7);

    System.out.println(dllInt);

    dllInt.removeFront();
    dllInt.removeFront();

    System.out.println(dllInt);

  }
}
