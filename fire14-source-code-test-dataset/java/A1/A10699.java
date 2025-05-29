import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Dancing {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// read input file
		File file = new File("B-small-attempt4.in");
		//File file = new File("input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String ln = "";
		int count = Integer.parseInt(br.readLine());

		// write output file
		File out = new File("outB.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(out));
		
		int y = 0;
		for (int i=0; i < count; i++){
			ln = br.readLine();
			y = getY(ln);
			bw.write("Case #" + (i+1) + ": " + y);
			bw.newLine();
		}
		bw.close();
	}
	
	private static int getY(String str) {
		String[] data = str.split(" ");
		int n = Integer.parseInt(data[0]);
		int s = Integer.parseInt(data[1]);
		int p = Integer.parseInt(data[2]);
		int[] t = new int[n];
		for (int i=0; i < n; i++){
			t[i] = Integer.parseInt(data[i+3]);
		}
		int y = 0;
		int base = 0;
		for(int j=0; j < t.length; j++){
			base = t[j] / 3;
			if(base >= p) { y++; }
			else if(base == p-1){
				if(t[j] - (base+p) > base-1 && t[j] > 0){
					y++;
				} else if(s>0 && t[j] - (base+p) > base-2 && t[j] > 0){
					s -= 1;
					y++;
				}
			} else if(base == p-2){
				if(s > 0 && t[j] - (base+p) > base-1 && t[j] > 0){
					s -= 1;
					y++;
				}
			}
		}
		
		return y;
	}

}
