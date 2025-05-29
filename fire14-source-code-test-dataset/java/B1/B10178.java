import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;


public class RecycledNumbers {
	public static void main(String[] args) throws Exception {
		String sb = null;
		int ans = 0;
		
		BufferedReader is = new BufferedReader(new FileReader(new File("D:\\C-small-attempt0.in")));		
		BufferedWriter os = new BufferedWriter(new FileWriter("D:\\out.txt"));
		os.flush();
		HashSet<String> hs = null;
		int loopIter = Integer.parseInt(is.readLine());
		
		for(int i=0; i<loopIter; i++){
			sb = is.readLine();
			ans = 0;
			hs = new HashSet<String>();
			String x[] = sb.split(" ");
			int start = Integer.parseInt(x[0]);
			int end = Integer.parseInt(x[1]);
			
			for(int j=start; j<=end; j++){
				String h = j + "";
				for(int k=0; k<h.length(); k++){
					h = h.substring(1) + h.substring(0,1);
					int xxx = Integer.parseInt(h);
					if(xxx != j && xxx>= start && xxx <= end){
						//System.out.println("start = " + start + ", end = " + end + ", j = " + j + ", reverse = " + h);
						hs.add("(" + j + "," + h + ")");
						ans++;
					}
				}
			}
			

			if(ans %2 != 0){
				System.out.println("FUCKED! = " + sb);			
			}

			
			os.write("Case #" + (i+1) + ": " + hs.size()/2 + "\n");
			os.flush();
		}
		
		
		
	}
}
