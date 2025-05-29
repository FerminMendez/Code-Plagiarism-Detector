package gcj.cases.competition.qualification_round_2012;

import gcj.main.Case;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.HashSet;
import java.util.Set;

public class CaseC implements Case{
	
	private int caseNum;
	private long min;
	private long max;
	private long solution;
	

	@Override
	public void init(int caseNum, BufferedReader br) throws Exception {
		String strLine;
		{
			//caseNum
			this.caseNum = caseNum;
			System.out.println("Act case: " + this.caseNum);
		}
		{
			//param 1, min max
			if ((strLine = br.readLine()) != null){
				String[] p = strLine.split(" ");
				min = Long.parseLong(p[0]);
				max = Long.parseLong(p[1]);
			}else{
				throw new Exception("Wrong input");
			}
		}
	}

	
	@Override
	public void solve() throws Exception {
		solution=0l;
		for(long nIter = min; nIter<max; nIter++){
			String nValue = "" + nIter;
			Set<Long> mPairs = new HashSet<Long>();
			for(int i=0; i<nValue.length()-1; i++){
				String nRecicled = nValue.substring(i+1) + nValue.substring(0, i+1);
				long m = Long.parseLong(nRecicled);
				if(m>nIter && m<=max && !mPairs.contains(m)){
					solution++;
					mPairs.add(m);
				}
			}
		}
	}
	
	
	@Override
	public void generateOutput(BufferedWriter bw, boolean needBR) throws Exception {
		bw.write("Case #" + this.caseNum + ": " + this.solution);
		if(needBR){
			bw.newLine();
		}
	}


}
