public class DLLTest {
  public static void main(String[] args) {
    // DLL<Integer> dllInt = new DLL<Integer>();
    // System.out.println("The size of dll: " + dllInt.size());
    // System.out.println(dllInt);

    // dllInt.push(10);
    // dllInt.push(20);
    // dllInt.push(30);
    // dllInt.printValuesForward();
    // System.out.println(dllInt);
    // dllInt.printValuesBackward();

    // dllInt.pop();
    // dllInt.pop();
    // System.out.println(dllInt);

    // dllInt.addFront(9);
    // dllInt.addFront(8);
    // dllInt.addFront(7);

    // System.out.println(dllInt);

    // dllInt.removeFront();

    // System.out.println(dllInt);
    // System.out.println("9 in the dll: " + dllInt.contains(9));
    // System.out.println("90 in the dll: " + dllInt.contains(90));
    // System.out.println("The size of dll: " + dllInt.size());

    String palindrome = "Kiek";
    DLL<Character> dllStr = new DLL<Character>();
    for (int i = 0; i < palindrome.length(); i++) {
      dllStr.push(palindrome.charAt(i));
    }
    System.out.println(dllStr);
    System.out.println(palindrome + " palindrome? " + dllStr.isPalindrome());

    dllStr.insertAt('g', 7);
    System.out.println(dllStr);
    dllStr.printValuesBackward();
    dllStr.printValuesForward();

  }

}
