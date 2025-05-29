import java.util.*;
import java.io.*;
public class Googlers {
   public static void main(String[] args)throws IOException {
    Scanner sc = new Scanner(new File("input2.txt"));
    int loop = sc.nextInt();
    int num;
    int s = 0;
    int p;
    int n;
    int count = 0;
    int check;
    
    ArrayList<Integer> array = new ArrayList<Integer>();
    for (int i = 0 ; i < loop ; i++)  {
      num = sc.nextInt();
      s = sc.nextInt();
      p = sc.nextInt();
      for (int j=0 ; j<num ;j++){
        array.add(sc.nextInt());
      }
      n = p*3-2;
      for (Integer in : array){
        if (in >= n)
          count++;
        else {
          if(s>0){
            check = (p+(p-2)*2);
            if(in >= check && check >0){
              count++;
              s--;
            }
          }
        }   
      }
      System.out.println("Case #"+(i+1)+": "+count);
      count = 0;
      array.clear();
    }
    
   }
}