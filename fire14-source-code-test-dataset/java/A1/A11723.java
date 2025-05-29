import java.util.Scanner;


public class C {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int no = sc.nextInt();

    for (int s = 1; s <= no; s++) {
      int players = sc.nextInt();
      int stars = sc.nextInt();
      int best = sc.nextInt();

      int count = 0;

      int k;
      for (int i = 0; i < players; i++) {
        int j = sc.nextInt();
        k = (int) Math.floor(j / 3);
        if (k >= best) {
          count++;
        } else if (k < best) {
          int diff = j - (k * 3);
          if (diff == 1 && (diff + k) == best) {
            count++;
            continue;
          } else if (diff == 2) {
            if ((k + 1) == best) {
              count++;
              continue;
            } else if (stars > 0 && (k + diff) == best) {
              count++;
              stars--;
              continue;
            }
          } else if (diff == 0) {
            int first = k - 1;
            int second = k;
            int third = k + 1;
            if ((stars > 0) && (third == best) && first > 0) {
              stars--;
              count++;
              continue;
            }
          }
        }


      }
      System.out.println("Case #" + s + ": " + count);

    }
  }
}
