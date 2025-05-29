import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
  
public class Hw3 {

	public static int calNum(int n1, int n2){
	int num = 0;
	int i =0;
	for( i=n1; i<=n2; i++){
		String t = Integer.toString(i);
		int len = t.length();
		String shitString = t;
		//System.out.println("Origin "+ t);

		for(int tt=1; tt<len; tt++){
			String tmpString = shitString.substring(1, len);
			tmpString =tmpString+ shitString.substring(0,1);
			//System.out.println(" shit "+ tmpString);
			shitString = tmpString;
			int tmpNum = Integer.parseInt(shitString);
			if(tmpNum>i && tmpNum>=n1 && tmpNum<=n2)
				num++;
		}
		
	}
	
	return num;
}


	public static void main(String[] args) throws IOException {
		 //String line, ArrayList<Integer> sTree, 

		 
	      FileReader reader = new FileReader("/Users/leyu/Desktop/C.in");   
	      
	      BufferedReader br = new BufferedReader(reader);   
	      String s1 = "";   
	      int count = 0;
	      
//	      
//	      Map<String, Integer> triMap = new HashMap<String, Integer>();
//	      Map<String, Integer> mp0 = new HashMap<String, Integer>();
//	      Map<String, Integer> mpLine = new HashMap<String, Integer>();
//	      
	      int num = 0;
	      s1 = br.readLine();
	      count = Integer.parseInt(s1);
	      for( int i = 0; i<count ; i++){
	    	  s1 = br.readLine();
	    	  String []words = s1.split(" ");	
	    	  int n1 = Integer.parseInt(words[0]);
	    	  int n2 = Integer.parseInt(words[1]);
	    	  num = calNum(n1, n2);
	    	  System.out.println("Case #"+(i+1)+": "+num);
	      }


	       
	     br.close();   
	     reader.close();   
			
		}


}
