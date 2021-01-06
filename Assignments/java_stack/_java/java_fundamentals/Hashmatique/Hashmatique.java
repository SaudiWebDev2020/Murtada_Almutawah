import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
  public static void main(String[] args) {
    HashMap<String, String> trackList = new HashMap<String, String>();

    trackList.put("Song 1", "lyrics 1");
    trackList.put("Song 2", "lyrics 2");
    trackList.put("Song 3", "lyrics 3");
    trackList.put("Song 4", "lyrics 4");

    System.out.println(trackList.get("Song 1"));

    Set<String> keys = trackList.keySet();
    for (String key : keys) {
      System.out.println(key + ": " + trackList.get(key));
    }
  }
}
