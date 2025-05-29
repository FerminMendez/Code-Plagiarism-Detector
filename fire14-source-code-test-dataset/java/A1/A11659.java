
/**
 * Write a description of class dancing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;

public class dancing
{
    public static void main(String args[]) throws IOException
    {
        int tcase,ng,sur,max;
        int i, j, m, x, y=0,s,flag=0,sum,best,counter;
        int g[]=new int[10];
        char ch,newline=13;
        String result;
        FileInputStream fis;
        
        fis = new FileInputStream("B-small-attempt0.in");
        
    
    DataInputStream dis = new DataInputStream(fis);
  BufferedReader br = new BufferedReader(new InputStreamReader(dis));
  

  File fout = new File("A-large.op");
  FileOutputStream fo = new FileOutputStream(fout);

  byte buf[];

  
  String strline;

  strline = br.readLine();
  
  tcase = Integer.parseInt(strline);
 // System.out.println(tcase);
  for(m=1;m<=tcase;m++)
    {   
//System.out.println("testcase"+m);
        s=0;
        ch=(char)br.read();
 //       cout<<ch<<endl;
        do
        {
        s= 10*s + (ch-48);
        ch=(char)br.read();
 //       cout<<s<<endl;
        }
        while(ch!='\n'&& ch!=' ');
        ng=s;
        
        s=0;
        ch=(char)br.read();
 //       cout<<ch<<endl;
        do
        {
        s= 10*s + (ch-48);
        ch=(char)br.read();
 //       cout<<s<<endl;
        }
        while(ch!='\n'&& ch!=' ');
        sur=s;
        
        s=0;
        ch=(char)br.read();
 //       cout<<ch<<endl;
        do
        {
        s= 10*s + (ch-48);
        ch=(char)br.read();
 //       cout<<s<<endl;
        }
        while(ch!='\n'&& ch!=' ');
        max=s;
        
       
  //System.out.println(ng+" "+sur+" "+max);      
    for(i=0;i<ng;i++)
     {
        s=0;
        ch=(char)br.read();
 //       cout<<ch<<endl;
        do
        {
        s= 10*s + (ch-48);
        ch=(char)br.read();
  //      System.out.println(ch-48);
 //       cout<<s<<endl;
        }
        while(ch!='\n'&& ch!=' ');
        g[i]=s;
        
     }
    // System.out.println("scores are read!!!"+g[ng-1]);
    counter=0;
    for(i=0;i<ng;i++)
        {
     //       System.out.println(g[i]);     
          if(g[i] < (max*3-4))
            continue;
     
          if(g[i]%3==0)
            best = g[i]/3;
          else
            best= (g[i]/3) +1;
            
          if(best>=max)
            {
 //             System.out.println("best"+best);
                counter++;  
            }
           else{
               if((max-(g[i]-max)/2) == 2 && sur > 0)
                    {//System.out.println("surprise");
                        counter++;
                        sur--;
                    }
               }
        }

    
        result= "Case #"+m+": "+counter+'\n';
  // System.out.println("Case #"+m+": "+counter);
        buf=result.getBytes();
       try{
           fo.write(buf);
        }
        catch(Exception e){System.out.println("hey");}
        
    
   }
    try{
        fo.close();
        fis.close();
    }
    catch(Exception e){}
}
}
