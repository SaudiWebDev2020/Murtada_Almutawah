import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzling {

  public static void main(String[] args) {
    // Task One
    // -------------
    printTask("Task 1");
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(3);
    numbers.add(5);
    numbers.add(1);
    numbers.add(2);
    numbers.add(7);
    numbers.add(9);
    numbers.add(8);
    numbers.add(13);
    numbers.add(25);
    numbers.add(32);

    ArrayList<Integer> gth10 = arrayGth(numbers, 10);
    System.out.println(numbers);
    System.out.println(gth10);

    // Task Two
    // -------------
    printTask("Task 2");
    ArrayList<String> names = new ArrayList<String>();
    names.add("Nancy");
    names.add("Jinichi");
    names.add("Fujibayashi");
    names.add("Momochi");
    names.add("Ishikawa");

    System.out.println(shuffledAndGetMoreThan(names, 5));
    ArrayList<String> shuffledArray = shuffledAndGetMoreThan(names, 5);
    System.out.println(shuffledArray);

    printTask("Task 3");
    // Task Tree
    // -------------
    ArrayList<Character> shuffledAlphabet = shuffledAlphabet();
    System.out.println(shuffledAlphabet);

    ArrayList<Character> vowel = new ArrayList<Character>();
    vowel.add('A');
    vowel.add('E');
    vowel.add('U');
    vowel.add('I');
    vowel.add('O');

    System.out.println("Last Character: " + shuffledAlphabet.get(shuffledAlphabet.size() - 1));
    System.out.println("First Character: " + shuffledAlphabet.get(0));

    if (vowel.contains(shuffledAlphabet.get(0))) {
      System.out.println("The First Character is a Vowel");
    }

    // Task 4
    printTask("Task 4");
    ArrayList<Integer> randList = getRandomNumbers(10, 55, 100);
    System.out.println(randList);

    // Task 5
    printTask("Task 5");
    ArrayList<Integer> sortedRandList = getSortedRandomNumbers(10, 55, 100);
    System.out.println(sortedRandList);
    System.out.println("Min: " + sortedRandList.get(0));
    System.out.println("Max: " + sortedRandList.get(sortedRandList.size() - 1));

    // Task 6
    printTask("Task 6");
    System.out.println(randomStringOfSize(5));

    // Task 7
    printTask("Task 7");
    ArrayList<String> ListOfRandomWord = generateStringOfEqualWords(10, 5);
    System.out.println(ListOfRandomWord);
  }

  private static ArrayList<Character> shuffledAlphabet() {
    Random r = new Random();
    int starting = 65;
    ArrayList<Character> alphabet = new ArrayList<Character>();
    for (int i = 0; i < 26; i++) {
      alphabet.add((char) (starting + i));
    }
    Collections.shuffle(alphabet);
    return alphabet;
  }

  private static void printTask(String string) {
    System.out.println("*".repeat(80));
    System.out.println(string);
  }

  private static ArrayList<Integer> getSortedRandomNumbers(int size, int min, int max) {
    ArrayList<Integer> randList = getRandomNumbers(size, min, max);
    Collections.sort(randList);
    return randList;
  }

  private static ArrayList<Integer> getRandomNumbers(int size, int min, int max) {

    Random r = new Random();
    ArrayList<Integer> randNum = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      int val = r.nextInt((max - min) + 1) + min;
      randNum.add(val);
    }
    return randNum;

  }

  private static ArrayList<String> generateStringOfEqualWords(int i, int j) {
    ArrayList<String> words = new ArrayList<String>();
    for (int k = 0; k < i; k++) {
      words.add(randomStringOfSize(5));
    }
    return words;
  }

  private static String randomStringOfSize(int size) {
    Random r = new Random();
    int starting = 65;
    char[] alphabet = new char[26];
    for (int i = 0; i < alphabet.length; i++) {
      alphabet[i] = (char) (starting + i);
    }
    String retString = "";

    for (int j = 0; j < size; j++) {
      retString += alphabet[r.nextInt(25)];
    }

    return retString;
  }

  private static ArrayList<String> shuffledAndGetMoreThan(ArrayList<String> givinArray, int i) {
    ArrayList<String> retArr = new ArrayList<String>();
    Random number = new Random();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    while (givinArray.size() != numbers.size()) {
      int index;
      do {
        index = number.nextInt(givinArray.size());
      } while (numbers.contains(index));

      numbers.add(index);
      if (givinArray.get(index).length() > i) {
        retArr.add(givinArray.get(index));
      }
    }

    return retArr;
  }

  private static ArrayList<Integer> arrayGth(ArrayList<Integer> array, int gth) {
    ArrayList<Integer> retArr = new ArrayList<Integer>();
    for (int j = 0; j < array.size(); j++) {
      if (array.get(j) > gth) {
        retArr.add(array.get(j));
      }
    }

    return retArr;
  }
}
