package RecycledNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

import DancingWithGooglers.Googler;



public class MainProcess {

	/**
	 * @param args
	 */
	
	private int A ;
	private int B ;
	
	public MainProcess(File f){
		readFile(f);
		
	}
	
	private void readFile(File f){
		
		int numCase = 0;
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String str = "";
			
			if( (str = br.readLine())!=null){
				numCase = Integer.parseInt(str);
			}
			
			int count = 0;
			while( count < numCase){
				str = br.readLine();
				String[] substr = str.split(" ");
				A = Integer.parseInt(substr[0]); 
				B = Integer.parseInt(substr[1]); 
				
				findAns(count ,substr[0].length());
				count++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void findAns(int count , int numDigit){
		
		int totalPair=0;
		
		if(numDigit<=1){
			System.out.println("Case #" + (count+1) + ": 0");
		}
		else{
			
			for(int i=A ; i<=B ; i++){
				totalPair += findPair(i , numDigit);
			}
			
			System.out.println("Case #" + (count+1) + ": " + totalPair);
		}
	}
	
	private int findPair(int number , int numDigit){
		Hashtable<Integer , Boolean> usedTable = new Hashtable<Integer , Boolean>();
		
		int numPair =0;
		
		for(int i=1 ; i<numDigit ; i++ ){
			int base = getPower(i);
			int secondPart = number % base;
			int firstPart = (number - secondPart) / base;
			
			int newNumber = secondPart*getPower(numDigit - i) + firstPart;
			
			if(newNumber<=B && newNumber > number){
				if(!usedTable.containsKey(newNumber)){
					numPair++;
					usedTable.put(newNumber, true);
				}

			}
		}
		
		return numPair;
	}
	
	private int getPower(int n){
		int number = 1;
		
		if(n==0) return number;
		else{
			for(int i=0 ; i< n ; i++){
				number *=10;
			}
			
			return number;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File(".\\src\\RecycledNumbers\\C-small-attempt0.in");
		MainProcess m = new MainProcess(f);
	}

}
