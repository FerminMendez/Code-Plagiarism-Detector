import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Dancing {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader ("data/input"));
		PrintWriter pw = new PrintWriter(new FileWriter("data/output"));
		int lines = Integer.parseInt(br.readLine());
		for(int j = 0; j < lines; j++){
			String sol = "Case #" + (j+1) + ": ";
			StringTokenizer st = new StringTokenizer(br.readLine());
			int googlers = Integer.parseInt(st.nextToken());
			int surprising = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int googlerOK = 0;
			while(st.hasMoreElements()){
				int score = Integer.parseInt(st.nextToken());
				int value = score/3;
				int mod = score%3;
				if(score == 0){
					if(p==0){
						googlerOK++;
					}
				}else if(value >= p || (mod > 0 && value+1>=p)){
					googlerOK++;
				}else if(mod == 2 && value+2 >= p && surprising > 0){
					surprising--;
					googlerOK++;	
				}else if(mod < 2 && value+1 >= p && surprising > 0){
					surprising--;
					googlerOK++;
				}
			}
			pw.println(sol + ""+ googlerOK);
		}
		pw.close();

	}

}
