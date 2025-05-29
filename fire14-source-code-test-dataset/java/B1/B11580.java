import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
public class Q3 {
    public static void main(String[] args) throws IOException {
        Scanner reader=new Scanner(new File("D:\\C-small-attempt0 (1).in"));
        int noOfCases=reader.nextInt();
        String finalAnswer="";
        PrintWriter writer=new PrintWriter("D:\\out0.in");
        for(int loop=0;loop<noOfCases;loop++)
        {
            LinkedList<String> set=new LinkedList<String>();
            int counter=0;
            int firstNum=reader.nextInt();
            int secondNum=reader.nextInt();
            for(int currentN=firstNum;currentN<secondNum;currentN++)
            {
                String n=currentN+"";
                for(int i=1;i<=n.length()-1;i++)
                {
                    String nSubString=n.substring(n.length()-i,n.length())+n.substring(0,n.length()-i);
                    if(!nSubString.startsWith("0"))
                    {
                    if(!n.equals(nSubString))
                    {
                    int nSubInt=Integer.parseInt(nSubString);
                    if(nSubInt<=secondNum && nSubInt>(Integer.parseInt(n)))
                    {
                        if(!set.contains(n+","+nSubString))
                        {
                            set.add(n+","+nSubString);
                            counter++;
                        }
                    }
                    }
                    }
                }
            }
         finalAnswer+="Case #"+(loop+1)+": "+counter+"\n";
        }
           writer.write(finalAnswer);
            writer.flush();
            writer.close();
    }
}
