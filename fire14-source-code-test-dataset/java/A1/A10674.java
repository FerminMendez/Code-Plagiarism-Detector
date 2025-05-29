import java.util.*;
import java.io.*;
class Dancing{
  public static void main(String args[])
  {     
    File file = new File("B-small-attempt0.in");
    try{
      FileWriter fstream = new FileWriter("result.txt");
      BufferedWriter out = new BufferedWriter(fstream);
      Scanner sc = new Scanner(file);
      int tcs = sc.nextInt(); //test cases
  
      for(int tc = 1; tc <=tcs; tc++)
      {
        int words = sc.nextInt();
        int surprising = sc.nextInt();
        int p = sc.nextInt();
        int converted = 0;
        int normal = p + (p-1) + (p - 1);
        int snormal = normal - 2;
        while(words-- > 0)
        {
          int candidate = sc.nextInt();
          if(candidate < p) continue;
          if(candidate >= normal)
          {
            converted += 1;
          }
          else if(surprising > 0 && candidate >= snormal)
          {
            surprising--;
            converted++;
          }
        }
        out.write("Case #" + tc + ": "+converted+"\r\n");
      }
      out.close();
    } catch (Exception e) {e.printStackTrace();}
  }
}