import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Test {

	public static void main(String[] args){
		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter out = null;
		
		try{
			  fstream = new FileInputStream(args[0]);
			  in = new DataInputStream(fstream);
			  br = new BufferedReader(new InputStreamReader(in));
			  
			  fw = new FileWriter(args[1]);
			  out = new BufferedWriter(fw);
			  
			  String strLine;
			  int i = 0;
			  int tc = 0;
			 
			  while ((strLine = br.readLine()) != null)   {
				  if(i == 0){
					 tc = Integer.parseInt(strLine);
					 i++;
					 continue;
				  }
				  if( i <= tc){
					  String[] arr = strLine.split(" ");
					  int minLimit = Integer.parseInt(arr[0]);
					  int maxLimit = Integer.parseInt(arr[1]);
					  int count = 0;
					  int len = arr[0].length();
					  if(len <= 1){
						  count = 0;
					  }else{
						  for(int j = minLimit; j <= maxLimit ; j++){
							  int num = j;
							  List ls = new ArrayList();
							  for(int k = 1; k < len ; k++ ){
								  int dp = (int)Math.pow(10, len -k);
								  int mp = (int)Math.pow(10, k);
								  int first = num / dp;
								  int last = num % dp;
								  int number = last*mp + first;
								  
								  if(num != number){
									  if(number <= maxLimit && number >= minLimit){
										  if(!ls.contains(number+"")){
											  ls.add(number+"");
											  count++;
										  }
										 
									  }
								  }
								  
							  }
						  }
					  }
					  count = count/2;
					  System.out.println("Case #"+i+": "+count);
					  out.write("Case #"+i+": "+count);
					  out.write(System.getProperty( "line.separator" ));
				  }
				  i++;
			  }
			  
			  in.close();
			  out.close();
		}catch (Exception e){
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	
}


