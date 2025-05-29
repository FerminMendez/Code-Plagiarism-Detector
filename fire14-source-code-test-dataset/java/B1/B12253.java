import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: singh
 * Date: 14/4/12
 * Time: 4:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecycleNumbers {
    public static void main(String[] args) throws IOException {
//        Scanner sc=new Scanner(System.in);
        Scanner sc=new Scanner(new File("C:\\Users\\singh\\Documents\\codejam\\input.in"));
        int testCases=sc.nextInt();
        String outPut="";
        PrintWriter writer=new PrintWriter("C:\\Users\\singh\\Documents\\codejam\\out0.in");
//        BufferedWriter bf=new BufferedWriter(new FileWriter("C:\\Users\\singh\\Documents\\codejam\\out0.txt"));
        for(int iterator=0;iterator<testCases;iterator++)
        {
            HashSet<String> set=new HashSet<String>();
            int counter=0;
            int A=sc.nextInt();
            int B=sc.nextInt();
//            int BFirst=Integer.parseInt((B+"").charAt(0)+"");
            for(int currentN=A;currentN<B;currentN++)
            {
                String nString=currentN+"";
                if(iterator==3)
                {
                    System.out.println();
                }
//                int nFirst=Integer.parseInt(nString.charAt(0)+"");
//                if(nFirst>BFirst)
//                {
//                    break;
//                }
//                if(!nString.endsWith("0"))
//                {
                for(int i=1;i<=nString.length()-1;i++)
                {
                    String nSubString=nString.substring(nString.length()-i,nString.length())+nString.substring(0,nString.length()-i);
                    if(!nSubString.startsWith("0"))
                    {
                    if(!nString.equals(nSubString))
                    {
                    int nSubInt=Integer.parseInt(nSubString);
                    if(nSubInt<=B && nSubInt>(Integer.parseInt(nString)))
                    {
                        if(!set.contains(nString+","+nSubString))
                        {
                            set.add(nString+","+nSubString);
                            counter++;
                        }
                    }
                    }
                    }
                }
//                }
            }
//            }
         outPut+="Case #"+(iterator+1)+": "+counter+"\n";
        }
           writer.write(outPut);
            writer.flush();
            writer.close();
    }
}
