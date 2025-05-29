import java.util.*;
public class Test {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();

    for(int i = 1; i<=T; i++) {
      int n = in.nextInt();
      int s = in.nextInt();
      int p = in.nextInt();
      int result = 0;
      for(int j = 0; j<n; j++){
        int x = canAddUp(in.nextInt(), p);
        if(x == 0) {
          result++;
        } else if (x==1 && s > 0) {
          result++;
          s--;
        }
      }
      System.out.println("Case #"+i+": "+result);
    }
  }

  public static int canAddUp(int sum, int limit) {
    boolean flag = false;
    for(int i = 0; i<=sum; i++) {
      for(int j = 0; i+j <= sum; j++) {
        int k = sum-(i+j);
        int a = Math.abs(i-j);
        int b = Math.abs(i-k);
        int c = Math.abs(j-k);
        if(a > 2 || b > 2 || c> 2){
          continue;
        }

        if (i>=limit || j>=limit || k>=limit) {
          if(a < 2 && b < 2 && c < 2) {
            return 0;
          }else{
            flag = true;
          }
        }
      }
    }
    return (flag) ? 1 : 2;
  }
}
