import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Solver {
	Scanner inFile=null;
	PrintWriter outFile=null;
	int caseNo;
	public Solver(int caseNo){
		this.caseNo=caseNo;
	}
	public void processInput(Scanner inFile,PrintWriter outFile){
		this.inFile=inFile;
		this.outFile=outFile;
		readInput();
		produceoutput();
		
	}
	private void produceoutput() {
       
	
		//outFile.printf("Case #"+caseNo+": %d\n",candidatecount);
		
		
	}
	public void readInput(){
		String s="";
		if(inFile.hasNext()){
			//get the store credit
			int A=Integer.parseInt(inFile.next().trim());
			int B=Integer.parseInt(inFile.next().trim());
			RecycleNumber r=new RecycleNumber(A,B);
			outFile.printf("Case #"+caseNo+": %d\n",r.count);
			if(inFile.hasNext())inFile.nextLine();			
		}
	}

}
