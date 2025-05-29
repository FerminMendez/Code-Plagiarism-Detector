import java.io.File;
import java.io.FileWriter;
import java.util.*;


public class Recycled {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("./src/recycledS-input.txt"));
		FileWriter fw = new FileWriter("./src/recycledS-output.txt");
		int total = sc.nextInt();
		for(int turn = 1; turn <= total; turn++) {
			int res = 0;
			int A = sc.nextInt(), B = sc.nextInt();

			for(int i = A; i < B; i++) {
				//Translating the integer into an array
				String si = ""+i; 
				String Ai = ""+A;
				int li = Ai.length();
				int[] tab = new int[li];
				//fw.write("The length is " + li + "\n");
				for ( int j=0; j<li; j++) {
				  tab[j]=Integer.parseInt(""+si.charAt(j));
				}
				Set recycled = new HashSet();
				//Generating the permutations and checking the order
				for(int k =0;k<li;k++){
					int temp = tab[li-1];
					for(int j=0;j<li-1;j++){
						//fw.write(tab[j+1] + " " + tab[j]);
						tab[li-1-j]=tab[li-2-j];
					}
					tab[0]=temp;
					
					int current = 0;
					for(int j=0;j<li;j++){
						//fw.write("The current is: " + tab[li-1-j] + "\n");
						current = current + (int)Math.pow(10,j)*tab[li-1-j];
					}
					
					//fw.write(i +" Current:" + current + "\n");
					if (i < current && current<= B)
					{
						recycled.add(current);
						//fw.write(current + " " + i + "\n");
					}
					}
				res = res + recycled.size();
							
				}
			fw.write("Case #" + turn + ": " + res + "\n");

			}
		
		fw.flush();
		fw.close();
	}
}
