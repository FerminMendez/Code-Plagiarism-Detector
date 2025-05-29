
package codejam2;

import java.io.*;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

class FileReader
{
    int T;
    FileInputStream fstream;
    DataInputStream in;
    BufferedReader br;
    FileReader()
    {
        try
        {
            fstream = new FileInputStream("B-small-attempt0.in");
            in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));
            initializeT();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private void initializeT()
    {
        String strLine;
        try 
        {
            strLine = br.readLine();
            T=Integer.parseInt(strLine);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public int getT()
    {
        return T;
    }
    public String getNextLine()
    {
        String temp=null;
        try 
        {
            temp=br.readLine();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
}



public class CodeJam2 
{

    public int findGooglers(int N,int S,int p,int[] scores)
    {
        int count=0;
        for(int i=0;i<N;i++)
        {
            int temp=3*p-scores[i];
            if(temp<=2)
                ++count;
            else
            {
                if(S>0)
                {
                    if(temp<=4)
                    {
                        if(scores[i]!=0)
                        {
                            ++count;
                            --S;
                        }
                        
                    }
                }
                
            }       
        }
        return count;
    }
    
    public static void main(String[] args) 
    {
        FileReader fr=new FileReader();
        CodeJam2 cj=new CodeJam2();
        FileWriter fstream;
        try 
        {
            fstream = new FileWriter("output.out");
            BufferedWriter out = new BufferedWriter(fstream);
            int T=fr.getT();
            for(int i=0;i<T;i++)
            {
                String line=fr.getNextLine();
                String buff[]=line.split(" ");
                int N=Integer.parseInt(buff[0]);
                int S=Integer.parseInt(buff[1]);
                int p=Integer.parseInt(buff[2]);
                int arr[]=new int[N];
                for(int j=0;j<N;j++)
                {
                    arr[j]=Integer.parseInt(buff[j+3]);
                }
                out.write("Case #"+(i+1)+": "+cj.findGooglers(N,S,p,arr));
                out.write("\n");
                out.flush();
            }
        }
        catch(Exception ex)
        {

        }
    }
}
    
  