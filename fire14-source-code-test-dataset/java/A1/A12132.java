import java.io.*;
import java.util.*;
/**
 * Auto Generated Java Class.
 */
public class Problem_b {
  
  
  public static void main(String[] args) { 
    String [] nums=getWords("B-small-attempt0.in");
    int t=Integer.parseInt(nums[0]);
    for(int i=1;i<nums.length;i++){
      String [] tempstr=nums[i].split(" ");
      int [] temp= new int[tempstr.length];
      for(int x=0;x<tempstr.length;x++){
        temp[x]=Integer.parseInt(tempstr[x]);
      }
      System.out.println("Case #" +i+": "+ check(temp));
    }
  }
  
  public static int check(int [] a){
    int gnum=a[0];
    int surp=a[1];
    int p=a[2];
    int [] scores=new int [gnum];
    for(int i=3;i<a.length;i++){
      scores[i-3]=a[i];
    }
//    for(int x:scores)
//      System.out.print(x+" ");
    //System.out.println(gnum+" "+surp+" "+p);
    int max=0;
    int tempsurps=0;
    for(int i=0;i<scores.length;i++){
      if(scores[i]/3.0 > p-1){
        max++;
      }
      else if(tempsurps<surp && p-scores[i]/3.0 <= 1.5 && scores[i]!=0){
        max++;
        tempsurps++;
      }
    }    
    return max;
  }
  
  public static String [] getWords( String filename ) {
    String [] list = null;
    try {
      Scanner read = new Scanner( new File( filename ) );
      int count = 0;
      while ( read.hasNext() ){
        String temp = read.nextLine();
        count++;
      }
      list = new String[ count ];
      read = new Scanner( new File( filename ) );
      count = 0;
      while ( read.hasNext() ){
        list[count] = read.nextLine();
        count++;
      }
    } catch ( IOException e1 ) {
      System.out.println( "problem reading file" );
    }
    return list;
  }
  /* ADD YOUR CODE HERE */
  
}
