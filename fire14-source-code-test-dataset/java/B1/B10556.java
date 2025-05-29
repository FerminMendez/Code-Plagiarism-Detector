/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googl2;

/**
 *
 * @author Mimo
 */
import java.io.*;
import java.util.Scanner;
public class Googl2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int t;
        int result;
        String input1;
        String input2;
        String input4;
        int a,b;
       File input=new File("C:\\Users\\Mimo\\Desktop\\C-small-attempt0.in");
            FileWriter output=new FileWriter("output.txt");
        BufferedWriter out = new BufferedWriter(output);
        Scanner getter =  new Scanner(input);
            t=getter.nextInt();
            getter.nextLine();
            for(int i=1;i<=t;i++)
            {
                result=0;
               input1=getter.next();
               input2=getter.next();
               a=Integer.valueOf(input1);
               b=Integer.valueOf(input2);
               for(int j=a;j<b;j++)
               {
                   input4=String.valueOf(j);
                  for(int jj=0;jj<input4.length()-1;jj++)
                  {
                     input4=input4.substring(input4.length()-jj-1)+input4.substring(0, input4.length()-jj-1);
                      if(Integer.valueOf(input4)<=b  && Integer.valueOf(input4)>j && input4.charAt(0)!='0')
                         result++;
                      System.out.println(input4+" "+" "+b+" "+result+" "+j);
                      input4=String.valueOf(j);
                  }
               }
               
                out.write("Case #"+i+": "+result);
       out.newLine();
            }
            out.close();
        
    }
}
