import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Solver {
	Scanner inFile=null;
	PrintWriter outFile=null;
    int N=0;//number of googlers
    int S=0;//surprising triplet
    int p=0;
    int t[];
	int caseNo;
	int candidatecount=0;
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
       
	
		outFile.printf("Case #"+caseNo+": %d\n",candidatecount);
		
	}
	public void readInput(){
		String s="";
		if(inFile.hasNext()){
			//get the store credit
			N=Integer.parseInt(inFile.next().trim());
			S=Integer.parseInt(inFile.next().trim());
			p=Integer.parseInt(inFile.next().trim());
			
			t=new int[N];
			for(int i=0;i<N;i++){
				t[i]=Integer.parseInt(inFile.next().trim());
				Goggledance d=new Goggledance(t[i],p);
				if(d.isCandidate()&& !d.isSurprising()){
					candidatecount++;
				}
				else if(d.isCandidate()&& d.isSurprising() && S>0){
					candidatecount++;
					S--;
				}
			}
			if(inFile.hasNext())inFile.nextLine();			
		}
	}

}
