import java.io.*;
import javax.swing.*;
import javax.swing.JOptionPane.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.*;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.html.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class Dancings
{
   public static void main(String args[])
	{
	  
	  int jumlahN[]=new int[101];
	 
	 
	  
	  int hasil[]=new int[101];
	  
	  
	  int i=0;
      int j=0;
      int k=0;
      int l=0;
	  int il=0;
	  int cok3=0;
	  
      try{
		// Open the file that is the first 
		// command line parameter
		FileInputStream fstream = new FileInputStream("b.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		//Read File Line By Line
		j=0;
		while ((strLine = br.readLine()) != null) 	{
			// Print the content on the console
		    if(j==0)
            {
             i=Integer.parseInt(strLine);	
             if(i>100)
              {
	           i=100;
              }
             else if(i<1)
              {
	           i=1;
              } 			
			 System.out.println (i);
		    }
			else
			{
			 int jum=0;
			 int panjangtext=strLine.length();
			 int posisi=0;
			 //String isi=strLine.trim();
			 char arr[]=strLine.toCharArray(); 

			 Character n2=arr[0];
             String s1=n2.toString();
             int n= Integer.parseInt(s1);			 
			 
			  String tmp="";
			  for(l=2; l<panjangtext; l++)
			  {
				 if(arr[l]==' ')
				 {
			        break;
				 }
				 else
				 {
				  tmp=tmp+arr[l];
				 }
			  } 
			  
			  int s=Integer.parseInt(tmp);
			  
			  String tmp2="";
			  for(k=l+1; k<panjangtext; k++)
			  {
				 if(arr[k]==' ')
				 {
			        break;
				 }
				 else
				 {
				  tmp2=tmp2+arr[k];
				 }
			  } 
			  
			  int p=Integer.parseInt(tmp2);	
			  
			  System.out.println("nilai n"+n);
			  System.out.println(strLine);
			  
			  System.out.println("nilai s:"+s);
			  System.out.println("nilai p:"+p);
			  
			  int m=1;
			  tmp="";
			  while(m<=n)
			  {
			     
			    for(k=k+1; k<panjangtext; k++)
			    {
				 if(arr[k]==' ')
				 {
				   
			        break;
				 }
				 else
				 {
				  
				  tmp=tmp+arr[k];
				 }
			    }
				 
				 tmp=tmp.trim();
				 int tmp4=Integer.parseInt(tmp);	
			     jumlahN[m]=tmp4;
				 tmp=" ";
			    
			   
			   m++;
			  }
			  
			  m=1;
			  
			  int p2=p*2;
			  while(m<=n)
			  {
			    
			   System.out.println("nilai m :"+m+" :"+jumlahN[m]);
			   int cok2=jumlahN[m];
			   int jos=cok2-p2;
			   int param=p-2;
			   if(jos>=param)
			   {
			    
			     System.out.println("Masuk 1");
			    jum++;
			   }
			   else if(cok2>0 && s>0)
			   {
			    cok3=cok2-p;
				int p3=cok3/2;
				
				if(p3>=param)
				{
				jum++;
				s--;
				}
			     System.out.println("Masuk 2");
			    
			   }
			  
			  
			   
			   m++;
			  }
			  
			  hasil[j]=jum; 
            }
		//Close the input stream
		    j++;
		   }
	       in.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		
		
      
	  try
	  {
	   File makefile= new File("resultdancing.txt");
       FileWriter fwrite= new FileWriter(makefile);
       PrintWriter pw=new PrintWriter(fwrite);	 
	   for(il=1; il<=i; il++)
         {
		  pw.println("Case #"+(il)+": "+hasil[il]+"\n");
		  System.out.println("case #"+(il)+": "+hasil[il]+"\n");
		 }
	   fwrite.flush();
	   fwrite.close();
	  }
	  catch(IOException e)
	  {
	   e.printStackTrace();
	  }
	  
	  
	}
	

	

  

	
	
	
}

