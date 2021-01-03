public class StringManipulator {

  public String trimAndConcat(String string, String string2) {
    return string.trim().concat(string2.trim());
  }

  public Integer getIndexOrNull(String string, String subString) {
    int index = string.indexOf(subString);
    if (index < 0) {
      return null;
    } else {
      return index;
    }
  }

  public Integer getIndexOrNull(String string, char letter) {
    int index = string.indexOf(letter);
    if (index < 0) {
      return null;
    } else {
      return index;
    }
  }

  public String concatSubstring(String string, int i, int j, String string2) {
    return string.substring(i, j).concat(string2);
  }

}
