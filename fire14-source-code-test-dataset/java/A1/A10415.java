import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class google2 {

	
	public static String translate(String l, int index){
		String[] strarray=l.split(" ");
		int N = Integer.valueOf(strarray[0]);
		int S = Integer.valueOf(strarray[1]);
		int p = Integer.valueOf(strarray[2]);
		int right=0;
		int realS=0;
		int resultnb=0;
		if (p>=2){
	      for (int i = 3; i < strarray.length; i++){
	    	  int tmp = Integer.valueOf(strarray[i]);
	    	  if (tmp>=(3*p-2)){
	    		  right +=1;
	    	  } else if (tmp>=(3*p-4)){
	    		  realS+=1;
	    	  }
	      }
	      resultnb =  (right+Math.min(realS, S));
		} else {
			for (int i = 3; i < strarray.length; i++){
		    	  int tmp = Integer.valueOf(strarray[i]);
		    	  if (tmp>=p){
		    		  resultnb +=1;
		    	  }
			}
		}
	 
	     String result = "Case #"+(index+1)+": "+resultnb;
	     return result;
	      }
	
	public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("input.txt"));
            outputStream = new PrintWriter(new FileWriter("output.out"));
            
            //inputStream.readLine();
            int nbLines = Integer.valueOf(inputStream.readLine());           
            //outputStream.println("Output");
            for (int i = 0 ; i< nbLines-1;i++){
                String l;
                l = inputStream.readLine();
                outputStream.println(translate(l,i));
            }
            String l= inputStream.readLine();
            outputStream.print(translate(l,nbLines-1));
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
