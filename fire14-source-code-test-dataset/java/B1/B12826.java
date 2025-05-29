import java.io.*;
import java.util.*;
public class Cre
{
 public static void main(String args[])throws FileNotFoundException,IOException
  {
      RandomAccessFile in=new RandomAccessFile("C-small-attempt0.in","r");
      FileOutputStream out= new  FileOutputStream("out.txt");
     int o=Integer.parseInt(in.readLine());
      int j=0;
     String str[]=new String[o+1];
     int res[]=new int[o];
     while((str[j]=in.readLine())!=null)
     {
       String []nos=str[j].split(" ");
       int a=Integer.parseInt(nos[0]);
       int b=Integer.parseInt(nos[1]);
       int []t=new int[b-a+1];
	    int m;
       for(int i=a,k=0;i<=b;i++,k++)t[k]=i;
       for(int i=0;i<t.length;i++)
       {
	     
		  
           String st=t[i]+"";
		   char ch[]=st.toCharArray();
		   ArrayList got=new ArrayList();
		   int g;
           for(int c=0;c<ch.length;c++)
		    { 
			   m=shift(ch);
			    int flag=1;
			   Iterator it=got.iterator();
			   while(it.hasNext())
			   {  
			    Integer inf=(Integer)it.next();
			     g=inf.intValue();
				 if(g==m) flag=0;
			   }
			   
			     if(m!=t[i]&&flag==1)
          {
		  got.add(m);
           for(int l=i+1;l<t.length;l++)
           {
              if(m==t[l])
              {
			     System.out.println(t[i]);
                    res[j]++;
                    
              }
           }
		   
          }
		  
            }
		  
       
		 
        }
      j++;
     }
     for(int i=0;i<o;i++)
    {
     out.write(("Case #"+(i+1)+": "+res[i]+"\n").getBytes());
    }
   }
   
   static int shift(char[] ch)
   {
     char temp=ch[ch.length-1];
     for(int i=ch.length-1;i>0;i--)
	  {
	    ch[i]=ch[i-1];
	  }
	  ch[0]=temp;
	  String st=new String(ch);
	  return Integer.parseInt(st);
   }

}