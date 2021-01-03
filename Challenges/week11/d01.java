public class d01 {
  public static Boolean balancePoint(int[] arr, int index) {
    // DONE given [3, 2, 1, 5, 3, -2] return true
    // 3 + 2 + 1 = 5 + 3 - 2
    // your code here
    int count1 = 0;
    int count2 = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i < index) {
        count1 += arr[i];
      } else if (i > index) {
        count2 += arr[i];
      }
    }
    // System.out.println(count1 + "," + count2 + "," + index);
    return count1 == count2;
  }

  public static int balanceIndex(int[] arr) {
    // DONE given [3, 2, 1, 5, 2, -2] return 2
    // 3 + 2 = 5 + 2 - 2
    // your code here
    for (int i = 0; i < arr.length; i++) {
      if (balancePoint(arr, i)) {
        return (i);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr1[] = { 3, 2, 1, 5, 2, -2 };
    int arr2[] = { 3, 2, 1, 5, 2, -1 };
    printArr(arr1);
    System.out.println("Array1, " + balanceIndex(arr1));
    printArr(arr2);
    System.out.println("Array2, " + balanceIndex(arr2));
  }

  public static void printArr(int[] arr) {
    String printing = "[";
    for (int i = 0; i < arr.length; i++) {
      printing = printing + arr[i];
      if (i < arr.length - 1) {
        printing = printing + ',';
      }
    }
    printing = printing + "]";
    System.out.println(printing);
  }
}