
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class TrieMultiset {

  private TrieMultisetNode root;

  public TrieMultiset() {
    root = new TrieMultisetNode("");
  }

  public void insert(String word) {

    String temp = "";
    TrieMultisetNode runner = root;

    for (int i = 0; i < word.length(); i++) {
      temp += word.charAt(i);
      if (!runner.children.containsKey(word.charAt(i))) {
        runner.children.put(word.charAt(i), new TrieMultisetNode(temp));
      }
      runner = runner.children.get(word.charAt(i));
    }
    runner.count++;

  }

  public void printWords() {
    printWords(root);
  }

  private void printWords(TrieMultisetNode current) {
    if (current.count > 0) {
      System.out.println(current.value + " " + current.count);
    }
    for (Map.Entry kvPair : current.children.entrySet()) {
      printWords((TrieMultisetNode) kvPair.getValue());
    }
  }

  public ArrayList<String> mostLikelyWords(String start) {
    ArrayList<String> results = new ArrayList<String>();
    // DONE - your code here
    // Get into last letter
    TrieMultisetNode runner = root;
    for (int i = 0; i < start.length(); i++) {
      if (!runner.children.containsKey(start.charAt(i))) {
        return results;
      }
      runner = runner.children.get(start.charAt(i));
    }
    // get all possible matches
    ArrayList<TrieMultisetNode> prediction = new ArrayList<TrieMultisetNode>();
    prediction = getWords(runner, prediction);
    // Sort
    Collections.sort(prediction);
    for (TrieMultisetNode item : prediction) {
      System.out.println(item.value + " " + item.count);
    }
    // convert it to arrayList
    for (int i = 0; i < prediction.size(); i++) {
      results.add(prediction.get(i).value);
    }
    return results;
  }

  private ArrayList<TrieMultisetNode> getWords(TrieMultisetNode current, ArrayList<TrieMultisetNode> list) {
    if (current.count > 0) {
      list.add(current);
    }
    for (Map.Entry kvPair : current.children.entrySet()) {
      list = getWords((TrieMultisetNode) kvPair.getValue(), list);
    }
    return list;
  }

}
