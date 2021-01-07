import java.util.ArrayList;

public class d05 {

  public static void main(String[] args) {
    System.out.println("The Pascal's triangle of " + 4 + " is " + calculatePascalTriangle(4).toString());
  }

  private static ArrayList<Integer> calculatePascalTriangle(int n) {
    ArrayList<Integer> array = new ArrayList<Integer>();
    if (n == 0) {
      array.add(1);
    } else if (n == 1) {
      array.add(1);
      array.add(1);
    } else {
      array.add(1);
      array.add(1);
      ArrayList<Integer> preArray;
      int count = 2;

      while (count <= n) {
        preArray = array;
        array = new ArrayList<Integer>();
        array.add(1);
        for (int i = 1; i < preArray.size(); i++) {
          array.add(preArray.get(i - 1) + preArray.get(i));
        }
        array.add(1);
        count++;
      }
    }

    // System.out.println("The Pascal's triangle of " + n + " is " +
    // array.toString());
    return array;
  }

}