import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Bsmall {
	
	private String [] content = new String[100];
	private String [] output = new String[100];
	private StringBuffer outputString = null;
	private int testCases = 0;
	private String outputFile ="Bsmall.out";
	private int [] n = new int[100];
	private int [] s = new int[100];
	private int [] p = new int[100];
	private int [][] t = new int[100][100];
	
	public void readFile(String fileName){
		try{
			File f = new File(fileName);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			testCases = Integer.parseInt(br.readLine());
			for(int i=0; i<testCases; i++){
				content[i]=br.readLine();
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Error in reading file");
		}
	}
	
	public void processInput(){
		for(int i=0; i<testCases; i++){
			String line = content[i];
			String[] values = line.split(" ");
			n[i] = Integer.parseInt(values[0]);
			s[i] = Integer.parseInt(values[1]);
			p[i] = Integer.parseInt(values[2]);
			for(int j=0; j<n[i]; j++){
				t[i][j] = Integer.parseInt(values[j+3]);
			}
		}
	}
	
	public void solve(){
		for(int i =0; i<testCases; i++){
			StringBuffer sb = new StringBuffer("Case #"+(i+1)+": ");
			int y = 0;
			for(int j =0; j<n[i]; j++){
				float frem = (float)t[i][j]/(float)3.0;
				int irem = t[i][j]/3;
				float rem = frem - (float)irem;
				
				if(rem > 0.5 && s[i]>0){
					if(irem+2>p[i]){
						y++;
					}
					else if(irem+2==p[i]){
						y++;
						s[i]--;
					}
				}
				else if(rem > 0){
					if(irem+1>=p[i]){
						y++;
					}
				}
				else{
					if(irem+1==p[i] && irem-1>=0 && s[i]>0){
						y++;
						s[i]--;
					}
					if(irem>=p[i]){
						y++;
					}	
				}
			}
			sb.append(y);
			output[i] = sb.toString();
		}	
	}
	public void writeFile(){
		try{		
			File f = new File(outputFile);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i =0 ; i<testCases; i++){
				bw.write(output[i]);
				bw.newLine();
			}
			bw.close();
		}
		catch(Exception e){
			System.out.println("Error in writing to file");
		}
	}
	
	public static void main(String [] args){
		
		Bsmall s = new Bsmall();
		s.readFile(args[0]);
		s.processInput();
		s.solve();
		s.writeFile();
	}
}