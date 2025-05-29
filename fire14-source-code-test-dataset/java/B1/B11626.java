import java.util.Scanner;


public class Test {
  public static void main(String []args){
    int numT=0;
    Scanner kb=new Scanner(System.in);
    numT = kb.nextInt();
    int a[] = new int[numT];
    int b[]=new int[numT];
    for (int i = 0; i < numT; i++) {
      a[i] = kb.nextInt();
      b[i]=kb.nextInt();
    }
    for(int i=0;i<numT;i++){
      System.out.println("Case #"+(i+1)+":"+" "+cal(a[i],b[i]));
    }
    
  }
  
  public static int cal(int A,int B){
    int score=0;
    for(int i=A;i<=B;i++){
      String num=i+"";
      for(int j=1;j<num.length();j++){
        String s=num.substring(0,j);
        String t = num.substring(j, num.length());
        String sum=t+s;
        int sb=Integer.parseInt(sum); 
        if (sb <= B&&sb>=A&&sb!=i&&sb>i){ score++;        }
      }
    }
    return score;
    
  }
}
