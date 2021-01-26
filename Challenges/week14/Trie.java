import java.util.Set;

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode("");
  }

  public void insert(String word) {

    TrieNode runner = root;
    String temp = "";
    // Loop through the word, 1 char at a time
    for (int i = 0; i < word.length(); i++) {
      temp += word.charAt(i);
      if (!runner.children.containsKey(word.charAt(i))) {
        runner.children.put(word.charAt(i), new TrieNode(temp));
      }
      runner = runner.children.get(word.charAt(i));
    }
    runner.isWord = true;
    // check if letter exists as a child of current node
    // if so, move the runner
    // if not, create child, move runner
  }

  public void printAllWords() {
    System.out.println("List of words: ");
    printAllWords(root);
  }

  private void printAllWords(TrieNode node) {
    if (node.isWord) {
      System.out.println(node.value);
    }
    Set<Character> charList = node.children.keySet();
    for (Character character : charList) {
      printAllWords(node.children.get(character));
    }
  }
}