import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			  // Open the file that is the first 
			  // command line parameter
			
			  FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  
			  FileOutputStream ostream  = new FileOutputStream("Output.txt");
			  DataOutputStream out = new DataOutputStream(ostream);
			  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			  
			  int count = Integer.parseInt(br.readLine());
			  for (int i = 0; i < count; i++)   {
				  String lineString = br.readLine();
				  String [] arrayLineString = lineString.split(" ");
				  int googlersCount = Integer.parseInt(arrayLineString[0]);
				  
				  if (googlersCount > 0 && googlersCount <= 100);
				  	else break;
					  
				  int surprisingResultsCount = Integer.parseInt(arrayLineString[1]);
				  
				  if (surprisingResultsCount >= 0 && surprisingResultsCount <= googlersCount);
				  	else break;
				  
				  int maxNumber = Integer.parseInt(arrayLineString[2]);
				  
				  if (maxNumber >= 0 && maxNumber <= 10);
				  	else break;
				  
				  int maxSumForSurprisngResults = maxNumber + (maxNumber - 2) * 2;
				  if (maxSumForSurprisngResults >=2);
				  	else maxSumForSurprisngResults = 2;
				  
				  int maxSumForNormalResults = maxNumber + (maxNumber - 1) * 2;
				  
				  int scoresArray [] = convertArrayStringToNumbers(arrayLineString, googlersCount);
				  
				  Arrays.sort(scoresArray);
				  int answerCount = 0;
				  for (int j = (scoresArray.length - 1); j >= 0; j--){
					  if (scoresArray[j] >= 0 && scoresArray[j] <= 30);
					  	else break;
					  
					  if (scoresArray[j] >= maxSumForNormalResults){
						  answerCount++;
					  }
					  else if (scoresArray[j] >= maxSumForSurprisngResults){
							  if (surprisingResultsCount > 0){
								  surprisingResultsCount--;
								  answerCount++;
							  }
							  else break;
							}
					  else break;	  
				  }
				   bw.write("Case #" + (i+1) + ": " + answerCount);
				   bw.newLine();
				   bw.flush();				  
					  
			  }
			  //Close the input stream
			  in.close();
			  out.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}

	private static int [] convertArrayStringToNumbers(String[] arrayLineString, int count) {
		// TODO Auto-generated method stub
		int array [] = new int[count];
		for (int i = 3; i < arrayLineString.length; i++){
			array[i-3] = Integer.parseInt(arrayLineString[i]);
		}
		return array;
	}

}
