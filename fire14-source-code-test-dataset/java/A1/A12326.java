package gcj.main;

import gcj.cases.competition.qualification_round_2012.CaseB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

	
	public static final void main (String[] args) throws Exception{
//		doTask("taskTeszt0", "/home/dev/Letöltések/0-teszt-practice.in", "/home/dev/Letöltések/0-teszt-practice.out", new Case0());
//		doTask("taskSmall0", "/home/dev/Letöltések/A-small-attempt0.in", "/home/dev/Letöltések/A-small-attempt0.out", new Case0());
		
//		doTask("taskTesztB", "/home/dev/Letöltések/B-teszt-practice.in", "/home/dev/Letöltések/B-teszt-practice.out", new CaseB());
		doTask("taskSmallB", "/home/dev/Letöltések/B-small-attempt0.in", "/home/dev/Letöltések/B-small-attempt0.out", new CaseB());
//		doTask("taskLargeB", "/home/dev/Letöltések/B-large-practice.in", "/home/dev/Letöltések/B-large-practice.out", new CaseB());
		
//		doTask("taskTesztC", "/home/dev/Letöltések/C-teszt-practice.in", "/home/dev/Letöltések/C-teszt-practice.out", new CaseC());
//		doTask("taskSmallC", "/home/dev/Letöltések/C-small-attempt0.in", "/home/dev/Letöltések/C-small-attempt0.out", new CaseC());
//		doTask("taskLargeC", "/home/dev/Letöltések/C-large.in", "/home/dev/Letöltések/C-large.out", new CaseC());
		
		doTask(null, null, null, null); //because i hate the 'never used locally' warning... 
	}

	
	private static final void doTask(String taskID, String inpFilePath, String outFilePath, Case c) throws Exception {
		if(taskID == null) return;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String strLine;
		int caseNum = 0;
		System.out.println(taskID + " strated...");
		try{
			{
				//open files
				br = new BufferedReader(new FileReader(new File(inpFilePath)));
				bw = new BufferedWriter(new FileWriter(new File(outFilePath)));
			}
			{
				//read caseNum value
				if ((strLine = br.readLine()) != null){
					caseNum = Integer.parseInt(strLine);	
				}
				System.out.println("CaseNum: "+caseNum);
			}
			for(int i=0; i<caseNum; i++){			
				System.out.println("\tprocessing Case #: "+(i+1));
				//load case
				c.init(i+1, br);
				//processing case
				c.solve();
				//write to file
				c.generateOutput(bw, i<caseNum-1);
			}
		}catch(Exception e){
			System.out.println(taskID + " failed!");
			e.printStackTrace();
		}finally{
			//end
			if(br!=null) br.close();
			if(bw!=null) bw.close();
			System.out.println(taskID + " finished.");
		}
	}
}
