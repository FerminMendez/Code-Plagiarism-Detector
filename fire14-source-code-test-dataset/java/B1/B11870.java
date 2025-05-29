

import java.io.*;
import java.util.*;


class ProblemC
{



  public static void main(String[] args) throws IOException
  {
	FileReader fr = new FileReader(args[0]);
	BufferedReader br = new BufferedReader(fr);
	String[] splittArray;
	int[] points;
	int A,B,res;
	int T = Integer.parseInt(br.readLine());
	//System.out.println(T);

	String dummy;
	String result="";
	for(int i=1;i<=T;i++) {
		dummy=br.readLine();
		splittArray=dummy.split(" ");
		A=Integer.parseInt(splittArray[0]);
		B=Integer.parseInt(splittArray[1]);
		res=0;
		for(int j=A;j<B;j++) {
			
			res+=permutes(j,new Integer(j).toString(),B);
		}
		
		result+="Case #"+i+": "+res;
		if(i<T) result+="\r\n";
	}
	br.close();





	FileWriter writer;
  	File file;
  
	     file = new File(args[1]);
     try {
      
       writer = new FileWriter(file ,true);
       
       // Text wird in den Stream geschrieben
      
       writer.write(result);
       
       
       // Schreibt den Stream in die Datei
       // Sollte immer am Ende ausgeführt werden, sodass der Stream 
       // leer ist und alles in der Datei steht.
       writer.flush();
       
       // Schließt den Stream
       writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
	
  }

public static int permutes(int b,String a,int c) {
	LinkedList<Integer> result=new LinkedList<Integer>();
	String dummy;
	int dummy2;

	for(int i=1;i<=a.length()-1;i++) {
		dummy=a.substring(i,a.length())+a.substring(0,i);
		dummy2=Integer.parseInt(dummy);
		if(dummy2>b && dummy2<=c && !result.contains(dummy2)) result.add(dummy2);
	}

	return result.size();
}
	

}

