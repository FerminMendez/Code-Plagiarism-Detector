import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;


public class ProblemB {

	/**
	 * @param args
	 * Ahmed Kammorah
	 */
public static void main(String[] args) {
		
		ProblemB problem=new ProblemB();
		
		problem.MainAlgorithm();
		problem.closeFiles();
	}
	
	ReadFile readFile;
	writeOutputFile writeOutputFile;
	
	public ProblemB() {
		
		readFile=new ReadFile("B-small-attempt0.in");
		writeOutputFile = new writeOutputFile("B-small.out");
		
		//readFile=new ReadFile("B-large-attempt0.in");
		//writeOutputFile = new writeOutputFile("B-large.out");
	}	
	
	
	
	
	void MainAlgorithm(){
		
		
		int N= Integer.parseInt(readFile.readNextLineScan());
		
		
		int a=0,b=0,c=0;
		
		for(int i=1; i <=N ; i++){
			int NumGoogler=readFile.readNextIntScan();
			int S=readFile.readNextIntScan();
			
			int P=readFile.readNextIntScan();
			int maxG=0;
			for(int j=1 ; j <= NumGoogler ; j++){
				int GScore = readFile.readNextIntScan();
				
				
				a=GScore/3;
				b=(GScore-a)/2;
				c=GScore-(a+b);
				if(a <P || b<P || c<P){
					a= (GScore/3);
					b=((GScore-a)-1)/2;
					c=GScore-(a+b);
					//System.out.println("( "+c+" )S"+S);
					
					if( S>0 && c >= P && ( (a<=10 && a>=0) && (b<=10 && b>=0) && (c<=10&&c>=0) )){
						//System.out.println("( "+c+" )"+P);
						//S--;
					}else{
						a=GScore/3;
						b=(GScore-a)/2;
						c=GScore-(a+b);
					}
				}
				
				
				
				
				
				//System.out.println("( "+a+" , "+b+" , "+c+" )");
				if(a >= P || b >= P || c >= P){
					maxG++;
				}
				
				if(Math.abs(a-b)==2 || Math.abs(a-c)==2 || Math.abs(b-c)==2){
					S--;
				}
				
			}
			
			writeOutputFile.writeLineToOut("Case #" + i +": "+maxG+"\n");
			
		}
		
		
		
	}
	
	
	public void closeFiles(){
		readFile.closeFile();
		writeOutputFile.closeOutFile();
	}
	
	
}// end problem class





class writeOutputFile {
		
		BufferedWriter dataOut;
		FileWriter fileOut;
		public writeOutputFile(String fileOutput) {
			try {
				
				//File file= new File(getClass().getResourceAsStream(fileOutput).toString());
				fileOut =new FileWriter(fileOutput);
				dataOut = new BufferedWriter(fileOut);
				
			} catch (IOException e) {
				System.out.println(" constractor  out file ...");
				e.printStackTrace();
			}
			
		}
		
		public void writeLineToOut(String line){
			try {
				dataOut.write(line);
				
				
			} catch (IOException e) {
				System.out.println(" write  out file ...");
				e.printStackTrace();
			}
		}
		
		
		
		public void closeOutFile(){
			
			try {
				dataOut.close();
				fileOut.close();
			} catch (IOException e) {
				System.out.println(" close  out file ...");
				e.printStackTrace();
			}
		}
		

	}

	




class ReadFile {
	
	//InputStream fileStream;
	//DataInputStream data;
	Scanner scanner;
	
	
	public ReadFile(String fileName) {

		scanner = new Scanner(getClass().getResourceAsStream(fileName));
		
	}
	

	
	
	public int readNextIntScan(){

		return scanner.nextInt();
		
	}
	
	public char readNextChar(){
		return (char)scanner.nextByte();
	}
	
	public String readNextLineScan(){
		return scanner.nextLine();
	}
	
	
	public void closeFile(){
		scanner.close();

	}
	
	
}

