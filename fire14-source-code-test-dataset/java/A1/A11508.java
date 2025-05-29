package DancingWithGooglers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MainProcess {

	/**
	 * @param args
	 */
	
	private Googler[] googlers ;
	
	public MainProcess(File f){
		readFile(f);
	}
	
	private void readFile(File f){
		
		int numCase = 0;
		int numGoogler = 0;
		int numSurprising = 0;
		int p = 0;
		
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
				
				numGoogler = Integer.parseInt(substr[0]);
				googlers = new Googler[numGoogler];
								
				numSurprising = Integer.parseInt(substr[1]);
				
				p = Integer.parseInt(substr[2]);
				
				for(int i=0 ; i< numGoogler ; i++){
					
					int totalScore = Integer.parseInt(substr[i+3]);
					googlers[i] = new Googler(totalScore);
				}
				
				Arrays.sort(googlers);
				findMaxNum(count ,numSurprising , p);
				
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
	
	private void findMaxNum(int count , int numSurprising , int p){
		int numMax = 0;
		
		for(int i=0 ; i< googlers.length ; i++){
			if(numSurprising >0){
								
				int maxScore = googlers[i].getMax(true);
				if(maxScore >= p ){
					numMax++;
					numSurprising--;
				}
			}
			else{
				int maxScore = googlers[i].getMax(false);
				if(maxScore >= p ){
					numMax++;
				}
			}
		}
		
		System.out.println("Case #" + (count+1) + ": " + numMax);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File(".\\src\\DancingWithGooglers\\B-small-attempt2.in");
		MainProcess m = new MainProcess(f);
	}

}
