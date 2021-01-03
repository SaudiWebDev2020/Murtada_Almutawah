public class StringManipulatorTest {
  public static void main(String[] args) {
    Example1();
    Example2();
    Example3();
    Example4();
  }

  public static void Example1() {
    StringManipulator manipulator = new StringManipulator();
    String str = manipulator.trimAndConcat("    Hello     ", "     World    ");
    System.out.println(str); // HelloWorld
  }

  public static void Example2() {
    StringManipulator manipulator = new StringManipulator();
    char letter = 'o';
    Integer a = manipulator.getIndexOrNull("Coding", letter);
    Integer b = manipulator.getIndexOrNull("Hello World", letter);
    Integer c = manipulator.getIndexOrNull("Hi", letter);
    System.out.println(a); // 1
    System.out.println(b); // 4
    System.out.println(c); // null
  }

  public static void Example3() {
    StringManipulator manipulator = new StringManipulator();
    String word = "Hello";
    String subString = "llo";
    String notSubString = "world";
    Integer a = manipulator.getIndexOrNull(word, subString);
    Integer b = manipulator.getIndexOrNull(word, notSubString);
    System.out.println(a); // 2
    System.out.println(b); // null
  }

  public static void Example4() {
    StringManipulator manipulator = new StringManipulator();
    String word = manipulator.concatSubstring("Hello", 1, 2, "world");
    System.out.println(word); // eworld
  }

}
