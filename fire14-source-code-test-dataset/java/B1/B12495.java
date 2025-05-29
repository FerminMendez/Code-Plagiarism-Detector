import java.util.Scanner;
public class Recycled {
  
  public static void main(String[] args) { 
    
    Scanner scan = new Scanner(System.in);
    int test = scan.nextInt();
    for (int c = 1; c <= test; c++){
      int count = 0;
      int min = scan.nextInt();
      int max = scan.nextInt();
      if (min < 10)
        min = 10;
      
      for (int x = min; x <= max; x++){
        String value = (Integer.valueOf(x)).toString();
        for (int a = 0; a < value.length()-1; a++){
          String temp = value.substring(value.length()-a-1);
          temp += value.substring(0,value.length()-a-1);
          int r = Integer.parseInt(temp);
          if ( r > x && r <= max ){
            count++;
            //System.out.println(x + " " + r );
          }
        }
      }
      
      System.out.println( "Case #" + c + ": " + count);
      
    }
    
  }
}

