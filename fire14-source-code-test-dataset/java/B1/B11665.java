import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Recycled {

	
	public static void main(String[] args){
		Recycled r = new Recycled();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("C-small-attempt1.in");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  
			  int numOfTests = Integer.parseInt(br.readLine());
			  for(int i=1; i<=numOfTests; i++){
				  String itemString = br.readLine();
				  System.out.print("Case #"+i+": ");
				  long A = Long.parseLong(itemString.split(" ")[0]);
				  long B = Long.parseLong(itemString.split(" ")[1]);
				  r.countRecycled(A,B);
				  System.out.println();
			  }
			  //Close the input stream
			  in.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
	}

	private char[] shuffle(char[] numString){
		//char[] numString = (x+"").toCharArray(); 
		int i=0; 
		char temp=numString[i];
		for(i=0; i<numString.length-1; i++){
			numString[i]=numString[i+1];
		}
		numString[i]=temp;
		return numString;
	}
	private void countRecycled(long a, long b) {
		long count = 0;
//		System.out.println(a+"  "+b);
		for(long i=a; i<b; i++){
			char[] shuffleChar =(i+"").toCharArray();
			long shuffleNum = Long.parseLong(new String(shuffleChar));
			for(int j=0; j<(i+"").length()-1; j++){
				shuffleChar = shuffle(shuffleChar);
				shuffleNum = Long.parseLong(new String(shuffleChar));
				if(shuffleNum > a && shuffleNum > i && shuffleNum <=b ){
//						System.out.print(" "+i);
//						System.out.println(" shuffle: "+shuffleNum);
						count++;
				}
			}
		}
//		System.out.println();
		System.out.print(count);
	}

}
