
public class d04 {
  public static void main(String[] args) {

    // System.out.println(longestPalindrome("exet"));
    // System.out.println(longestPalindrome("texer"));
    // System.out.println(longestPalindrome(""));
    // System.out.println(longestPalindrome("e"));
    // System.out.println(longestPalindrome("ee"));
    System.out.println(longestPalindrome("sir, I demand, I am a maid named Iris"));

  }

  private static String longestPalindrome(String string) {
    String longPalindrome = "";
    if (string.isEmpty()) {
      return longPalindrome;
    }
    for (int i = 0; i < string.length(); i++) {
      for (int j = string.length(); j >= i; j--) {
        if (isPalindrome(string.substring(i, j)) && (string.substring(i, j).length() >= longPalindrome.length())) {
          longPalindrome = string.substring(i, j);
        }
      }
    }
    return longPalindrome;
  }

  private static boolean isPalindrome(String substring) {
    if (substring.length() == 1) {
      return true;
    }

    for (int i = 0; i < substring.length() / 2; i++) {
      if (substring.charAt(i) != substring.charAt((substring.length() - 1) - i)) {
        return false;
      }
    }
    return true;
  }
}
