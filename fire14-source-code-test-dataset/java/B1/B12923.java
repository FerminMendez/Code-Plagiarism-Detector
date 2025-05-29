/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejampractice;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lahiru
 */
public class Main2 {
    
   
    static int noOfCases=0;
    static String ans="";
    static int currentCase=0;
    //static int currentValue=0;
    static int start=0;
    static int last=0;
    static Set set;
    static int noOfPerm=0;
   
    public static void main(String[] args) {
        
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream("input.in");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            if ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            noOfCases=Integer.parseInt(strLine);  
            //System.out.println (strLine);
            
            }
            for(currentCase=1;currentCase<noOfCases+1;currentCase++)
            {
                if((strLine=br.readLine())!=null)
                {
                    ans=ans+"Case #"+currentCase+": ";
                    start=Integer.parseInt(strLine.split(" ")[0]);
                    last=Integer.parseInt(strLine.split(" ")[1]);
                    noOfPerm=0;
                    //System.out.println(start);
                    for(int i=start;i<=last;i++)
                    {
                        set=new HashSet();
                        
                        String num=Integer.toString(i);
                        perm(num);
                        Object[] arr=set.toArray();
                        //arr=(String[]) set.toArray();
                        //System.out.println("new one");
                        if(arr.length>1){
                            for(int j=0;j<arr.length;j++)
                            {
                                int n=Integer.parseInt(arr[j].toString());
                                if((n<=last) && (n>i))
                                {
                                    //System.out.println(n+" for "+num);
                                    noOfPerm++;
                                }
                            }
                            
                        }
                        
                    }
                    ans=ans+noOfPerm;
                    if(currentCase<(noOfCases+1))
                        ans=ans+"\n";
                    //System.out.println(noOfPerm);
                    
                }
            }
            fstream.close();
            //System.out.println(ans);
            writeToFile(ans);
            
        } catch (IOException ex) {
            ;
       
            
        }
        
    }
    
    
    
    public static void writeToFile(String line)
    {
        try{
        // Create file 
        FileWriter fstream = new FileWriter("out.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(line);
        //Close the output stream
        out.close();
        }catch (Exception e){//Catch exception if any
        System.err.println("Error: " + e.getMessage());
        }
    }
    
    
    public  static void perm(String s) { 
        
            int len=s.length();
            String pattern="";
            for(int n=(len-1),k=len;n>=0;n--)
            {
                pattern=s.substring(n, k)+s.substring(0, n);
                set.add(pattern);
                //System.out.println(pattern);
            }
            
        }

    

    
}
