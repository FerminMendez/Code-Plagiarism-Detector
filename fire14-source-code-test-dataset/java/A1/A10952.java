import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProblemOne {

	public static void main(String[] args) throws Exception{
		Reader reader = new Reader("A-small-attempt0.in");
		Writer writer = new Writer("output.txt");
		reader.open();
		writer.open();
		String line;
		
		while((line = reader.getNext())!=null){
			String[] parts = line.split(" ");
			int n = Integer.parseInt(parts[0]);
			int s = Integer.parseInt(parts[1]);
			int p = Integer.parseInt(parts[2]);
			
			int max = 0;
			
			for(int i = 0; i < n; i++){
				int ges = Integer.parseInt(parts[3 + i]);
				int avg = ges / 3;
				int mod = ges % 3;
				if(avg >= p){
					max++;
					continue;
				}
				if(avg == p - 1 && mod > 0){
					max++;
					continue;
				}
				if(mod == 1){
					continue;
				}
				if(avg == p - 2 && mod == 2 && s > 0 && ges >= 2){
					max++;
					s--;
					continue;
				}
				if(avg == p - 1 && mod == 0 && s > 0 && ges >= 2){
					max++;
					s--;
					continue;
				}
			}
			writer.write("" + max);
		}
		reader.close();
		writer.close();
	}
}
