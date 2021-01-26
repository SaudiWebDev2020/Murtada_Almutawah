public class d03 {

  public static void main(String[] args) {
    TrieMultiset tM = new TrieMultiset();

    tM.insert("cat");
    tM.insert("cat");
    tM.insert("car");
    tM.insert("car");
    tM.insert("car");
    tM.insert("car");
    tM.insert("car");
    tM.insert("car");
    tM.insert("catsup");
    tM.insert("catsup");
    tM.insert("category");
    tM.insert("category");
    tM.insert("category");
    tM.insert("category");
    tM.insert("catsup");
    tM.insert("category");
    tM.insert("apple");
    tM.insert("apple");
    tM.insert("apple");
    tM.insert("apple");

    // tM.printWords();

    System.out.println(tM.mostLikelyWords(""));
  }
}