import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class DancingGooglers {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	try {
	    FileInputStream fstream = new FileInputStream("D:/work/java dev/Google code jam 2012/bin/B-small-attempt0.in");
	    // Get the object of DataInputStream
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    String numberOfTest = reader.readLine();
	    Integer T = Integer.valueOf(numberOfTest);
	    File resultFile = new File("D:/work/java dev/Google code jam 2012/bin/BRes.txt");
	    FileWriter writer = new FileWriter(resultFile);
	    PrintWriter pWriter = new PrintWriter(writer);
	    for(int j=0;j<T;j++){
		String[] dataset =  reader.readLine().split(" ");
		Integer N = Integer.valueOf(dataset[0]);
		Integer S = Integer.valueOf(dataset[1]);
		Integer p = Integer.valueOf(dataset[2]);
		int numberQualified = 0;
		int surprisingResultFound = 0;
		for(int i=0;i<N;i++){
		    int[] result = getNormalResult(Integer.valueOf(dataset[i+3]));
		    if(isQualified(result,p)){
			numberQualified++;
		    }else if(surprisingResultFound<S){
			if(isPossibleQualifiedSurprisingResult(result, p)){
			    numberQualified++;
			    surprisingResultFound++;
			}
		    }
		}
		pWriter.println("Case #"+(j+1)+": "+numberQualified);
	    }
	    pWriter.flush();
	    pWriter.close();
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private static int[] getNormalResult(int totalScore) {
	int[] result = new int[3];
	int max = totalScore / 3;
	result[0] = max;
	result[1] = max;
	result[2] = max;
	int i = 0;
	while (totalScore - (result[0] + result[1] + result[2]) > 0) {
	    result[i] += 1;
	    i++;
	}
	return result;
    }
    
    private static boolean isPossibleQualifiedSurprisingResult(int[] result,int bestResult){
	Arrays.sort(result);
	if(result[2]>=bestResult-1){
	    if((bestResult-(result[1]-1)<=2 && result[1]>0)||(bestResult-(result[0]-1)<=2&& result[0]>0)){
		return true;
	    }
	}
	return false;
    }
    
    private static boolean isQualified(int[] result, int qualification){
	boolean boolResult = false;
	for(int i = 0;i<result.length;i++){
	    if(result[0]>=qualification){
		return true;
	    }
	}
	return boolResult;
    }
}
