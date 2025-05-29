package gcj.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public interface Case {
	
	public void init(int caseNum, BufferedReader br) throws Exception;
	
	public void solve() throws Exception;
	
	public void generateOutput(BufferedWriter bw, boolean needBR) throws Exception;

}
