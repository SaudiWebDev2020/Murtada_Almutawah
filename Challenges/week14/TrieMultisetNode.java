import java.util.HashMap;

public class TrieMultisetNode implements Comparable<TrieMultisetNode> {
  public String value;
  public HashMap<Character, TrieMultisetNode> children;
  public Integer count;

  public TrieMultisetNode(String value) {
    this.value = value;
    children = new HashMap<Character, TrieMultisetNode>();
    count = 0;
  }

  @Override
  public int compareTo(TrieMultisetNode o) {
    if (this.count < o.count) {
      return 1;
    } else if (this.count > o.count) {
      return -1;
    } else {
      return 0;
    }
  }
}
