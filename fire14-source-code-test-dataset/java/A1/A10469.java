package QualifiactionRound;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class DancingWiththeGooglers {

	/**
	 * @param args
	 */
	
	public static void writeToFile(String text) {
        try {
                BufferedWriter bw = new BufferedWriter(
                		new FileWriter(new File("C:\\B-small-attempt5.out"), true));
                bw.write(text);
                bw.newLine();
                bw.close();
        } catch (Exception e) {
        }
}
	
	static int[] detail(String ch){
		int N=3;
		/*if(ch.charAt(1)==' ') N=Integer.parseInt((String) ch.subSequence(0, 1))            ;
		else if(ch.charAt(2)==' ') N=Integer.parseInt( (String) ch.subSequence(0, 2))            ;
		else N=Integer.parseInt((String) ch.subSequence(0, 3))            ;
		//System.out.println("N     "+N);
*/
		String dh ="";
		int[] tab=new int[N+3];
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
		tab[t]= Integer.parseInt(dh) ;
				//for(int i=0;i<tab.length;i++)
		//System.out.println(tab[i]);

		return tab;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		try{
			 
			  FileInputStream fstream = new FileInputStream("C:\\B-small-attempt5.in");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  int nbr=1;
			  strLine = br.readLine();
			  int T=Integer.parseInt(strLine);
			  System.out.println (T);
            int tab[];
            int N;
            int S;
            int p;
            int result;
            int k=0;
			  for(int i=0;i<T;i++){
		      strLine = br.readLine();
			//  System.out.println (strLine);
		      tab=detail(strLine);
		      N=tab[0];
		      S=tab[1];
		      p=tab[2];
		      result=0;
		      for(int j=0;j<N;j++){
	    			  System.out.println("val->: "+tab[3+j]);
                      
	    			  if(tab[3+j]>=p){
		    		  if(tab[3+j]/3>=p) result++;
		    		  else if ((tab[3+j]-p)/2>=p-1) result++;
		    		  else if(((tab[3+j]-p)/2>=p-2) && S>0) {
		    			  result++;
		    			  S--;
		    		  }
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
