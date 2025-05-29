import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class ProblemC {
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
		ProblemC r = new ProblemC();
		String result = "";
		try{
			FileInputStream fstream = new FileInputStream("input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			int cases = Integer.parseInt(strLine);
			for (int i = 0 ; i < cases ; i++){
				String []m = br.readLine().split(" ");
				int x1 = Integer.parseInt(m[0]);
				int x2 = Integer.parseInt(m[1]);
				result += "Case #"+(i+1)+": "+r.solve(x1,x2)+"\n";
			}
			
			in.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
	    }
		r.write(result);
	}
	private String solve(int x1 , int x2) {
		String n = "";
		int c = 0;
		for (int i = x1 ; i < x2 ; i++){
			int [] x = array(i);
			for (int j = 0 ; j < x.length ; j++){
				if (x[j] <= x2 && x[j] > i){
					c++;
				//	n+= i+"   "+x[j]+"\n";
				}
			}
		}
		n += c+"";
		return n;
	}
	private int[] array(int x) {
		String m = x+"";
		int [] array = new int[m.length()];
		array[0] = x;
		for (int i = 1 ; i < m.length() ; i++){
			String g = m.substring(i,m.length())+m.substring(0,i);
			array[i] = Integer.parseInt(g);
		}
		return array;
	}
}
