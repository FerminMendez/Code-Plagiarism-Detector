import java.io.*;

public class Recycler {
	
	public static void main(String[] args) {
		
		Recycler rec = new Recycler();
		String line = "";
		BufferedReader br;
		BufferedWriter output;
		FileWriter fstream;
		int x;
		int y;
		
		try {
			br = new BufferedReader(new FileReader("C-small-attempt0.in"));        
			line = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		rec.testCases = Integer.parseInt(line);
		
		try {
			fstream = new FileWriter("output.txt");
			output = new BufferedWriter(fstream);
			br = new BufferedReader(new FileReader("C-small-attempt0.in"));
			br.readLine();
			for(int i = 1; i <= rec.testCases ;i++) {
				line = "";
				line = br.readLine();
				int j = 0;
				while( line.charAt(j) != ' ')
					j++;
				x = Integer.parseInt(line.substring(0, j));
				y = Integer.parseInt(line.substring(j+1));
				
				output.write("Case #" + i + ": " +  rec.countPairs(x, y));
				output.newLine();
			}
			output.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int countPairs(int A, int B) {
		int counter = 0;
		for(int i = A; i < B; i++) {
			for(int j = i+1; j <= B; j++){
				if(checkR(i,j)){
					counter++;
				}
			}
		}
		return counter;
	}
	
	private boolean checkR(int num1, int num2){
		String n = Integer.toString(num1) ;
		String m = Integer.toString(num2) ;
		boolean isPair = false;
		
		for(int i = m.length()-1; i > 0;i--){
			String s = n.substring(i);
			String ss = n.substring(0, i);
			String sss = s + ss;
			if(sss.equals(m)) {
				isPair = true;
				
			}
		}	
		return isPair;
	}
	
	/* private instance variables */
	private int testCases;

}
