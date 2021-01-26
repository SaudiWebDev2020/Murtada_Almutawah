
import java.util.HashMap;

public class TrieNode {
  public String value;
  public Boolean isWord;
  public HashMap<Character, TrieNode> children;

  public TrieNode(String value) {
    this.value = value;
    this.isWord = false;
    children = new HashMap<Character, TrieNode>();
  }
}
