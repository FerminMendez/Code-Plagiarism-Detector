import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DancingWithTheGooglers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new FileReader(new File("B-small-attempt0.in")));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("out")));
		
		int T = Integer.parseInt(reader.readLine());
		
		for(int i = 0;i<T;i++){
			String line = reader.readLine();
			String[] splits = line.split(" ");
			int N = Integer.parseInt(splits[0]);
			int S = Integer.parseInt(splits[1]);
			int p = Integer.parseInt(splits[2]);
			
			int not_sp  = 3*p - 2;
			int sp_up   = 3*p - 3;
			int sp_down = 3*p - 4;
			int result  = 0;
			
 			for(int j = 3;j<splits.length;j++){
				int num = Integer.parseInt(splits[j]);
				if(num >= not_sp){
					result ++;
				}
				else if(num >= sp_down&&num<=sp_up&&num>=p){
					if(S>0){
						result ++;
						S--;
					}		
				}
 			}
 			
 			writer.write("Case #"+(i+1)+": "+result+"\n");
 			writer.flush();
		}
		
		
	}

}
