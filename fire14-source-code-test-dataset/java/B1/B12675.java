import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class recycle {
	public static void main(String[] args) {
		int lines;
		String input;
		StringTokenizer strk;
		int start=1111;
		int end=2222;
		int count;
		
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader("C-large.in"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			
			lines = Integer.parseInt(inputStream.readLine());
			for(int line=0; line< lines; line++){
				count=0;
				input = inputStream.readLine();
				strk = new StringTokenizer(input," ");
				start = Integer.parseInt(strk.nextToken());
				end = Integer.parseInt(strk.nextToken());
				
				for(int j=start; j<=end;j++){
					for(int k=j; k<=end;k++){
						if(isRecycled(j+"",k+"")){
							count++;
						}
					}
				}
				
				if(line!=lines-1)
					writer.write("Case #" + (line+1) + ": " + count+"\r\n");
				else
					writer.write("Case #" + (line+1) + ": " + count);
				
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean isRecycled(String x, String y){
		int len  = x.length();
		if(x.equals(y)){
			return false;
		}
		for(int i=0; i<len;i++){
			if(x.equals(y)){
				return true;
			}
			//shift
			x = (x.substring(1) + x.charAt(0));
		}
		return false;
	}
}
