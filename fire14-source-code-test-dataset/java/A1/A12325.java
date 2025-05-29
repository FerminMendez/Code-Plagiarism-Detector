package gcj.cases.competition.qualification_round_2012;

import gcj.main.Case;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class CaseB implements Case{
	
	private int caseNum;
	private int googlersCount;
	private int surpCount;
	private int s;
	private int[] points;
	private int solution;
	

	@Override
	public void init(int caseNum, BufferedReader br) throws Exception {
		String strLine;
		{
			//caseNum
			this.caseNum = caseNum;
			System.out.println("Act case: " + this.caseNum);
		}
		{
			//param 1, alldatas
			if ((strLine = br.readLine()) != null){
				String[] p = strLine.split(" ");
				googlersCount = Integer.parseInt(p[0]);
				surpCount = Integer.parseInt(p[1]);
				s = Integer.parseInt(p[2]);
				points = new int[googlersCount];
				for(int i=3; i< 3+googlersCount; i++){
					points[i-3] = Integer.parseInt(p[i]);
				}
			}else{
				throw new Exception("Wrong input");
			}
		}
	}

	
	@Override
	public void solve() throws Exception {
		solution=0;
		for(int i=0; i< points.length; i++){
			if(s>points[i]){
				continue;
			}else 
				if(points[i] >= (s*3-2<0?0:s*3-2)){
				solution++;
			}else if(points[i] >= (s*3-4<0?0:s*3-4) && surpCount > 0){
				surpCount--;
				solution++;
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
