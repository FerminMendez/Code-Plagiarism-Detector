package QualifiactionRound;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	
	public static void writeToFile(String text) {
        try {
                BufferedWriter bw = new BufferedWriter(
                		new FileWriter(new File("C:\\C-small-attempt0.out"), true));
                bw.write(text);
                bw.newLine();
                bw.close();
        } catch (Exception e) {
        }
}
	
	
	public static int isRecycled(int n,int m)
	{   String ch=String.valueOf(m);
	    String dh;
		for(int i=0;i<ch.length();i++){
		   dh=ch.substring(i, ch.length())+ch.substring(0, i);
		   if(Integer.parseInt(dh)==n) return 1;
		}

		return 0;
	}
	
	static int[] detail(String ch){
		String dh ="";
		int[] tab=new int[2];
		int t=0;
		for(int i=0;i<ch.length();i++){
			if(ch.charAt(i)==' ') { 
				tab[t]=  Integer.parseInt(dh)            ;
				dh="";
				t++;
			}
			else
			dh=dh+ch.charAt(i);
		}
		tab[t]=Integer.parseInt(dh)            ;
		System.out.println(tab[0]);
		System.out.println(tab[1]);

		return tab;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			 
			  FileInputStream fstream = new FileInputStream("C:\\C-small-attempt0.in");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  int nbr=1;
			  strLine = br.readLine();
			  int T=Integer.parseInt(strLine);
			  System.out.println (T);
              int tab[]=new int[2];
              int A;
              int B;
              int result;
			  for(int i=0;i<T;i++){
		      strLine = br.readLine();
			//  System.out.println (strLine);
		      tab=detail(strLine);
		      A=tab[0];
		      B=tab[1];
		      result=0;
		      for(int n=A;n<=B;n++){
		    	  for(int m=B;m>=A;m--){
		    		  if((m>n) && isRecycled(n, m)==1) 
		    			  result++;
		    			  
		    	  }
			 
		      }
				  writeToFile("Case #"+nbr+": "+result);
				  System.out.println ("Case #"+nbr+": "+result);

			 
			  nbr++;
			  }
			  in.close();
			    }
		 catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
			  }

	}
	}


