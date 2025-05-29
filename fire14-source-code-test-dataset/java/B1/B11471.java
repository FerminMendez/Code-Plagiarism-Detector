import java.util.*;

public class C {

  Scanner in = new Scanner(System.in);
  int sols;
  ArrayList<String> possibles = new ArrayList<String>();

  public C() {
    int ncases = in.nextInt();
    for (int i = 0; i < ncases; i++) {
      sols = 0;
      int n = in.nextInt();
      int m = in.nextInt();
      findSolutions(n, m);
      System.out.println("Case #" + (i + 1) + ": " + sols);
      possibles.clear();
    }
  }

  private void findSolutions(int n, int m) {
    while (n < m) {
      findPairs(n, m);
      checkdups();
      possibles.clear();
      n++;
    }
  }

  private void findPairs(int n, int m) {
    String value = Integer.toString(n);
    for (int i = 1; i < value.length(); i++) {
      String nose = value.substring(0, i);
      String ass = value.substring(i, value.length());
      String news = ass.concat(nose);
      compare(value, news, m);
    }
  }

  private void compare(String value, String curvalue, int m) {
    if (Integer.toString(Integer.parseInt(value)).length() == Integer.toString(
        Integer.parseInt(curvalue)).length()) {
      if (Integer.parseInt(curvalue) <= m
          && Integer.parseInt(value) < Integer.parseInt(curvalue)) {
        possibles.add(curvalue);
      }
    }
  }

  private void checkdups() {
    for (int i = 0; i < possibles.size(); i++) {
      for (int x = i + 1; x < possibles.size(); x++) {
        if (possibles.get(i).equals(possibles.get(x))) {
          possibles.remove(x);
        }
      }
    }
    sols += possibles.size();
  }

  public static void main(String[] args) {
    new C();
  }

}
