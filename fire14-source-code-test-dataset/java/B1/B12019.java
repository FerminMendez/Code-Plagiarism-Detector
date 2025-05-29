import java.io.*;
import java.util.Scanner;


public class recycle {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		        
		Scanner scanner = new Scanner(new File("G:\\C-small-attempt0.in"));
		int num = scanner.nextInt();
		int [][] input = new int [num][2];
		int i = 0, j = 0, k = 0, mod = 1, ans1 = 1, ans2 = 1, count = 0;
		String result = null;
		int[] output = new int[num];
		while(scanner.hasNextInt()){
	        	 input[i][j] = scanner.nextInt();
	        	 j++;
	        	 if(j > 1) {
	        		 j = 0;
	        		 i++;
	        	 }
		}
		
		for(int y=0; y<num; y++) {
				
				for(int a=input[y][0]; a <= input[y][1]; a++) {
					for(int b=(a+1); b<=input[y][1]; b++) {
						
						while(ans2 != 0) {
							
							mod = mod * 10;
							ans1 = b % mod;
							ans2 = b / mod;
							if(ans2 != 0 && ans1 != 0) {
								result = Integer.toString(ans1) + Integer.toString(ans2);
								ans1 = Integer.parseInt(result);
								
								if(a == ans1) {
									count++;
									ans1 = 1;
									ans2 = 1;
									mod = 1;
									break;
								}
							}
						}
						ans1 = 1;
						ans2 = 1;
						mod = 1;
					}
				}
				output[y] = count;
				count = 0;
		}
		
		FileWriter fstream = new FileWriter("G:\\output.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        
		for(int y=0; y<num; y++) {
			for(int z=0; z<2; z++) {
			System.out.print(input[y][z] + " ");
			}
			System.out.print("=> " + output[y]);
			String answer = "Case #" + (y+1) + ": " + Integer.toString(output[y]) + "\r\n";
	        out.write(answer);
			System.out.println("");
		}
		
		out.close();
		fstream.close();
	}

}
