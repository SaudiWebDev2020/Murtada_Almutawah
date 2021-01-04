import java.util.ArrayList;

import javax.lang.model.element.Element;

public class Basics {

  public void print(int i, int j) {
    for (; i <= j; i++) {
      System.out.println(i);
    }
  }

  public void printOdd(int i, int j) {
    for (; i <= j; i++) {
      if (i % 2 == 1) {
        System.out.println(i);
      }
    }
  }

  public void printSum(int i, int j) {
    int sum = 0;
    for (i = i - 1; i <= j; i++) {
      sum += i;
      System.out.println(String.format("New number: %d Sum: %d", i, sum));
    }
  }

  public void iterArray(int[] array) {
    String arrayStr = "[";
    try {
      for (int i = 0; i <= array.length - 1; i++) {
        arrayStr += array[i];
        if (i < array.length - 1) {
          arrayStr += ",";
        }
      }
    } catch (Exception e) {
    }
    arrayStr += "]";

    System.out.println(arrayStr);
  }

  public void iterArray(ArrayList<Integer> array) {
    String arrayStr = "[";
    for (int i = 0; i < array.size(); i++) {
      arrayStr += array.get(i);
      if (i < array.size() - 1) {
        arrayStr += ",";
      }
    }
    arrayStr += "]";

    System.out.println(arrayStr);
  }

  public void findMax(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (max < array[i]) {
        max = array[i];
      }
    }
    System.out.println(max);
  }

  public void findMax(ArrayList<Integer> array) {
    int max = array.get(0);
    for (int i = 1; i < array.size(); i++) {
      if (max < array.get(i)) {
        max = array.get(i);
      }
    }
    System.out.println(max);
  }

  public void getAverage(int[] array) {
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    double avg = 0;
    if (array.length != 0) {
      avg = sum / array.length;
    }
    System.out.println(String.format("The Average: %.2f", avg));
  }

  public void getAverage(ArrayList<Integer> array) {
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    double avg = 0;
    if (array.size() != 0) {
      avg = sum / array.size();
    }
    System.out.println(String.format("The Average: %.2f", avg));
  }

  public ArrayList<Integer> oddArray(int i, int j) {
    ArrayList<Integer> odd = new ArrayList<Integer>();
    for (; i <= j; i++) {
      if (i % 2 == 1) {
        odd.add(i);
      }
    }
    return odd;
  }

  public int printGraterThanY(int[] array, int y) {
    int count = 0;
    for (int value : array) {
      if (value > y) {
        count++;
      }
    }
    return count;
  }

  public int[] squareTheValues(int[] array) {
    // Square the values
    // Given any array x, say [1, 5, 10, -2], write a method that multiplies each
    // value in the array by itself. When the method is done, the array x should
    // have values that have been squared, say [1, 25, 100, 4].
    for (int i = 0; i < array.length; i++) {
      array[i] = (int) Math.pow(array[i], 2);
    }
    return array;
  }

  public int[] eliminateNegativeNumbers(int[] array) {

    for (int i = 0; i < array.length; i++) {
      if (array[i] < 0) {
        array[i] = 0;
      }
    }

    return array;
  }

  public long[] maxMinAvg(int[] array) {
    long[] retArr = new long[3];
    int max = array[0];
    int min = array[0];
    int sum = array[0];

    for (int i = 1; i < array.length; i++) {
      if (max < array[i]) {
        max = array[i];
      }
      if (min > array[i]) {
        min = array[i];
      }

      sum += array[i];
    }

    retArr[0] = max;
    retArr[1] = min;
    retArr[2] = sum / array.length;

    return retArr;
  }

  public void iterArray(long[] array) {
    String arrayStr = "[";
    for (int i = 0; i < array.length; i++) {
      arrayStr += array[i];
      if (i < array.length - 1) {
        arrayStr += ",";
      }
    }
    arrayStr += "]";
    System.out.println(arrayStr);
  }

  public ArrayList<Integer> shiftingValue(ArrayList<Integer> arrayList) {
    arrayList.remove(0);
    arrayList.add(0);
    return arrayList;
  }

}
