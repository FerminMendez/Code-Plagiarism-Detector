import java.util.Scanner;
import java.io.*;

public class S1 {
  public static void main(String []args) throws IOException {
    int numT=0;
    Scanner kb=new Scanner(new File("D:/q2.txt"));
    numT = kb.nextInt();
    int a[] = new int[numT];
    int b[]=new int[numT];
    for (int i = 0; i < numT; i++) {
      a[i] = kb.nextInt();
      b[i]=kb.nextInt();
    }
    for (int i = 0; i < numT; i++) {
      
      System.out.println("Case #"+(i+1)+":"+" "+cal(a[i],b[i]));
    }
    
  }
  
  public static int cal(int A,int B){
    int score=0;
    for(int n=A;n<=B;n++){
      String num=n+"";
      for(int j=1;j<num.length();j++){
        String s=num.substring(0,j);
        String t = num.substring(j, num.length());
        String sum=t+s;
        int m=Integer.parseInt(sum); 
        if (m <= B && m >= A && m != n && m > n) { score++; }
      }
    }
    return score;
    
  }
}

