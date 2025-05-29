import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class App {
	public static void main (String[] args){
		
		try{
			FileInputStream fstream = new FileInputStream("input.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
			int cases = Integer.parseInt(br.readLine());
			String output = "";
			
			for(int i=1;i<=cases;i++){
				String line = br.readLine();
				String[] arr = line.split(" ");
				
				int a = Integer.parseInt(arr[0]);
				int b = Integer.parseInt(arr[1]);
				
				int count = RecyclePair.Calculate(a, b);
				
				output += "Case #"+i+": "+count;
				
				if(i+1 <= cases){
					output += "\n";
				}
			}
			
			in.close();
			System.out.println(output);
			
			FileWriter fwstream = new FileWriter("output.out");
			BufferedWriter out = new BufferedWriter(fwstream);
			out.write(output);
			out.close();
		}
		catch (Exception e) {
			
		}
		
	}
}
