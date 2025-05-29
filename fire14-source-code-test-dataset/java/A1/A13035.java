import java.util.Scanner;
import java.io.*;
public class Q2 {
  public static void main(String[] args) throws IOException {
    Scanner w = new Scanner(new File("D:/sample.txt"));
    int cases = Integer.parseInt(w.nextLine());
    for (int i = 0; i < cases; i++) {
      int count = 0;
      int n = w.nextInt();
      int s = w.nextInt();
      int p = w.nextInt();
      for (int j = 0; j < n; j++) {
        int total = w.nextInt();
        int k = total / 3;
        int r = total % 3;
        if (total == 0) {
          if (0 >= p) count++;
        }
        else if(r==0){
          if(k>=p)count++;
          else if(s>0&&k+1>=p){
            s--;
            count++;
          }
        }
        else if(r==1){
          if(k+1>=p)count++;
        }
        else if(r==2){
          if(k+1>=p)count++;
          else if(s>0&&k+2>=p){
            s--;
            count++;
          }
        }
      }
    System.out.println("Case #" + (i + 1) + ": " + count);
    }
  }    
}