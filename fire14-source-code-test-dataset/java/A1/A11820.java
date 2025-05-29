

import java.io.*;

class ProblemB
{



  public static void main(String[] args) throws IOException
  {
	FileReader fr = new FileReader(args[0]);
	BufferedReader br = new BufferedReader(fr);
	String[] splittArray;
	int[] points;
	int N,S,p,res;
	int T = Integer.parseInt(br.readLine());
	//System.out.println(T);

	String dummy;
	String result="";
	for(int i=1;i<=T;i++) {
		dummy=br.readLine();
		splittArray=dummy.split(" ");
		N=Integer.parseInt(splittArray[0]);
		S=Integer.parseInt(splittArray[1]);
		p=Integer.parseInt(splittArray[2]);
		res=0;
		points=new int[N];
		for(int j=3;j<splittArray.length;j++) {
			points[j-3]=Integer.parseInt(splittArray[j]);
		}
		//sortiere(points);
		
		for(int j=0;j<points.length;j++) {
			if(points[j]>=3*p-2) {
				res++;
			} else if(points[j]<3*p-2 && points[j]>=3*p-4 && 3*p-4>=0 && S>0) {
				S--;
				res++;
			}

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

	

}

