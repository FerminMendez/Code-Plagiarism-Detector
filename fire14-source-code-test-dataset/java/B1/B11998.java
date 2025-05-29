import java.io.*;
import java.lang.*;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.lang.Integer;
//import org.apache.commons.lang.ArrayUtils;

class Recycle 
{

 public static void circularShiftLeft(char[] arr) {
        if (arr.length == 0)
            return;

        char first = arr[0];
        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        arr[arr.length - 1] = first;
		
		
    }
	
	
 public static void main(String args[])
 {
 
		/*int[] arr = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(arr));
        circularShiftLeft(arr);
        System.out.println(Arrays.toString(arr));*/
	try
  {	
  String[] toCompare;
  
  FileWriter ostream = new FileWriter("C-small-attempt0.out");
  BufferedWriter out = new BufferedWriter(ostream);
  
  FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
  
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  int count=0;
  int resultcounter = 0;
  //StringBuilder result = new StringBuilder();
  strLine = br.readLine();
  strLine = br.readLine();
  
  do{
		//toConvert = strLine.toCharArray();
		//toCompare="";
		
		StringBuilder result = new StringBuilder();
	count++;
	result.append("Case #"+count+": ");
	
		toCompare = strLine.split(" ");
		//System.out.println(toCompare.length);
	    resultcounter = 0;
		int n =  Integer.parseInt(toCompare[0]);
		int m =  Integer.parseInt(toCompare[1]);
		
		/*char [] n1 = toCompare[0].toCharArray();
		char [] m1 = toCompare[1].toCharArray();*/
		
		char [] n1;
		char [] m1; 
				//System.out.println(n+ " : "+Arrays.toString(n1));
			    //System.out.println(m+ " : "+Arrays.toString(m1));
				
		for(;n<m-1;n++)
		{
			int m2=m;
			for(;m2>n+1;m2--)
			{
					n1 = (new Integer(n)).toString().toCharArray();
					m1 = (new Integer(m2)).toString().toCharArray();
					
					for(int index=0; index<m1.length; index++)
					{
						String nn = new String(n1);
						String mm = new String(m1);
						//System.out.println("Compare : "+ nn + " -- "+mm);
						if(nn.equals(mm))
						{
								System.out.print(nn + " : " +mm+"\t");
								resultcounter++;
						}
						circularShiftLeft(n1);
					}					
					/*System.out.println("n,m : " + n + " : "+m2+ " : "+Arrays.toString(n1)+" Length: "+n1.length);
					circularShiftLeft(n1);
					System.out.println(Arrays.toString(n1));*/
			}
		}
		System.out.println("---------------------------------- " + resultcounter);
		//System.out.println("n - m" + n + m);
		
		
	result.append(resultcounter);
	out.write(result.toString());
	out.newLine();
 
  }while ((strLine = br.readLine()) != null);
out.close();
  in.close();
  }
  catch(Exception e)
  {
  System.err.println("Error: " + e.getMessage());
  }
  
}

}

