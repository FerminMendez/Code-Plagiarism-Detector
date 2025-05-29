import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yo7
 */
public class ReceycledNumper2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
    BufferedReader f = new BufferedReader(new FileReader("C-small-attempt0.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
    Scanner sc=new Scanner(f);
    int n=sc.nextInt();
    sc.nextLine();
    int num1,num2;
    for(int Linenumper=1;Linenumper<=n;Linenumper++){
        String line=sc.nextLine();
        String[] tokens=line.split(" ");
        num1=Integer.parseInt(tokens[0]);
        num2=Integer.parseInt(tokens[1]);
        if(num1<10)
        {
            String ss="Case #"+Linenumper+": 0";
            out.println(ss);
            continue;
        }
        int count=0;
        for(int k=num1;k<num2;k++)
          for(int i=k;i<num2;i++)
          {
              String str1=k+"";
              String str2=i+1+"";
              int len=str1.length();
              for(int j=1;j<len;j++)
              {
                  String end=str1.substring(len-j,len);
                  String front=str1.substring(0,len-j);
                  String newstring=end+front;
                  if(newstring.equals(str2))
                  {
                      count++;
                      j=str1.length();
                  }
              }
          }
          String ss="Case #"+Linenumper+": "+count;
          out.println(ss);
    }
      
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
    }
}
