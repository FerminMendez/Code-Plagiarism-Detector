
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sony
 */

public class DancingGooglers {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
     BufferedReader br=new BufferedReader(new FileReader(args[0]));
  
  int Testcases=Integer.parseInt(br.readLine());
    for(int i=0;i<Testcases;i++)
    {
    String[] line=br.readLine().split(" ");
    int N=Integer.parseInt(line[0]);
    int S=Integer.parseInt(line[1]);
    int p=Integer.parseInt(line[2]);
    int count=0;
    //System.out.print("N="+N+"S="+S+"p="+p+"\n");
    int indicator=0;
    for(int j=0;j<N;j++)
    {
    int reminder=Integer.parseInt(line[3+j])%3;
    int quotient=Integer.parseInt(line[3+j])/3;
    int sum=Integer.parseInt(line[3+j]);
    
    if(reminder==0)
    indicator++;
    
    if((quotient>=p)||(reminder==1&&quotient+1==p)||(reminder==2&&quotient+1==p))
        count++;
    else if(S>0&&sum>=p){
    
    if((reminder==0&&quotient+1==p)||(reminder==2&&quotient+2==p))    
    {
        S--;
        count++;
    }
        
    }
    
    
    }
    
    System.out.print("Case #"+(i+1)+": "+count+"\n");
    
    
    
    }
    
    }
    
}

