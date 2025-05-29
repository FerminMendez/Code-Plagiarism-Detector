import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Google {
	public static void main(String args[]) throws Exception {
		Google g = new Google();
		g.run("texto.txt");
	}
	
	void run(String file) throws Exception {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine();
		String line = br.readLine();
		
		
		FileWriter fw = new FileWriter("saida.txt");
		PrintWriter pw = new PrintWriter(fw);

		
		int n2 = 1;
		while(line != null) {
			System.out.println("dddd");
			String[] nums = line.split(" ");
			int n = Integer.parseInt(nums[0]);
			int numSurprising = Integer.parseInt(nums[1]);
			int p = Integer.parseInt(nums[2]);
			int output = 0;
			
			int numNotas = nums.length - 3; 
			int[] notas = new int[numNotas];
			
			for(int i = 3, j=0; i < nums.length; i++,j++) {
				notas[j] = Integer.parseInt(nums[i]);
			}
			
			ArrayList<Integer> possiveis = new ArrayList<Integer>();
			ArrayList<Integer> talvez = new ArrayList<Integer>();
			
			if(p==0) {
				possiveis.add(0);
			}
			if(p==1) {
				possiveis.add(3);
				possiveis.add(2);
				possiveis.add(1);
			} else if(p>1) {
				possiveis.add(p + p + p);
				possiveis.add(p + p + (p-1));
				possiveis.add(p + (p-1) + (p-1));
				
				talvez.add(p + p + (p-2));
				talvez.add(p + (p-1) + (p-2));
				talvez.add(p + (p-2) + (p-2));
			}
			
			for(int i = 0; i < notas.length; i++) {
				if(notas[i] > (p+p+p)) {
					output++;
				} else if(possiveis.contains(notas[i])) {
					output++;
				} else if(talvez.contains(notas[i])) {
					if(numSurprising > 0) {
						output++;
						numSurprising--;
					}
				}
			}
			
			pw.println("Case #" + n2 + ": " + output);
			
			line = br.readLine();
			n2++;
		}
		
		pw.close();
		br.close();
	}
}