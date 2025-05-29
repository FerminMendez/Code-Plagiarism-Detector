import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class ProblemB {
	public void write(String m){
		try{
			FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(m);
			out.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: in writing" + e.getMessage());
		}
	}
	public static void main(String[] args) {
		ProblemB r = new ProblemB();
		String result = "";
		try{
			FileInputStream fstream = new FileInputStream("input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			int cases = Integer.parseInt(strLine);
			for (int i = 0 ; i < cases ; i++){
				String []m = br.readLine().split(" ");
				int size =0 ;
				int surprise=0;
				int high=0;
				int c = 0;
				int value = 0;
				for (int j = 0 ; j < m.length ; j++){
					if (j == 0)
						size = Integer.parseInt(m[j]);
					else if(j ==1)
						surprise = Integer.parseInt(m[j]);
					else if (j ==2){
						high = Integer.parseInt(m[j]);
						if (high < 2)
							high = high + 0 + 0;
						else
							high = high + (high-2) + (high-2);
					}
					else {
						value = Integer.parseInt(m[j]);
						if (value >= high && value <= 30){
							if (high < 2){
								c++;
							}
							else if(value == high || (value-high) ==1){
								if (surprise > 0){
									surprise--;
									c++;
								}
							}
							else
								c++;
						}
					}
				}
				result += "Case #"+(i+1)+": "+c+"\n";
			}
			
			in.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
	    }
		r.write(result);
	}
}
