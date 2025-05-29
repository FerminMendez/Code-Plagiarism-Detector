import java.util.Scanner;
public class Googlers {
  
  public static void main(String[] args) { 
    
    Scanner scan = new Scanner(System.in);
    int test = scan.nextInt();
    for (int a = 1; a <= test; a++){
      int x = scan.nextInt();
      int surprising = scan.nextInt();
      int cutoff = scan.nextInt();
      //int c0 = 3*cutoff;
      int c1 = cutoff + (2*(cutoff-1));
      int c2 = cutoff + (2*(cutoff-2));
      int count = 0; 
      int[] scores = new int[x];
      for (int i = 0; i < x; i++)
        scores[i] = scan.nextInt();
      for (int b = 0; b < x; b++){
        int points = scores[b]; 
        if ( points >= c1 )
          count++;
        else if ( surprising > 0 ){
          if (cutoff > 1){
            if ( points >= c2 ){
              count++;
              surprising--;
            }
          }
        }
      }
      System.out.println( "Case #" + a + ": " + count);
    }
  }
}


