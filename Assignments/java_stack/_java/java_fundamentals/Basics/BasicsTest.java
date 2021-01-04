import java.util.ArrayList;

public class BasicsTest {
  public static void main(String[] args) {
    Basics basics = new Basics();
    // 1-3
    // basics.print(1, 255);
    // basics.printOdd(1, 255);
    // basics.printSum(1, 255);

    int[] array = new int[] { 1, 3, 5, 7, 9, 13 };
    int[] array2 = new int[] { 1, 5, 10, -2 };
    basics.iterArray(array2);
    // basics.findMax(array);
    // basics.getAverage(array);
    // // 7 - 8
    // ArrayList<Integer> emptyArray = new ArrayList<Integer>();
    // basics.getAverage(emptyArray);

    // ArrayList<Integer> oddArr = basics.oddArray(1, 255);
    // basics.iterArray(oddArr);
    // basics.getAverage(oddArr);
    // basics.findMax(oddArr);
    // System.out.println(basics.printGraterThanY(array, 9));

    // 9
    array2 = basics.squareTheValues(array2);
    basics.iterArray(array2);

    int[] arrayNegatives = new int[] { -1, 2, 5, -1, 5 };
    basics.iterArray(arrayNegatives);
    arrayNegatives = basics.eliminateNegativeNumbers(arrayNegatives);
    basics.iterArray(arrayNegatives);

    basics.iterArray(array);
    basics.getAverage(array);
    long[] maxMinAvg = basics.maxMinAvg(array);
    basics.iterArray(maxMinAvg);

    // 10
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(1);
    arrayList.add(5);
    arrayList.add(10);
    arrayList.add(7);
    arrayList.add(-2);
    basics.iterArray(arrayList);
    arrayList = basics.shiftingValue(arrayList);
    basics.iterArray(arrayList);
    arrayList = basics.shiftingValue(arrayList);
    basics.iterArray(arrayList);
    arrayList = basics.shiftingValue(arrayList);
    basics.iterArray(arrayList);

  }
}
