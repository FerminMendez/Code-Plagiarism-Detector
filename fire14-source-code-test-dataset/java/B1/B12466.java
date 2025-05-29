import java.util.*;
import java.io.*;

public class B {
  private static boolean isRecyclePair(int n, int m){
    String n_str=""+n;
    String m_str=""+m;
    for(int i=0; i<n_str.length(); i++){
      String candidate=n_str.substring(i)+n_str.substring(0, i);
      if(m_str.equals(candidate)) return true;
    }
    return false;
  }
  private static void gcjMethod(String[] input){
    int a=Integer.parseInt(input[0]);
    int b=Integer.parseInt(input[1]);
    int res=0;
    // System.out.format("A=%d, B=%d\n", a, b);
    for(int i=a; i<=b; i++)
      for(int j=i+1; j<=b; j++)
        if(isRecyclePair(i, j)) res++;
    System.out.println(res);
    return;
  }

  public static final void main(final String[] args) {
    String line;
    int numCase;
    String[] input;

    BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
    try{
      numCase=Integer.parseInt(d.readLine());
      for(int i=0; i<numCase; i++){
        line=d.readLine();
        input=line.split(" ");
        System.out.print(String.format("Case #%d: ", i+1));
        gcjMethod(input);
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}